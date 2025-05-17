class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        if (h == piles.length) return max;

        int left = 1;
        int right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (feasible(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean feasible(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // same as ceil(pile / k)
        }
        return hours <= h;
    }
}