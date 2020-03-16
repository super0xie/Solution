from typing import List

class Solution:

    def maxEqualRowsAfterFlips(self, matrix: List[List[int]]) -> int:
        l = {}
        m = len(matrix)
        n = len(matrix[0])
        res = 0
        for i in range(m):
            if matrix[i][0] == 0:
                for j in range(n):
                    matrix[i][j] = matrix[i][j] ^ 1
            
            encode = ""
            for j in range(n):
                encode = encode + str(matrix[i][j])
            
            if encode not in l:
                l[encode] = 1
            else:
                l[encode] += 1

            res = max(res, l[encode])
        
        return res


test = Solution()
print(test.maxEqualRowsAfterFlips([[0,0,0],[0,0,1],[1,1,0]]))


