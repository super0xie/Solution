from typing import List

class Solution:

    def assignBikes(self, workers: List[List[int]], bikes: List[List[int]]) -> List[int]:

        class Node:
            def __init__(self, worker, bike, w, b):
                self.worker = worker
                self.bike = bike
                self.dis = abs(w[0]-b[0]) + abs(w[1]-b[1])
        
        l = []
        for i in range(len(workers)):
            for j in range(len(bikes)):
                n = Node(i, j, workers[i], bikes[j])
                l.append(n)

        l.sort(key = lambda n: (n.dis, n.worker, n.bike))
        visitedWorkers = [False] * len(workers)
        visitedBikes = [False] * len(bikes)
        res = [0] * len(workers)
        for n in l:
            if visitedWorkers[n.worker] or visitedBikes[n.bike]:
                continue
            res[n.worker] = n.bike
            visitedWorkers[n.worker] = True
            visitedBikes[n.bike] = True
            
        return res
            
test = Solution()
workers = [[0,0],[1,1],[2,0]]
bikes = [[1,0],[2,2],[2,1]]
for i in test.assignBikes(workers, bikes):
    print(i)
