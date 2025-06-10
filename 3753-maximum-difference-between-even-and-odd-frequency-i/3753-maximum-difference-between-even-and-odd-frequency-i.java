class Solution {
    public int maxDifference(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        int maxEven = s.length();
        int maxOdd = 0;
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                if (map[i] % 2 == 0) {
                    maxEven = Math.min(maxEven, map[i]);
                } else {
                    maxOdd = Math.max(maxOdd, map[i]);
                }
            }
        }
        return maxOdd - maxEven;
    }
}