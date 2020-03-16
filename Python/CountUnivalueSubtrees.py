
class Solution:
    def countUnivalSubtrees(self, root: TreeNode) -> int:
        self.res = 0
        self.dfs(root)
        return self.res



    def dfs(self, n: TreeNode) -> bool:
        if n == None:
            return True
        
        l = self.dfs(n.left)
        r = self.dfs(n.right)

        if l and r and (n.left == None or n.val == n.left.val) and (n.right == None or n.val == n.right.val):
            self.res += 1
            return True
        return False
