class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> hs = new HashSet<>();
        int len = 0;
        for (char ch : s.toCharArray()) {
            if (hs.contains(ch)) {
                hs.remove(ch);
                len += 2;
            } else hs.add(ch);
        }
        if (!hs.isEmpty()) len += 1;
        return len;
    }
}