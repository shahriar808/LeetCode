class Solution {
    public int longestPalindrome(String s) {
         int n = s.length();
        int length = 0;
        if (n < 2) return n;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            length += (frequency / 2) * 2;
        }
        if(length < n){
            length += 1;
        }
        return length;
    }
}