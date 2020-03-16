import bisect

class Solution:

    def shortestWay(self, source: str, target: str) -> int:
        map = {}
        for i in range(len(source)):
            if source[i] not in map:
                map[source[i]] = []
            map[source[i]].append(i)
        res = 1
        idx = -1
        i = 0
        while i < len(target):
            if target[i] not in map:
                return -1
            l = map[target[i]]
            ret = bisect.bisect_left(l, idx+1)
            if ret == len(l):
                res += 1
                idx = -1
            else:
                idx = l[ret]
                i += 1
        return res

test = Solution()
print(test.shortestWay("adbsc", "addddddddddddsbc"))

