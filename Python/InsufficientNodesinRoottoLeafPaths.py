import TreeNode

class Solution:
    def sufficientSubset(self, root: TreeNode, limit: int) -> TreeNode:
        res = self.dfs(root, 0, limit)
        if not res:
            return None
        return root


    def dfs(self, n: TreeNode, sum: int, limit: int) -> bool:
        if n == None:
            return False
        total = sum + n.val
        res = False
        if n.left == None and n.right == None:
            if total >= limit:
                res = True
            else:
                res = False
        else:
            l = self.dfs(n.left, total, limit)
            r = self.dfs(n.right, total, limit)
            if not l:
                n.left = None
            if not r:
                n.right = None
            res = l or r
        return res


