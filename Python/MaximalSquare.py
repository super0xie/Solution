from typing import List

class Solution:

    def maximalSquare(self, matrix: List[List[str]]) -> int:
        res = 0

        m = len(matrix)
        if m == 0:
            return 0
        n = len(matrix[0])

        d = {}

        for i in range(m):
            j = 0
            aux = {}
            while j < n:
                if matrix[i][j] == "0":
                    j += 1
                else:
                    k = j
                    while k < n and matrix[i][k] == "1":
                        encode = 100 * j + k

                        if encode in d:
                            aux[encode] = d[encode] + 1
                        else:
                            aux[encode] = 1
                        
                        side = min(k-j+1, aux[encode])
                        res = max(res, side * side)
                        k += 1
                    j += 1
            d = aux
            i += 1

        return res

test = Solution()
matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
print(test.maximalSquare(matrix))









