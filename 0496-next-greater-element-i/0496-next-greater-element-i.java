class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int current = nums2[i];
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextGreterMap.put(current, -1);
            } else {
                nextGreterMap.put(current, stack.peek());
            }
            stack.push(current);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreterMap.get(nums1[i]);
        }
        return result;
    }
}