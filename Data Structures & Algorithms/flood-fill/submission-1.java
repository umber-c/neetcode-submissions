class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        
        if (originalColor != color) {
            fill(image, sr, sc, originalColor, color);
        }
        
        return image;
    }
    private void fill(int[][] image, int sr, int sc, int originalColor, int newColor) {

        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != originalColor) {
            return;
        }


        image[sr][sc] = newColor;

        fill(image, sr + 1, sc, originalColor, newColor); // DOWN
        fill(image, sr - 1, sc, originalColor, newColor); // UP
        fill(image, sr, sc + 1, originalColor, newColor); // RIGHT
        fill(image, sr, sc - 1, originalColor, newColor); // LEFT
    }
}