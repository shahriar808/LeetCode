class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            Map.Entry<Character, Integer> first = pq.poll();
            Map.Entry<Character, Integer> second = pq.poll();
            sb.append(first.getKey());
            sb.append(second.getKey());
            first.setValue(first.getValue() - 1);
            second.setValue(second.getValue() - 1);
            if (first.getValue() > 0) pq.add(first);
            if (second.getValue() > 0) pq.add(second);
        }
        if (!pq.isEmpty()) {
            Map.Entry<Character, Integer> last = pq.poll();
            if (last.getValue() > 1) return "";
            sb.append(last.getKey());
        }
        return sb.toString();
    }
}