class Solution:
    f = [1, 1, 2, 6, 24, 120, 720, 5040]
    def numTilePossibilities(self, tiles: str) -> int:
        map = {}
        for i in range(len(tiles)):
            if tiles[i] in map:
                map[tiles[i]] += 1
            else:
                map[tiles[i]] = 1

        count = []
        for i in map:
            if map[i] > 0:
                count.append(map[i])

        self.res = 0
        self.dfs(0, 0, count, [0]*len(count))
        return int(self.res)
    

    def dfs(self, idx, sum, count, n):
        if idx == len(count):
            if(sum > 0):
                r = self.f[sum]
                for i in range(len(count)):
                    r /= self.f[n[i]]
                self.res += r
            return
        for i in range(count[idx]+1):
            n[idx] = i
            self.dfs(idx+1, sum+i, count, n)

test = Solution()
print(test.numTilePossibilities("AAB"))



            