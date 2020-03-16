from typing import List

class Solution:
    def highFive(self, items: List[List[int]]) -> List[List[int]]:
        map = {}
        for i in items:
            if i[0] not in map:
                map[i[0]] = []
            map[i[0]].append(i[1])
        
        res = []

        print(map)
        for i in map:
            sum = 0
            l = sorted(map[i])
            
            for j in range(len(l)-5, len(l)):
                sum += l[j]
            
            res.append([i, sum//5])
        return res

test = Solution()
print(test.highFive([[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]))