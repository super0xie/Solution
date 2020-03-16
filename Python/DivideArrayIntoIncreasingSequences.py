class Solution:

    def canDivideIntoSubsequences(self, nums: List[int], K: int) -> bool:
        maxCount = 0
        i = 0
        while i < len(nums):
            j = i
            while j < len(nums) and nums[j] == nums[i]:
                j += 1
            maxCount = max(maxCount, j-i)
            i = j

        if len(nums) >= maxCount * K:
            return True
        return False

