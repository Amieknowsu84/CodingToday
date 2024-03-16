class Solution {
 public int majorityElement(int[] nums) {
       Map<Integer,Long> map = Arrays.stream(nums).boxed()
                 .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        
    int cnt = nums.length/2;
     
    return map.entrySet().stream().filter(entry->entry.getValue()>cnt)
                .findFirst().get().getKey();
    }
}