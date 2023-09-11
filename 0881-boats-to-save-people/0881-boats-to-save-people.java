class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            int sum = (left == right) ? people[left] :people[left] + people[right];
            if(sum <= limit){
                left++;
                right--;
            }
            else{
                right--;
            }
            
            boatCount++;
        }
        return boatCount;
    }
}