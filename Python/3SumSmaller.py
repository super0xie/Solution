class Solution(object):
    def threeSumSmaller(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums = sorted(nums)
        res = 0
        for i in range(len(nums)-2):
            tar = target - nums[i]
            start = i+1
            end = len(nums)-1
            while start < end:
                if nums[start] + nums[end] >= tar:
                    end = end-1
                else:
                    res += end-start;
                    start = start + 1
        return res



