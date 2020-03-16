from typing import List

class Solution:

    def maxKilledEnemies(self, grid: List[List[str]]) -> int:
        m = len(grid)
        if m == 0:
            return 0
        n = len(grid[0])
        aux = [[0] * n for i in range(m)]
        res = 0

        for i in range(m):
            sum = 0
            for j in range(n):
                if grid[i][j] == 'E':
                    sum += 1
                elif grid[i][j] == 'W':
                    sum = 0
                else:
                    aux[i][j] = sum
            
            sum = 0
            for j in range(n-1, -1, -1):
                if grid[i][j] == 'E':
                    sum += 1
                elif grid[i][j] == 'W':
                    sum = 0
                else:
                    aux[i][j] += sum

        for j in range(n):
            sum = 0
            for i in range(m):
                if grid[i][j] == 'E':
                    sum+=1
                elif grid[i][j] == 'W':
                    sum = 0
                else:
                    aux[i][j] += sum
            sum = 0

            for i in range(m-1, -1, -1):
                if grid[i][j] == 'E':
                    sum += 1
                elif grid[i][j] == 'W':
                    sum = 0
                else:
                    aux[i][j] += sum
                    res = max(res, aux[i][j])

        return res

test = Solution()
grid = [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
print(test.maxKilledEnemies(grid))
