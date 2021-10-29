class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int ast: asteroids) {
            collision: {
                while (!stack.isEmpty() && stack.peekLast() > 0 && ast < 0) {
                    if (stack.peekLast() < -ast) {
                        stack.pollLast();
                        continue;
                    } else if (stack.peekLast() == -ast) {
                        stack.pollLast();
                    }
                    break collision;
                }
                stack.offerLast(ast);
            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pollLast();
        }
        return res;
    }
}
// TC: O(n)
// SC: O(n)
