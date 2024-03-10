class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> resultSet = new HashSet<>();

        int ptr1 = 0;
        int ptr2 = 0;

        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] == nums2[ptr2]) {
                resultSet.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            } else if (nums1[ptr1] < nums2[ptr2]) {
                ptr1++;
            } else {
                ptr2++;
            }
        }

        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }

        return result;
    }
}