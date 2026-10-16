class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        
        if (grid[rows-1][cols-1] == 1 || grid[0][0] == 1){
            return -1;
        }

      
        int[][] visit = new int[rows][cols];
        Deque<int[]> queue = new ArrayDeque<>();

        visit[0][0] = 1;
        queue.add(new int[2]); // Adds {0, 0}

        int length = 1; 

        while(!queue.isEmpty()){
            
            int queuelength = queue.size();
            for (int i = 0; i < queuelength; i++){ 
                
                int pair[] = queue.poll();
                int r = pair[0];
                int c = pair[1];
                
                if(r == rows-1 && c == cols-1){ 
                    return length;
                }

                int[][] neighbors = {
                    {r - 1, c - 1}, {r - 1, c}, {r - 1, c + 1}, 
                    {r, c - 1},                 {r, c + 1},
                    {r + 1, c - 1}, {r + 1, c}, {r + 1, c + 1}  
                };

                for (int j = 0; j < 8; j++){
                    int newR = neighbors[j][0];
                    int newC = neighbors[j][1];


                    if(Math.min(newR, newC) < 0 || newR == rows || newC == cols || 
                       visit[newR][newC] == 1 || grid[newR][newC] == 1){
                        continue;
                    }
                    
                    queue.add(neighbors[j]);
                    visit[newR][newC] = 1;
                }
            } 
            
            length++;
        }
        
        return -1;
    }
}