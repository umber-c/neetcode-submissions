class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:

        ROWS = len(grid)
        COLS = len(grid[0])
        queue = deque()
        INF = 2147483647

        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 0:
                    queue.append((r,c))

        directions = [(1,0), (-1, 0), (0, 1), (0, -1)]

        while queue:
            coordinates = queue.popleft()
            r = coordinates[0]
            c = coordinates[1]

            for direction in directions:
                dr = direction[0]
                dc = direction[1]

                newRow = r + dr
                newCol = c + dc

                if newRow < 0 or newRow >= ROWS or newCol < 0 or newCol >= COLS:
                    continue
                if (grid[newRow][newCol]!= INF):
                    continue

                grid[newRow][newCol] = grid[r][c] + 1
                queue.append((newRow,newCol))
            