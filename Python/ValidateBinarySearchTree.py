
class Solution:

    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        self.res = True
        self.validBST(root)
        return self.res

    def validBST(self, node):
        if node == None:
            return None
        l = self.validBST(node.left)
        r = self.validBST(node.right)
        ret = [node.val,node.val]

        if l != None:
            if l[1] >= node.val:
                self.res = False
            ret[0] = l[0]

        if r != None:
            if r[0] <= node.val:
                self.res = False
            ret[1] = r[1]

        return ret

