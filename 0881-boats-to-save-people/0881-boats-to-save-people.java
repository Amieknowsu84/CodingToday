class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        // greedy pair up min weight and max weight to get it up on board
        // ofcourse in sorted array
        // if sum > limit right one is boarded i.e heavy one is given seperate boat
        
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