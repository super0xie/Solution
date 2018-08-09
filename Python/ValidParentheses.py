class Solution:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        for i in range(len(s)):
            if s[i] == '(' or s[i] == '[' or s[i] == '{':
                stack.append(s[i])
            else:
                if len(stack) == 0:
                    return False
                poped = stack.pop()
                if (poped == '(' and s[i] != ')') or (poped == '[' and s[i] != ']') or (poped == '{' and s[i] != '}'):
                    return False
        if len(stack) == 0:
            return True
        return False
