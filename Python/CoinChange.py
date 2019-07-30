class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 0
        max = 100000000
        for i in range(1, amount+1):
            dp[i] = max
            for c in coins:
                if i - c >= 0:
                    dp[i] = min(dp[i], dp[i-c]+1)
        if dp[amount] >= max:
            return -1
        return dp[amount]
        


