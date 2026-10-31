class Solution:
    def solve(self, board: List[List[str]]) -> None:
        ROWS = len(board)
        COLS = len(board[0])
        queue = deque()

        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == "O" and (r == 0 or c == 0 or r == ROWS - 1 or c == COLS - 1):
                    board[r][c] = "S"
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
                if (board[newRow][newCol]!= "O"):
                    continue

                board[newRow][newCol] = "S"
                queue.append((newRow, newCol))
        
        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == "S":
                    board[r][c] = "O"
                else:
                    board[r][c] = "X"
        

