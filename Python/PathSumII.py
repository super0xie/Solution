# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from TreeNode import TreeNode

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        self.tar = sum
        self.res = []
        self.dfs(root, [], 0)
        return self.res
        

    def dfs(self, n, l, sum):
        if n == None:
            return
        if n.left == None and n.right == None:
            if sum + n.val == self.tar:
                copy = list(l)
                copy.append(n.val)
                self.res.append(copy)
        
        l.append(n.val)
        self.dfs(n.left, l, sum + n.val)
        self.dfs(n.right, l, sum + n.val)
        l.pop(len(l)-1)

if __name__ == "__main__":
    test = Solution()
    root = TreeNode(1)
    res = test.pathSum(root, 1)
    print(res)

