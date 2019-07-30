class Solution:

    def maxDepthAfterSplit(self, seq: str) -> List[int]:
        res = []
        a = 0
        b = 0
        for i in range(len(seq)):
            if seq[i] == '(':
                if a <= b:
                    a += 1
                    res.append(0)
                else:
                    b += 1
                    res.append(1)
            else:
                if a >= b:
                    a -= 1
                    res.append(0)
                else:
                    b -= 1
                    res.append(1)
        return res
