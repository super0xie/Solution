
public class ImageSmoother {
    
    public int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        

        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length; j++) {
                
                int sum = 0;
                int count = 0;
                for(int r = i-1; r <= i+1; r++) {
                    for(int c = j-1; c <= j+1; c++) {
                        if(r >= 0 && r < M.length && c >= 0 && c < M[0].length) {
                            sum += M[r][c];
                            count++;
                        }
                    }
                }
                
                res[i][j] = sum / count;
                
            }
        }
        
        return res;
        
    }
}
