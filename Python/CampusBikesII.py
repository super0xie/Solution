import math
from typing import List

class Solution:

    def assignBikes(self, workers: List[List[int]], bikes: List[List[int]]) -> int:
        self.m = len(workers)
        self.n = len(bikes)
        self.d = [[0] * len(bikes) for i in range(len(workers))]
        for i in range(len(workers)):
            for j in range(len(bikes)):
                self.d[i][j] = abs(workers[i][0]-bikes[j][0]) + abs(workers[i][1] - bikes[j][1])
        self.cache = {}
        self.bikeUsed = [False] * len(bikes)
        return self.dfs(0)

        
    def dfs(self, i):
        encode = 0
        for b in self.bikeUsed:
            if b:
                encode += 1
            encode = encode << 1
        if encode in self.cache:
            return self.cache[encode]

        res = 10000000
        for j in range(self.n):
            if self.bikeUsed[j]:
                continue
            self.bikeUsed[j] = True
            if i == self.m-1:
                res = min(res, self.d[i][j])
            else:
                res = min(res, self.d[i][j] + self.dfs(i+1))
            self.bikeUsed[j] = False
        self.cache[encode] = res
        return res


test = Solution()
workers = [[0,0],[1,1],[2,0]]
bikes = [[1,0],[2,2],[2,1]]

print(test.assignBikes(workers, bikes))