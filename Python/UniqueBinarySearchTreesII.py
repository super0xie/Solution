from TreeNode import TreeNode
from typing import List

class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        if n == 0:
            return []
        return self.helper(1, n)

    def helper(self, l, r) -> List[TreeNode]:
        res = []
        if l > r:
            res.append(None)
        elif l == r:
            res.append(TreeNode(l))
        else:
            for i in range(l, r+1):
                lsub = self.helper(l, i-1)
                rsub = self.helper(i+1, r)

                for j in range(len(lsub)):
                    for k in range(len(rsub)):
                        root = TreeNode(i)
                        root.left = lsub[j]
                        root.right = rsub[k]
                        res.append(root)
        return res
