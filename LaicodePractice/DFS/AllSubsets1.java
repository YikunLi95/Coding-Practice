/* Given a set of characters represented by a String, return a list containing all subsets of the characters.

Assumptions: There are no duplicate characters in the original set.

​Examples:
Set = "a b c", all the subsets are [“”, “a”, “a b”, “a b c”, “a c”, “b”, “b c”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []

Recursion Tree:
                                  {}
                                  /\
For A(0)                         A  o
                                /\
For B(1)                       B  o
                              /\
For C(2)                     C  o

TC: O(2 ^ n * n) SC: O(n) 
*/

public class Solution {
  public List<String> subSets(String set) {
    // Write your solution here.
    List<String> res = new ArrayList<>();
    // corner case
    if (set == null) {
      return res;
    }
    char[] arraySet = set.toCharArray();
    StringBuilder sb = new StringBuilder();
    helper(res, arraySet, sb, 0);
    return res;
  }

  private void helper(List<String> res, char[] arraySet, StringBuilder sb, int index) {
    if (index == arraySet.length) {
      res.add(sb.toString());
      return;
    }

    helper(res, arraySet, sb.append(arraySet[index]), index + 1);
    sb.deleteCharAt(sb.length() - 1);

    helper(res, arraySet, sb, index + 1);
  }
}
// TC: O(2 ^ n * n)
// SC: O(n)
