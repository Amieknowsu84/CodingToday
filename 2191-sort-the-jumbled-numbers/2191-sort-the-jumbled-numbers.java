class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> indexMap = new HashMap<>();
        Integer[] nums1 = new Integer[nums.length];
        int index = 0;
        for(int elem: nums){
            map.put(elem,convert(elem, mapping));
            //System.out.println(elem+" "+map.get(elem));
            indexMap.put(elem,index);
            nums1[index++] = elem;
        }
        
        Arrays.sort(nums1,(a,b)->{
            int val = map.get(a)-map.get(b);
            if(val == 0){
                return indexMap.get(a)-indexMap.get(b);
            }else{
                return val;
            }
        });
        
        for(int i=0;i<nums1.length;i++){
            nums[i] = nums1[i];
        }

        return nums;
    }
    
    int convert(int num, int[] data){
        int newNum = 0;
        
        int numLength = (num+"").length();
        int i = 0;
        while(numLength > 0){
            int current = num % 10;
            newNum = ((int)Math.pow(10,i++) * data[current]) + newNum;
            num = num / 10;
            numLength--;
        }
        
        return newNum;
    }
}