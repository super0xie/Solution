
public class PourWater {
    
    public int[] pourWater(int[] heights, int V, int K) {
        int[] res = new int[heights.length];
        for(int i = 0; i < heights.length; i++) {
            res[i] = heights[i];
        }
        
        if(res.length == 1) {
            res[0]+= V;
            return res;
        }
        
        while(V > 0) {
            int i = K-1;
            int tar = K;
            
            while(i >= 0) {
                if(res[i] > res[i+1]) break;
                else if(res[i] < res[i+1]) tar = i;
                i--;
            }
            
            if(tar != K) {
                res[tar]++;
                V--;
                continue;
            }
            
            i = K+1;
            while(i < res.length) {
                if(res[i] > res[i-1]) break;
                else if(res[i] < res[i-1]) tar = i;
                i++;
            }
            
            if(tar != K) {
                res[tar]++;
                V--;
                continue;
            }
            
            res[K]++;
            V--;
        }
        
        return res;
    }
    public static void main(String[] args) {
        int[] heights = {3,1,3};
        PourWater test = new PourWater();
        test.pourWater(heights, 5, 1);
    }
    
    
    
}
