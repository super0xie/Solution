class Solution:
    def smallestSubsequence(self, text: str) -> str:
        res = ""
        added = set()
        last = {}
        for i in range(len(text)):
            last[text[i]] = i
        
        for i in range(len(text)):
            if text[i] in added:
                continue
            add = False

            if last[text[i]] == i:
                add = True
            
            if not add:
                for j in range(i+1, len(text)):
                    if text[j] in added:
                        continue
                    if text[j] < text[i] and last[text[i]] > j:
                        break
                    if text[j] > text[i] and last[text[j]] == j:
                        add = True
                        break
            
            if add:
                res += text[i]
                added.add(text[i])
        
        return res

test = Solution()
print(test.smallestSubsequence("cdadabcc"))
