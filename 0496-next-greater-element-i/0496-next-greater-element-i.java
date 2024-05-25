class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        int[] result = new int[nums1.length];
        Arrays.fill(result,-1);
        
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i],i);
        }
        
        //store them in decreasing order whenever found 
        //bigger element it will be next greater element for all the lower elements
        
        for(int i=0;i<nums2.length; i++){
            int current = nums2[i];
            
            while(!stack.isEmpty() && stack.peek() < current){
                int element = stack.pop();
                if(map.containsKey(element)){
                    int index = map.get(element);
                    result[index] = current;
                }
            }
            
            stack.add(current);
        }
        
        return result;
        
    }
}