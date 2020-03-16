class Solution:
    def removeVowels(self, S: str) -> str:
        res = ""
        for i in range(len(S)):
            c = S[i]
            if not (c == 'a' or c == 'e' or c == 'i' or c == 'o' or c == 'u'):
                res += c
        return res