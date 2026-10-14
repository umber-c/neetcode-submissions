class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        
        // Prevent infinite loop if the starting pixel is ALREADY the new color
        if (originalColor != color) {
            fill(image, sr, sc, originalColor, color);
        }
        
        return image;
    }

    // Our void helper method (just like 'sink')
    private void fill(int[][] image, int sr, int sc, int originalColor, int newColor) {
        // Base cases: check bounds using sr and sc, and check if it's the original color
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != originalColor) {
            return;
        }

        // Assign the new color
        image[sr][sc] = newColor;

        // Recursive calls moving sr and sc
        fill(image, sr + 1, sc, originalColor, newColor); // DOWN
        fill(image, sr - 1, sc, originalColor, newColor); // UP
        fill(image, sr, sc + 1, originalColor, newColor); // RIGHT
        fill(image, sr, sc - 1, originalColor, newColor); // LEFT
    }
}