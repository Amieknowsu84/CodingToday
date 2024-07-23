class Solution {
    public int[] frequencySort(int[] nums) {
       Map<Integer, Long> countMap = Arrays.stream(nums)
                                            .boxed()
                                            .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

       // Sort the nums array by frequency and then by value
        Integer[] sortedNums = Arrays.stream(nums)
                                     .boxed()
                                     .sorted((a, b) -> {
                                         int freqCompare = countMap.get(a).compareTo(countMap.get(b));
                                         if (freqCompare == 0) {
                                             return b.compareTo(a); // If frequencies are equal, compare by value
                                         }
                                         return freqCompare;
                                     })
                                     .toArray(Integer[]::new);

        //  Convert Integer[] back to int[]
        nums = Arrays.stream(sortedNums).mapToInt(Integer::intValue).toArray();
        return nums;
        
    }
}