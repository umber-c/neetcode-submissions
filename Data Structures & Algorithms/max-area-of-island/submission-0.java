class Solution {

    int maxArea = 0;
    int currentArea =0;
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r<rows; r++){
            for (int c = 0; c<cols; c++){
                if (grid[r][c] == 1){
                    currentArea = 0;
                    sink(grid, r, c);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

        return maxArea;
    }

    private void sink(int[][]grid, int r, int c){

            if(r<0||r>= grid.length||c<0||c>=grid[0].length||grid[r][c] ==0){
                return;
            }

            currentArea+=1;
            grid[r][c] = 0;

            sink(grid, r+1, c);
            sink(grid, r, c+1);
            sink(grid, r-1, c);
            sink(grid, r, c-1);
    }
}
