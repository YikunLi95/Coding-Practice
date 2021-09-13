class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> max = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                max.add(nums[deque.peekFirst()]);
            }
        }
        int[] res = new int[max.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = max.get(i);
        }
        return res;
    }
}
// TC: O(n)
// SC: O(n)
