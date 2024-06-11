class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[arr1.length];
        int index = 0;

        // Add elements from arr2 in the specified order
        for (int num : arr2) {
            int count = countMap.get(num);
            for (int i = 0; i < count; i++) {
                result[index++] = num;
            }
            countMap.remove(num);
        }

        // Add the remaining elements in sorted order
        int[] remaining = new int[arr1.length - index];
        int remIndex = 0;
        for (int num : countMap.keySet()) {
            int count = countMap.get(num);
            for (int i = 0; i < count; i++) {
                remaining[remIndex++] = num;
            }
        }
        Arrays.sort(remaining);

        // Add the sorted remaining elements to the result
        for (int num : remaining) {
            result[index++] = num;
        }

        return result;
    }
}