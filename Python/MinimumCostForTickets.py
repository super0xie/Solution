import bisect

class Solution:

    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = [0] * len(days)
        dp[0] = min(costs)
        for i in range(1, len(days)):
            c1 = dp[i-1] + costs[0]

            d = days[i] - 7
            ret = bisect.bisect(days, d)
            if ret > 0 and days[ret-1] == d:
                c2 = dp[ret-1] + costs[1]
            else:
                if ret == 0:
                    c2 = costs[1]
                else:
                    c2 = dp[ret-1] + costs[1]

            d = days[i] - 30
            ret = bisect.bisect(days, d)
            if ret > 0 and days[ret-1] == d:
                c3 = dp[ret-1] + costs[2]
            else:
                if ret == 0:
                    c3 = costs[2]
                else:
                    c3 = dp[ret-1] + costs[2]
            
            dp[i] = min(c1, c2, c3)
        return dp[-1]
