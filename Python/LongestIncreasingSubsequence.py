class Solution:

    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0: return 0
        dp = [0] * len(nums)
        dp[len(nums)-1] = 1;
        res = 1

        for i in reversed(range(len(nums)-1)):
            dp[i] = 1
            for j in range(i+1, len(nums)):
                if(nums[j] > nums[i]):
                    dp[i] = max(dp[i], dp[j]+1)
                    res = max(res, dp[i])
        return res
