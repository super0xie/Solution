import math

class Solution:
    def bulbSwitch(self, n: int) -> int:
        return math.floor(math.sqrt(n))

test = Solution()
print(test.bulbSwitch(4))