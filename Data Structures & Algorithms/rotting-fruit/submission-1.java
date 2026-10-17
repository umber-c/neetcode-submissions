class Solution {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0; //counts how many fruits there are

        Deque<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == 2){
                    queue.add(new int[]{r,c});
                }
                else if (grid[r][c] == 1){
                    fresh +=1;
                }
            }
        }
        
        int min = 0; //minutes

        while(!queue.isEmpty() && fresh > 0){
            int queuelength = queue.size();
            for (int i = 0; i < queuelength; i++){
                
                int pair[] = queue.poll();
                int r = pair[0];
                int c = pair[1];

                int[][] neighbors = {{r+1,c}, {r-1,c}, {r,c+1}, {r,c-1} };
                for (int j = 0; j < 4; j++){
                    int newR = neighbors[j][0];
                    int newC = neighbors[j][1];
                    
                if (Math.min(newR, newC) < 0 || newR == rows || newC == cols || grid[newR][newC] != 1) {
                        continue;
                    }

                    grid[newR][newC] = 2;
                    queue.add(neighbors[j]);
                    fresh--;
                }
            }

            min++;
        }
        if (fresh == 0){
            return min;
        }
        else {
            return -1;
        }

    }


}
