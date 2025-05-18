class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int left = max;
        int right = sum;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                right = mid; // try smaller max sum
            } else {
                left = mid + 1; // increase limit
            }
        }

        return left;
    }

    private boolean canSplit(int[] nums, int k, int maxSumAllowed) {
        int count = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSumAllowed) {
                count++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return count <= k;
    }
}