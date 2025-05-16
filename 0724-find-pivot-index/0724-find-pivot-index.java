class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int prefix_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (prefix_sum == sum) {
                return i;
            }
            prefix_sum += nums[i];
        }
        return -1;
    }
}