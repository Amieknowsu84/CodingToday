class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int count1=0,count2=0;
        Integer majority1=null,majority2=null;
        
        //moore algorithm
        for(int i=0;i<nums.length;i++){
            if(majority1!=null && nums[i] == majority1){
                count1++;
            }else if(majority2!=null && nums[i] == majority2){
                count2++;
            }else if(count1 == 0){
                majority1=nums[i];
                count1=1;
            }else if(count2 == 0){
                majority2=nums[i];
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        
        //verification
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == majority1){
                count1++;
            }else if(nums[i] == majority2){
                count2++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        int min = (int)Math.floor(nums.length/3);
        if(count1>min){
            result.add(majority1);
        }
        
        if(count2>min){
            result.add(majority2);
        }
        
        return result;
    }
}