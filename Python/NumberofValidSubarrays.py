from typing import List

class Solution:
    def validSubarraysOld(self, nums: List[int]) -> int:
        res = 0
        for i in range(len(nums)):
            j = i+1
            while j < len(nums):
                if nums[j] < nums[i]:
                    break
                j += 1
            res += j-i
        return res

    def validSubarrays(self, nums: List[int]) -> int:
        res = 0
        for i in range(len(nums)):
            j = i+1
            while j < len(nums):
                if nums[j] < nums[i]:
                    break
                j += 1
            res += j-i
        return res

    

test = Solution()
nums = [1,4,2,5,3]
print(test.validSubarrays(nums))