/*
Given an integer number, return all possible combinations of the factors that can multiply to the target number.

Example

Give A = 24

since 24 = 2 x 2 x 2 x 3

              = 2 x 2 x 6

              = 2 x 3 x 4

              = 2 x 12

              = 3 x 8

              = 4 x 6

your solution should return

{ { 2, 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }

note: duplicate combination is not allowed.
*/

public class Solution {
  public List<List<Integer>> combinations(int target) {
    // Write your solution here
    List<List<Integer>> res = new ArrayList<>();
    if (target <= 1) {
      return res;
    }
    List<Integer> cur = new ArrayList<>();
    List<Integer> factors = getFactors(target);
    helper(cur, factors, target, 0, res);
    return res;
  }

  private void helper(List<Integer> cur, List<Integer> factors, int target, int index, List<List<Integer>> res) {
    if (index == factors.size()) {
      if (target == 1) {
        res.add(new ArrayList<>(cur));
      }
      return;
    }
    helper(cur, factors, target, index + 1, res);
    int factor = factors.get(index);
    int size = cur.size();
    while (target % factor == 0) {
      cur.add(factor);
      target /= factor;
      helper(cur, factors, target, index + 1, res);
    }
    cur.subList(size, cur.size()).clear();
  }

  private List<Integer> getFactors(int target) {
    List<Integer> factors = new ArrayList<>();
    for (int i = target / 2; i > 1; i--) {
      if (target % i == 0) {
        factors.add(i);
      }
    }
    return factors;
  }
}
