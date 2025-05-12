class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n <= 0)
            return n;
        HashSet<Integer> set = new HashSet<>();
        int longest = 1;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int length = 1;
                while (set.contains(num + length)) {
                    length = length + 1;
                }
                longest = Math.max(longest, length);

            }
        }
        return longest;
    }
}