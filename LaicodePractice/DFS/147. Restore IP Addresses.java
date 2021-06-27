/*
Given a string containing only digits, restore it by retiring all possible valid IP address combinations.

Input:  ”25525511135”

Output: [“255.255.11.135”, “255.255.111.35”]
*/

public class Solution {
  public List<String> Restore(String ip) {
    // Write your solution here
    List<String> res = new ArrayList<>();
    if (ip == null || ip.length() == 0) {
      return res;
    }
    char[] array = ip.toCharArray();
    StringBuilder sb = new StringBuilder();
    DFS(array, res, sb, 0, 0);
    return res;
  }

  private void DFS(char[] array, List<String> res, StringBuilder sb, int level, int offset) {
    if (level == 4) {
      if (sb.length() == array.length + 4) {
        res.add(sb.substring(0, sb.length() - 1));
      }
      return;
    }

    if (offset < array.length) {
      sb.append(array[offset]).append('.');
      DFS(array, res, sb, level + 1, offset + 1);
      sb.delete(sb.length() - 2, sb.length());
    }
    if (offset + 1 < array.length) {
      char a = array[offset];
      char b = array[offset + 1];
      if (a != '0') {
        sb.append(a).append(b).append('.');
        DFS(array, res, sb, level + 1, offset + 2);
        sb.delete(sb.length() - 3, sb.length());
      }
    }
    if (offset + 2 < array.length) {
      char a = array[offset];
      char b = array[offset + 1];
      char c = array[offset + 2];
      if (a == '1' || a == '2' && b >= '0' && b <= '4' || a == '2' && b == '5' && c >= '0' && c <= '5') {
        sb.append(a).append(b).append(c).append('.');
        DFS(array, res, sb, level + 1, offset + 3);
        sb.delete(sb.length() - 4, sb.length());
      }
    }
  }
}
