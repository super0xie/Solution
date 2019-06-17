import math

class Solution:
    def minimizeError(self, prices: List[str], target: int) -> str:
        map = {0:0}
        max = 100000000
        for str in prices:
            cur = {}
            d = float(str)
            floor = math.floor(d)
            floorError = math.fabs(floor - d)
            ceil = math.ceil(d)
            ceilError = math.fabs(ceil - d)

            for key in map:
                n = key + floor
                cur[n] = min(cur[n] if n in cur else max, map[key] + floorError)
                n = key + ceil
                cur[n] = min(cur[n] if n in cur else max, map[key] + ceilError)

            map = cur
        
        if target in map:
            d = map[target]
            res = "%.3f" % d
            return res
        else:
            return "-1"
