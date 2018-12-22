
public class ConstructQuadTree {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };
    
    
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length-1, grid[0].length-1);
    }
    
    private Node helper(int[][] grid, int r, int c, int m, int n) {
        
        int i = r;
        int j = 0;
        for(; i <= m; i++) {
            j = c;
            for(; j <= n; j++) {
                if(grid[i][j] != grid[r][c]) break;
            }
            if(j != n+1) break;
        }
        
        if(i == m+1 && j == n+1) {
            Node ret = new Node();
            ret.isLeaf = true;
            ret.val = grid[r][c] == 1;
            return ret;
        }else {
            Node ret = new Node();
            ret.isLeaf = false;
            ret.topLeft = helper(grid, r, c, (r + m)/2, (c + n)/2);
            ret.topRight = helper(grid, r, (c + n)/2+1, (r + m)/2, n);
            ret.bottomLeft = helper(grid, (r + m)/2+1, c, m, (c + n)/2);
            ret.bottomRight = helper(grid, (r+m)/2+1, (c+n)/2+1, m, n);
            return ret;
        }
    }
    
    public static void main(String[] args) {
        ConstructQuadTree test = new ConstructQuadTree();
        int[][] grid = {{0,0,0,0,1,1,0,0},{0,0,0,0,1,1,0,0},{1,1,0,0,1,1,1,1},{1,1,0,0,1,1,1,1},{1,1,0,0,1,1,1,1},{1,1,0,0,1,1,1,1},{1,1,0,0,0,0,1,1},{1,1,0,0,0,0,1,1}};
        Node n = test.construct(grid);
        System.out.println("helo");
    }
}
