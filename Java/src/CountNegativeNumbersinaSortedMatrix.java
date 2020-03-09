
public class CountNegativeNumbersinaSortedMatrix {
    public int countNegativesOld(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] < 0) res++;
            }
        }
        return res;
    }
    
    public int countNegatives(int[][] grid) {
        int res = 0;
        int end = grid[0].length;
        for(int i = 0; i < grid.length; i++) {
            int l = 0;
            int r = end;
            
            while(l < r) {
                int mid = l + (r-l)/2;
                if(grid[i][mid] >= 0) {
                    l = mid+1;
                }else {
                    r = mid;
                }
            }
            
            res += grid[0].length - r;
            end = r;
            
        }
        return res;
    }
    
    public static void main(String[] args) {
        CountNegativeNumbersinaSortedMatrix test = new CountNegativeNumbersinaSortedMatrix();
        int[][] grid = {{3,2},{1,0}};
        System.out.println(test.countNegatives(grid));
    }
}
