public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] + b[1])-(a[0]+a[1]));
        
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                int[] cur={nums1[i], nums2[j]};
                if (pq.size() == k) {
                    int[] pk=pq.peek();
                    if(pk[0]+pk[1]>cur[0]+cur[1]){
                        pq.poll();
                        pq.offer(cur);
                    }
                    else break;
                }
                else pq.offer(cur);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            result.add(Arrays.asList(pair[0], pair[1]));
        }

        return result;
    }
}