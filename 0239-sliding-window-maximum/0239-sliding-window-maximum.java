class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    if (n == 0 || k == 0) return new int[0];
    Deque<Integer> deque = new LinkedList<>();
    int[] result = new int[n - k + 1];
    for (int i = 0; i < n; i++) {
        if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
            deque.pollFirst();
        }
        while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
            deque.pollLast();
        }
        deque.offerLast(i);
        if (i >= k - 1) {
            result[i - k + 1] = nums[deque.peekFirst()];
        }
    }
    
    return result;
}

}