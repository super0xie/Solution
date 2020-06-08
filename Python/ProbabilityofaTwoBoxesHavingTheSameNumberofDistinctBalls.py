import math
from typing import List

class Solution:
    def getProbability(self, balls: List[int]) -> float:
        k = len(balls)
        sum = 0
        for b in balls:
            sum += b
        total = math.factorial(sum)
        self.tar = sum / 2
        for b in balls:
            total = total / math.factorial(b)
        a = [0]*k;
        b = [0]*k;
        self.aux = math.factorial(self.tar)
        self.aux = self.aux * self.aux
        valid = self.dfs(0, balls, a, b, 0, 0, 0, 0)
        return valid / total

    def dfs(self, i, balls, a, b, sa, sb, ca, cb):
        res = 0
        for n in range(balls[i]+1):
            a[i] = n
            b[i] = balls[i]-n
            nca = ca
            if n > 0:
                nca += 1
            ncb = cb
            if balls[i]-n > 0:
                ncb += 1

            nsa = sa+n
            nsb = sb+balls[i]-n

            if nsa > self.tar or nsb > self.tar:
                continue

            if abs(nca-ncb) > len(balls)-1-i:
                continue

            if i == len(balls)-1:
                if nsa != nsb or nca != ncb:
                    continue
                cur = self.aux

                for c in a:
                    if c > 1:
                        cur = cur / math.factorial(c)

                for c in b:
                    if c > 1:
                        cur = cur / math.factorial(c)

                return cur

            else:
                res += self.dfs(i+1, balls, a, b, nsa, nsb, nca, ncb)
        return res

test = Solution()
print(test.getProbability([6,6,6,6,6,6]))




