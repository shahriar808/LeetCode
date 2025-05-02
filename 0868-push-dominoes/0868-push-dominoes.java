class Solution {
    public String pushDominoes(String dominoes) {
        int last_L = -1, last_R = -1;
        int n = dominoes.length();
        StringBuilder sb = new StringBuilder(dominoes);
        for (int pos = 0; pos < n; pos++) {
            if (sb.charAt(pos) == 'L') {
                if (last_R > last_L) {
                    doubleDominoPush(last_R, pos, sb);
                } else if (last_L > last_R || last_L == -1) {
                    leftDominoPush(last_L + 1, pos, sb);
                }
                last_L = pos;
            } else if (sb.charAt(pos) == 'R') {
                if (last_R > last_L) {
                    rightDominoPush(last_R, pos, sb);
                }
                last_R = pos;
            }
        }
        if (last_R > last_L) {
            rightDominoPush(last_R, n - 1, sb);
        }
        return sb.toString();
    }

    private void doubleDominoPush(int left, int right, StringBuilder sb) {
        while (left < right) {
            sb.setCharAt(left++, 'R');
            sb.setCharAt(right--, 'L');
        }
    }
    private void leftDominoPush(int start, int end, StringBuilder sb) {
        while (start <= end) {
            sb.setCharAt(start++, 'L');
        }
    }
    private void rightDominoPush(int start, int end, StringBuilder sb) {
        while (start <= end) {
            sb.setCharAt(start++, 'R');
        }
    }
}
