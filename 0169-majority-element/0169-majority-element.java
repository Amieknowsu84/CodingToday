class Solution {
    public int majorityElement(int[] nums) {
       Map<Integer,Long> map = Arrays.stream(nums).boxed()
                 .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        
        Optional<Map.Entry<Integer, Long>> maxEntry =  map.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        
        return maxEntry.get().getKey();
    }
}