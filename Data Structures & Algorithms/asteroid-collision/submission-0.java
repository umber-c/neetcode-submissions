
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            boolean survived = true;

            if (asteroid < 0) {
                long asteroidSize = Math.abs((long) asteroid);

                while (!stack.isEmpty() && stack.peek() > 0) {
                    int top = stack.peek();

                    if (asteroidSize > top) {
                        stack.pop();
                    } else {
                        if (asteroidSize == top) {
                            stack.pop();
                        }

                        survived = false;
                        break;
                    }
                }
            }

            if (survived) {
                stack.push(asteroid);
            }
        }

        int[] answer = new int[stack.size()];

        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}