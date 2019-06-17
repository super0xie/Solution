from typing import List
from typing import Dict

class Solution:

    def leadsToDestination(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        graph = {}
        self.res = True
        for e in edges:
            if e[0] not in graph:
                graph[e[0]] = []
            graph[e[0]].append(e[1])

        visited = [False] * n
        stack = [False] * n
        self.dfs(graph, source, visited, stack, destination)

        return self.res

    def dfs(self, graph: Dict, n: int, visited: List[bool], stack: List[bool], dst: int):
        if not self.res:
            return
        
        stack[n] = True
        visited[n] = True

        if n not in graph:
            if n == dst:
                stack[n] = False
                return
            else:
                self.res = False
                return

        for adj in graph[n]:
            if stack[adj]:
                self.res = False
                return
            if not visited[adj]:    
                self.dfs(graph, adj, visited, stack, dst)

        stack[n] = False

test = Solution()
edges = [[0,1],[0,2],[1,3],[2,3]]
print(test.leadsToDestination(4, edges, 0, 3))
