
public class SquirrelSimulation {
    
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int max = Integer.MIN_VALUE;
        int r = 0;
        int c = 0;
        for(int i = 0; i < nuts.length; i++) {
            int dis = Math.abs(squirrel[0]-nuts[i][0]) + Math.abs(squirrel[1]-nuts[i][1]);
            int disTree = Math.abs(tree[0]-nuts[i][0]) + Math.abs(tree[1]-nuts[i][1]);
            int saved = disTree - dis;
            if(saved > max) {
                max = saved;
                r = nuts[i][0];
                c = nuts[i][1];
            }
        }
        
        int res = 0;
        res += Math.abs(tree[0]-r) + Math.abs(tree[1]-c);
        res += Math.abs(squirrel[0]-r) + Math.abs(squirrel[1]-c);
        
        for(int i = 0; i < nuts.length; i++) {
            if(nuts[i][0] == r && nuts[i][1] == c) {
                continue;
            }else {
                res += (Math.abs(tree[0]-nuts[i][0]) + Math.abs(tree[1]-nuts[i][1])) * 2;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        SquirrelSimulation test = new SquirrelSimulation();
        int height = 5;
        int width = 7;
        int [] tree = {3, 2};
        int [] squirrel = {0, 1};
        int[][] nuts = {{2,0},{4,1},{0,4},{1,3},{1,0},{3,4},{3,0},{2,3},{0,2},{0,0},{2,2},{4,2},{3,3},{4,4},{4,0},{4,3},{3,1},{2,1},{1,4},{2,4}};
        test.minDistance(height, width, tree, squirrel, nuts);
    }
    
}
