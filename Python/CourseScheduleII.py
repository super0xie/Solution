from typing import List

class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        self.graph = {}
        for l in prerequisites:
            if l[0] not in self.graph:
                self.graph[l[0]] = []
            self.graph[l[0]].append(l[1])

        self.visited = [False] * numCourses
        self.onStack = [False] * numCourses
        self.res = []

        for i in range(numCourses):
            if self.dfs(i):
                return []
        
        # self.res.reverse()
        return self.res

    def dfs(self, n):
        if self.onStack[n]:
            return True
        if self.visited[n]:
            return False
        self.onStack[n] = True
        self.visited[n] = True

        if n in self.graph:
            for adj in self.graph[n]:
                if self.dfs(adj):
                    return True
        
        self.onStack[n] = False
        self.res.append(n)
        return False

test = Solution()
prerequisites = [[1,0],[2,0],[3,1],[3,2]]
res = test.findOrder(4, prerequisites)
print(res)