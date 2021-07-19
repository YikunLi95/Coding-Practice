/*
Given a begin word, an end word and a dictionary, find the least number transformations from begin word to end word, and return the length of the transformation sequence. Return 0 if there is no such transformations.

In each transformation, you can only change one letter, and the word should still in the dictionary after each transformation. 

Assumptions

1. All words have the same length.

2. All words contain only lowercase alphabetic characters.

3. There is no duplicates in the word list.

4.The beginWord and endWord are non-empty and are not the same.

Example: start = "git", end = "hot", dictionary = {"git","hit","hog","hot"}

Output: 3

Explanation: git -> hit -> hot
*/

public class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    // Write your solution here
    Set<String> wordSet = new HashSet<>(wordList);
    if(!wordList.contains(endWord)) {
      return 0;
    }
        
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    int depth = 0;
    while(!queue.isEmpty()) {
      depth ++;
      int size = queue.size();
      for(int i = 0; i < size; i++) {
        String currWord = queue.poll();
        char[] wordArr = currWord.toCharArray();
        for(int index = 0; index < wordArr.length; index ++) {
          for(char alpha = 'a'; alpha <= 'z'; alpha ++) {
            wordArr[index] = alpha;
            String word = String.valueOf(wordArr);
            if(word.equals(currWord)) {
              continue;
            }
            if(word.equals(endWord)) {
              return depth + 1;
            }
            if(wordSet.contains(word)) {
              wordSet.remove(word);
              queue.offer(word);
            }
          }
          wordArr[index] = currWord.charAt(index); 
        }
      }
    }
    return 0;
  }
}
