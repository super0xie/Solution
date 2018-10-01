class Solution(object):
    def inorderSuccessor(self, root, p):
        """
        :type root: TreeNode
        :type p: TreeNode
        :rtype: TreeNode
        """
        self.pre = None
        self.succ = None
        self.dfs(root, p)
        return self.succ

    def dfs(self, node, p):
        if node == None:
            return

        self.dfs(node.left, p)
        if self.pre == p:
            self.succ = node
        self.pre = node;
        self.dfs(node.right, p)

    def inorderSuccessor(self, root, p):
        res = None
        while root:
            if p.val < root.val:
                res = root
                root = root.left
            else:
                root = root.right
        return res




