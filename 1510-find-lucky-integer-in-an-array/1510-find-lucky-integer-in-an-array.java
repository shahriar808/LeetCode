class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int maxCount = -1;
        for (int count : map.keySet()) {
            if (count == map.get(count)) {
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}