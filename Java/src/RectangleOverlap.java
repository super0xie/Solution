
public class RectangleOverlap {
    
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
        boolean res = true;
        
        
        if(rec1[0] <= rec2[0]) {
            res = res && rec2[0] < rec1[2];
        }else {
            res = res && rec1[0] < rec2[2];
        }
        
        if(rec1[1] <= rec2[1]) {
            res = res && rec2[1] < rec1[3];
        }else {
            res = res && rec1[1] < rec2[3];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] rec1 = {7,8,13,15};
        int[] rec2 = {10,8,12,20};
        RectangleOverlap test = new RectangleOverlap();
        System.out.println(test.isRectangleOverlap(rec1, rec2));
    }

}
