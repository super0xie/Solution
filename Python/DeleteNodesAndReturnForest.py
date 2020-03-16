
class Solution:
    def delNodes(self, root: TreeNode, to_delete: List[int]) -> List[TreeNode]:
        self.res = []
        self.d = [False] * 1001

        for i in to_delete:
            self.d[i] = True

        if not self.d[root.val]:
            self.res.append(root)

        self.dfs(root)
        return self.res

    def dfs(self, n: TreeNode):
        
        l = n.left
        r = n.right

        if l != None:
            if not self.d[l.val] and self.d[n.val]:
                self.res.append(l)
            if self.d[l.val]:
                n.left = None
            self.dfs(l)
        
        if r != None:
            if not self.d[r.val] and self.d[n.val]:
                self.res.append(r)
            if self.d[r.val]:
                n.right = None
            self.dfs(r)
            



