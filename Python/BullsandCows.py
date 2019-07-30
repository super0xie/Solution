class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        n = len(secret)
        bulls = 0
        count = {}
        for i in range(n):
            if secret[i] == guess[i]:
                bulls += 1
            else:
                if secret[i] in count:
                    count[secret[i]] += 1
                else:
                    count[secret[i]] = 1
        cows = 0
        for i in range(n):
            if secret[i] != guess[i]:
                if guess[i] in count and count[guess[i]] > 0:
                    cows += 1
                    count[guess[i]] -= 1
        return str(bulls) + "A" + str(cows) + "B"



test = Solution()
secret = "1123"
guess = "0111"
print(test.getHint(secret, guess))