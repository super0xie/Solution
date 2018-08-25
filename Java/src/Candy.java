
public class Candy {
    
    public int candy(int[] ratings) {
        int [] ltr = new int [ratings.length];
        int [] rtl = new int [ratings.length];
        
        
        ltr[0] = 1;
        rtl[ratings.length-1] = 1;
        
        
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) ltr[i] = ltr[i-1] + 1;
            else ltr[i] = 1;
        }
        
        
        for(int i = ratings.length-1; i>=0; i--) {
            if(ratings[i] > ratings[i+1]) rtl[i] = rtl[i+1] + 1;
            else rtl[i] = 1;
        }
        
        int result = 0;
        for(int i = 0; i < ratings.length; i++) {
            result += Math.max(ltr[i], rtl[i]);
        }
        
        return result; 
        
    }
    
}
