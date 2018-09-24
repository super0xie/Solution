class Solution:
    def findMissingRanges(self, nums, lower, upper):
        """
        :type nums: List[int]
        :type lower: int
        :type upper: int
        :rtype: List[str]
        """
        res = []
        left = lower
        nums.append(upper+1)
        for i in nums:
            right = i-1
            if right >= left:
                if(right > left):
                    res.append(str(left) + "->" + str(right))
                else:
                    res.append(str(left))
            left = i+1
        return res
