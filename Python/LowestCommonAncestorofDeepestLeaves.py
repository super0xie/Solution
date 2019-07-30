class Solution:
    def lcaDeepestLeaves(self, root: TreeNode) -> TreeNode:
        self.h = self.height(root)

        self.dfs(root, 1)
        return self.res



    def height(self, n: TreeNode) -> int:
        if n == None:
            return 0

        l = self.height(n.left)
        r = self.height(n.right)
        return max(l, r) + 1

    def dfs(self, n: TreeNode, depth: int) -> bool:
        if n == None:
            return False
        
        if depth == self.h:
            self.res = n
            return True

        l = self.dfs(n.left, depth+1)
        r = self.dfs(n.right, depth+1)

        if l and r:
            self.res = n
        
        return l or r



    
