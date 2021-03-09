package codingProblems;

import java.util.ArrayList;
import java.util.List;

/* Given a set of characters represented by a String, return a list containing all subsets of the characters.

Assumptions: There are no duplicate characters in the original set.

​Examples:
Set = "a b c", all the subsets are [“”, “a”, “a b”, “a b c”, “a c”, “b”, “b c”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []

Recursion Tree:
                                  {}
                                  /\
For A                            A  o
                                /\
For B                          B  o
                              /\
For C                        C  o

TC: O(2 ^ n * n) SC: O(n) */

public class AllSubsets1 {
	
	public List<String> allSubSets1(String set) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		char[] arraySet = set.toCharArray();
		StringBuilder sb = new StringBuilder();
		helper(arraySet, sb, 0, res);
		return res;
	}
	
	private void helper(char[] array, StringBuilder sb, int index, List<String> res) {
		if (index == array.length) {
			res.add(sb.toString()); // O(n)
			return;
		}
		helper(array, sb.append(array[index]), index + 1, res);
		sb.deleteCharAt(sb.length() - 1);
		helper(array, sb, index + 1, res);
	}
}
