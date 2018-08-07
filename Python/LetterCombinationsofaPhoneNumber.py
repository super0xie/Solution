from collections import deque

class Solution:
    table = [
        ['a', 'b', 'c'],
        ['d', 'e', 'f'],
        ['g', 'h', 'i'],
        ['j', 'k', 'l'],
        ['m', 'n', 'o'],
        ['p', 'q', 'r', 's'],
        ['t', 'u', 'v'],
        ['w', 'x', 'y', 'z']]

    def letterCombinations(self, digits):
        if len(digits) == 0:
            return []
        queue = deque(Solution.table[int(digits[0])-2])

        for i in range(1, len(digits)):
            count = len(queue)
            row = int(digits[i]) - 2
            for j in range(count):
                str = queue.popleft()
                for k in range(len(Solution.table[row])):
                    queue.append(str + Solution.table[row][k])

        return list(queue)


if __name__ == "__main__":
    test = Solution()
    print(test.letterCombinations("2"))