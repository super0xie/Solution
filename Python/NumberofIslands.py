class Solution(object):

    adj = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if len(grid) == 0 or len(grid[0]) == 0 :
            return 0
        self.m = len(grid)
        self.n = len(grid[0])

        res = 0
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == "1":
                    self.dfs(grid, i, j)
                    res += 1
        print(grid)
        return res

    def dfs(self, grid, i, j):
        grid[i][j] = "0"
        for k in range(len(self.adj)):
            r = i + self.adj[k][0]
            c = j + self.adj[k][1]
            if r >= 0 and r < self.m and c >= 0 and c < self.n and grid[r][c] == "1":
                self.dfs(grid, r, c)

if __name__ == "__main__":
    test = Solution()
    print(test.numIslands([["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]))
