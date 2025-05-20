class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        pq.addAll(map.values());
        int length = arr.length / 2;
        int count = 0;
        int answer = 0;
        for (int i = 0; i < pq.size(); i++) {
            int top = pq.remove();
            answer++;
            count += top;
            if (count >= length) {
                break;
            }
        }
        return answer;
    }
}