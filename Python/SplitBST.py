class Solution:

    def splitBST(self, root, V):
        """
        :type root: TreeNode
        :type V: int
        :rtype: List[TreeNode]
        """
        if root == None:
            return [None, None]

        if root.val <= V:
            r = self.splitBST(root.right, V)
            root.right = r[0]
            return [root, r[1]]
        else:
            r = self.splitBST(root.left, V)
            root.left = r[1]
            return [r[0], root]



