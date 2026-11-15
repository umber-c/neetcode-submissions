

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] leftBoundary = new int[n];
        int[] rightBoundary = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()
                    && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                leftBoundary[i] = -1;
            } else {
                leftBoundary[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        // Find the nearest strictly shorter bar on the right.
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty()
                    && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                rightBoundary[i] = n;
            } else {
                rightBoundary[i] = stack.peek();
            }

            stack.push(i);
        }

        // Calculate the widest rectangle at each bar's height.
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = rightBoundary[i] - leftBoundary[i] - 1;
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}