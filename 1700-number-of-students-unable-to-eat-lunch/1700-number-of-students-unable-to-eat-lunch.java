class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] foodPref = {0,0};
        for (int student : students) {
            foodPref[student]++;
        }
        int index = 0;
        for (; index < sandwiches.length && foodPref[0] >= 0 && foodPref[1] >= 0; index++) {
            foodPref[sandwiches[index]]--;
        } 
        int hungry = sandwiches.length - index;
        // if foodPref drops below 0, then you need to add 1 to hungry student as current sandwich(index) cannot be given to any student
        hungry += (foodPref[0] < 0 || foodPref[1] < 0 ) ? 1 : 0;
        return hungry;
    }
    
}