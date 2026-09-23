class Solution {
    public int maxArea(int[] heights) {

        int best = 0;
        int k = heights.length - 1;
        int j = 0;

        while (j < k){
            int length = Math.min(heights[j], heights[k]);
            int width = k - j;
            int area = length * width;
            best = Math.max(best,area);

            if (heights[j] > heights[k]){
                k--;
            }
            else {
                j++;
            }
        }
        return best;
        
    }
}
