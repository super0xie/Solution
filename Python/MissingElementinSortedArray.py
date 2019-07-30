from typing import List

class Solution:

    def missingElement(self, nums: List[int], k: int) -> int:

        for i in range(1, len(nums)):
            diff = nums[i] - nums[i-1]
            if diff > k:
                return nums[i-1] + k
            else:
                k -= diff - 1
        
        return nums[-1] + k

test = Solution()
nums = [1,2,4]
print(test.missingElement(nums, 3))
        