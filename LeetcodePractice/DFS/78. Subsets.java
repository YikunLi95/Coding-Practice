/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        DFS(nums, res, cur, 0);
        return res;
    }
    
    private void DFS(int[] array, List<List<Integer>> res, List<Integer> cur, int index) {
        if (index == array.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        cur.add(array[index]);
        DFS(array, res, cur, index + 1);
        cur.remove(cur.size() - 1);
        
        DFS(array, res, cur, index + 1);
    }
}
// TC: O(2 ^ n * n) 
// SC: O(n) -> n represents length of input array
