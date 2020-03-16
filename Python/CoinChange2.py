from typing import List

class Solution:

    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1
        for i in coins:
            for j in range(amount+1):
                if j - i >= 0 and dp[j-i] > 0:
                    dp[j] += dp[j-i]
        return dp[amount]


test = Solution()
coins = [10]
print(test.change(10, coins))


