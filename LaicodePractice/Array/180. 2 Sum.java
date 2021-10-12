public class Solution {
  public boolean existSum(int[] array, int target) {
    // Write your solution here
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < array.length; i++) {
      int remain = target - array[i];
      if (set.contains(remain)) {
        return true;
      }
      set.add(array[i]);
    }
    return false;
  }
}
// TC: O(n)
// SC: O(n)
