class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = []
        if n == 1: return 1
        dp.append(1)
        count = 1
        idx2 = 0
        idx3 = 0
        idx5 = 0
        cur = 0
        while count < n:
            cur = min(2*dp[idx2], 3*dp[idx3], 5*dp[idx5])
            dp.append(cur)
            if cur == 2*dp[idx2]:
                idx2 += 1
            if cur == 3*dp[idx3]:
                idx3 += 1
            if cur == 5*dp[idx5]:
                idx5 += 1
            count+=1
        return cur

test = Solution()
print(test.nthUglyNumber(11))
