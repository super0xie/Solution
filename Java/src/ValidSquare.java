

public class ValidSquare {
    
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] vec1 = new int[] {p2[0]-p1[0], p2[1]-p1[1]};
        int[] vec2 = new int[] {p4[0]-p3[0], p4[1]-p3[1]};
        if(vec1[0] == 0 && vec1[1] == 0) return false;
        if(vec2[0] == 0 && vec2[1] == 0) return false;
        
        int[][] nodes = null;
        if(vec1[0] * vec2[1] == vec1[1] * vec2[0]) {
            if(vec1[0] == vec2[0] && vec1[1] == vec2[1]) nodes = new int[][] {p1,p2,p4,p3};
            else nodes = new int[][] {p1,p2,p3,p4};
        }else {
            nodes = new int[][] {p1,p4,p2,p3};
        }
        
        if(!helper(nodes[0], nodes[1], nodes[0], nodes[3])) return false;
        if(!helper(nodes[0], nodes[1], nodes[1], nodes[2])) return false;
        if(!helper(nodes[1], nodes[2], nodes[2], nodes[3])) return false;
        if(!helper(nodes[1], nodes[3], nodes[0], nodes[2])) return false;
        return true;
        
    }
    
    private boolean helper(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] vec1 = new int[] {p2[0]-p1[0], p2[1]-p1[1]};
        int[] vec2 = new int[] {p4[0]-p3[0], p4[1]-p3[1]};
        return helper(vec1, vec2);
    }
    
    private boolean helper(int[] v1, int[] v2) {
        return v1[0]*v2[0] + v1[1]*v2[1] == 0;
    }
    
    public static void main(String[] args) {
        int[] p1 = {0, 0};
        int[] p2 = {1, 1};
        int[] p3 = {1, 0};
        int[] p4 = {0, 1};
        ValidSquare test = new ValidSquare();
        test.validSquare(p1, p2, p3, p4);
    }
    
}
