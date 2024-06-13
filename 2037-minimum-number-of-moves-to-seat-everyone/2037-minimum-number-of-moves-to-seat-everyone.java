class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        //greedy
        int[] seatsMap = new int[101];
        int[] studentsMap = new int[101];
        
        for(int seatPosition: seats){
            seatsMap[seatPosition]++;
        }
        
        for(int studentPosition: students){
            studentsMap[studentPosition]++;
        }
        
        int i = 0;
        int j = 0;
        
        int move = 0;
        
        while(i<seatsMap.length && j<studentsMap.length){
            if(i == 0){
                i++;
            }else if(j == 0){
                j++;
            }else{
                if(seatsMap[i]<studentsMap[j]){
                    move+= Math.abs(i-j)*seatsMap[i];
                    studentsMap[j]-= seatsMap[i];
                    seatsMap[i] = 0;
                    i++;
                }else if(seatsMap[i]>studentsMap[j]){
                    move+= Math.abs(i-j)*studentsMap[j];
                    seatsMap[i]-= studentsMap[j];
                    studentsMap[j] = 0;
                    j++;
                }else{
                   move+= Math.abs(i-j)*studentsMap[j];
                   seatsMap[i] = studentsMap[j] = 0;
                   i++;
                   j++;
                }
            }
        }
        
        return move;
        
    }
}