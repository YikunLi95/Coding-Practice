/*
Given a begin word, an end word and a dictionary, find the least number transformations from begin word to end word, and return the transformation sequences. Return empty list if there is no such transformations.

In each transformation, you can only change one letter, and the word should still in the dictionary after each transformation. 

Assumptions

1. All words have the same length.

2. All words contain only lowercase alphabetic characters.

3. There is no duplicates in the word list.

4.The beginWord and endWord are non-empty and are not the same.

Example: start = "git", end = "hot", dictionary = {"git","hit","hog","hot","got"}

Output: [["git","hit","hot"], ["git","got","hot"]]
*/

public class Solution {

  class Pair {
    String val;
    List<String> currSeries;
    
    public Pair(String val, List<String> series) {
      this.val = val;
      this.currSeries = new ArrayList<>(series);
    }
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    //write your code here
    Queue<Pair> qu = new LinkedList<>();
    Set<String> words = new HashSet<>();
    List<List<String>> tempRes = new ArrayList<>();
        
    for (String word : wordList) {
      words.add(word);
    }
    List<String> startSeries = new ArrayList<>();
    startSeries.add(beginWord);
    qu.add(new Pair(beginWord, startSeries));
        
    while (!qu.isEmpty()) {
      Pair curr = qu.poll();
      String currStr = curr.val;
      List<String> currSeries = curr.currSeries;
            
      if (words.contains(currStr)) {
        words.remove(currStr);
      } 
      if (currStr.equals(endWord)) {
        tempRes.add(currSeries);
      }
            
      Iterator<String> iter = words.iterator();
      while (iter.hasNext()) {
        String word = iter.next();
        if (isValidTransformation(currStr, word)) {
          currSeries.add(word);
          qu.add(new Pair(word, currSeries));
          currSeries.remove(currSeries.size()-1);
        }
      }
    }
    List<List<String>> res = new ArrayList<>();
    int minLen = Integer.MAX_VALUE;
    for (List<String> t : tempRes) {
      minLen = Math.min(minLen, t.size());
    }
    for (List<String> t : tempRes) {
      if (t.size() == minLen) {
        res.add(t);
      }
    } 
    return res;
  }

  public boolean isValidTransformation(String A, String B) {
    char[] a = A.toCharArray();
    char[] b = B.toCharArray();    
    int diff = 0;
    for (int i=0; i<a.length; i++) {
      if (a[i] != b[i]) {
        diff++;
      }
    }
    return diff<2;
  }
}
// TC:
