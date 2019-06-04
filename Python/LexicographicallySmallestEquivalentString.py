class Solution:

    def smallestEquivalentString(self, A: str, B: str, S: str) -> str:
        res = ""
        uf = [0] * 26
        for i in range(26):
            uf[i] = i
        
        for i in range(len(A)):
            self.union(uf, ord(A[i])-ord('a'), ord(B[i])-ord('a'))

        for i in range(len(S)):
            res = res + chr(ord('a') + self.getRoot(uf, ord(S[i])-ord('a')))
        return res
        
    def getRoot(self, uf, i):
        if uf[i] == i:
            return i
        else:
            r = self.getRoot(uf, uf[i])
            uf[i] = r
            return r

    def union(self, uf, i, j):
        r1 = self.getRoot(uf, i)
        r2 = self.getRoot(uf, j)
        if r1 != r2:
            if r1 < r2:
                uf[r2] = r1
            else:
                uf[r1] = r2

test = Solution()
print(test.smallestEquivalentString("parker", "morris", "parser"))
