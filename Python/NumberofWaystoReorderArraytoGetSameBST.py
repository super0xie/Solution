from typing import List
import math

class Solution:
    mod = 1000000007

    def numOfWays(self, nums: List[int]):
        r = self.helper(nums)
        return int(r-1)

    def helper(self, nums):
        if len(nums) <= 1:
            return 1
        l = []
        r = []
        a = nums[0]
        for i in range(1, len(nums)):
            if nums[i] < a:
                l.append(nums[i])
            else:
                r.append(nums[i])
        lr = self.helper(l)
        rr = self.helper(r)
        res = self.cal(len(nums)-1, len(l), len(r))
        res = res % Solution.mod
        res = res * lr
        res = res % Solution.mod
        res = res * rr
        res = res % Solution.mod
        return res

    def cal(self, a, b, c):
        res = 1
        ma = max(b, c)
        mi = min(b, c)
        arr = [False] * (mi+1)
        for i in range(ma+1, a+1):
            res = res * i
            for j in range(2, mi+1):
                if not arr[j] and res % j == 0:
                    arr[j] = True
                    res = res / j
            res = res % Solution.mod
        return res





test = Solution()
nums = [19,3,57,34,15,89,58,35,2,33,46,13,40,79,60,30,61,26,54,22,84,51,75,6,87,44,55,48,27,8,72,47,16,69,36,76,41,1,80,62,73,24,93,50,92,65,39,5,32,67,12,29,90,45,9,38,88,52,10,85,74,66,83,18,20,77,49,28,23,53,86,64,78,82,37,42,56,17,81,4,14,70,59,31,7,25,43,68,91,71,21,63,94,11]
print(test.numOfWays(nums))
