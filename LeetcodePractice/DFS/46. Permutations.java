/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        DFS(nums, res, cur, 0);
        return res;
    }
    
    private void DFS(int[] nums, List<List<Integer>> res, List<Integer> cur, int index) {
        if (index == nums.length) {
            for (int i : nums) {
                cur.add(Integer.valueOf(i));
            }
            res.add(new ArrayList<>(cur));
            cur.clear();
            return;
        }
            
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            DFS(nums, res, cur, index + 1);
            swap(nums, index, i);
        }
    }
    
    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
// TC: O(n! * n)
// SC: O(n) -> n represents the length of input array
