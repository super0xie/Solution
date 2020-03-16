from typing import List

class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if grid[0][0] == 1:
            return -1
        
        m = len(grid)
        n = len(grid[0])
        if m == 1 and n == 1:
            return 1
        
        adj = [[-1, -1], [0, -1], [1, -1], [1, 0], [1, 1], [0, 1], [-1, 1], [-1, 0]]
        visited = [[False] * n for i in range(m)]

        queue = [[0, 0]]
        visited[0][0] = True
        length = 2

        while len(queue) > 0:
            aux = []
            for node in queue:
                for k in adj:
                    r = node[0] + k[0]
                    c = node[1] + k[1]
                    if r >= 0 and r < m and c >= 0 and c < n and not visited[r][c] and grid[r][c] == 0:
                        if r == m-1 and c == n-1:
                            return length
                        visited[r][c] = True
                        aux.append([r,c])

            queue = aux
            length += 1

        return -1

test = Solution()
grid = [[0,0,0],[1,1,0],[1,1,0]]
print(test.shortestPathBinaryMatrix(grid))



