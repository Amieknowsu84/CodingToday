class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        int result[] = new int[nums.length];
        int index = nums.length-1;
        while(left <= right){
            
            if(Math.pow(nums[left],2)<Math.pow(nums[right],2)){
                result[index] = nums[right]*nums[right];
                right--;
            }else{
                result[index] = nums[left]*nums[left];
                left++;
            }
            index--;
        }
        
        return result;
    }
}