class Solution:
    def maximumAverageSubtree(self, root: TreeNode) -> float:
        self.res = 0
        self.dfs(root)
        return self.res

    def dfs(self, n: TreeNode) -> List[int]:
        if n == None:
            return [0, 0]
        l = self.dfs(n.left)
        r = self.dfs(n.right)

        sum = l[0] + r[0] + n.val
        count = l[1] + r[1] + 1

        self.res = max(self.res, sum / count)
        return [sum, count]

    