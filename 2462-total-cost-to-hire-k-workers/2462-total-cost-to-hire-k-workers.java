class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> lpq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>();
        long cost = 0;

        int rb = candidates;
        for (int i = 0; i < candidates; i++) {
            lpq.add(costs[i]);
        }

        int lb = costs.length - candidates - 1;

        for (int i = (rb > lb) ? rb : lb + 1; i < costs.length; i++) {
            rpq.add(costs[i]);
        }

        for (int i = 0; i < k; i++) {
            int leftElem = lpq.isEmpty() ? Integer.MAX_VALUE : lpq.peek();
            int rightElem = rpq.isEmpty() ? Integer.MAX_VALUE : rpq.peek();

            if (leftElem <= rightElem) {
                cost += lpq.remove();
                if (rb <= lb && rb < costs.length) {
                    lpq.add(costs[rb]);
                    rb++;
                }
            } else {
                cost += rpq.remove();
                if (rb <= lb && lb >= 0) {
                    rpq.add(costs[lb]);
                    lb--;
                }
            }
        }

        return cost;
    }
}
