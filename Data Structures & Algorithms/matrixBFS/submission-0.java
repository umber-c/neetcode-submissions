class Solution {
    public int shortestPath(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            return -1;
        }

        int [][] visit = new int [rows][cols];
        Deque <int[]> queue = new ArrayDeque<>();

        queue.add(new int[2]);
        visit[0][0] = 1;

        int length = 0;

        while (!queue.isEmpty()){
            int queuelength = queue.size();
            for (int i = 0; i < queuelength; i++){
                int pair[] = queue.poll();
                int r = pair[0];
                int c = pair[1];

                if (r == rows - 1 && c == cols - 1) {
                    return length;
                }   

                int [][] neighbors = {{r, c + 1}, {r, c - 1}, {r + 1, c}, {r - 1, c}};

                for(int j = 0; j < 4; j++){
                    int newR = neighbors[j][0], newC = neighbors[j][1];
                    if (Math.min(newR, newC) < 0 || newR == rows || newC == cols
                    || visit[newR][newC] == 1 || grid[newR][newC] == 1) {
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
