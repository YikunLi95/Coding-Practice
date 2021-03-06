/*
Consider an unlimited flow of data elements. How do you sample k element from this flow, such that at any point during the processing of the flow, you can return a random set of k elements from the n elements read so far. 

Assumptions

k >= 1
You will implement two methods for a sampling class:

read(int value) - read one number from the flow
sample() - return at any time the k samples as a list, return the list of all values read when the number of values read so fas <= k.
You may need to add more fields for the class.
*/

public class Solution {
  private final int k;
  private int count;
  private List<Integer> sample;
  
  public Solution(int k) {
    // Complete the constructor if necessary.
    if (k <= 0) {
      throw new IllegalArgumentException("k must be > 0");
    }
    this.k = k;
    this.count = 0;
    sample = new ArrayList<>();
  }
  
  public void read(int value) {
    // Write your implementation here.
    count++;
    if (count <= k) {
      sample.add(value);
    } else {
      int random = (int) (Math.random() * count);
      if (random < k) {
        sample.set(random, value);
      }
    }
  }
  
  public List<Integer> sample() {
    // Write your implementation here.
    return sample;
  }
}
// TC
// SC:
