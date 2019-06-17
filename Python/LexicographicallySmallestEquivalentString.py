import string

class Solution:

    def smallestEquivalentString(self, A: str, B: str, S: str) -> str:
        res = ""
        
        uf = {s: s for s in string.ascii_lowercase}
        
        for i in range(len(A)):
            self.union(uf, A[i], B[i])

        for i in range(len(S)):
            res = res + self.getRoot(uf, S[i])
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
