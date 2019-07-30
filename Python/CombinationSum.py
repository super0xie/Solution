from typing import List

class Solution:

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res = []
        self.dfs(0, candidates, target, [], 0)
        return self.res



    def dfs(self, i, cand, target, cur, sum):
        if i >= len(cand) or sum > target:
            return
        if sum == target:
            self.res.append(cur.copy())
            return
        
        cur.append(cand[i])
        self.dfs(i, cand, target, cur, sum+cand[i])
        cur.pop()
        self.dfs(i+1, cand, target, cur, sum)

        

test = Solution()
res = test.combinationSum([2,3,5], 8)
for i in res:
    print(i)






