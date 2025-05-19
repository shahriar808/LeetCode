class Solution {
    public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int top1 = pq.remove();
            int top2 = pq.remove();
            if (top1 != top2) {
                pq.add(top1 - top2);
            }
        }
        return pq.isEmpty() ? 0 : pq.remove();
    }
}