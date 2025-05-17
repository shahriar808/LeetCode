class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pill : piles){
           max = Math.max(pill, max);
        }
        if (h == piles.length) return max;
        int left = 1;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEat(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private int canEat(int[] nums, int k){
        int hours = 0;
        for (int num : nums) {
            hours += (num +k - 1) / k;
        }
        return hours;
    }
}