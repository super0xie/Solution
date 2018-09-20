
public class RectangleArea {
    
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int w = 0;
        int h = 0;
        
        if(A <= E) {
            if(E < C) w = Math.min(C, G) - E;
            else w = 0;
        }else {
            if(A < G) w = Math.min(C, G) - A;
            else w = 0;
        }
        
        if(B <= F) {
            if(F < D) h = Math.min(D, H) - F;
            else h = 0;
        }else {
            if(B < H) h = Math.min(D, H) - B;
            else h = 0;
        }
        
        return (C-A)*(D-B) + (G-E)*(H-F) - w*h;
    }
    
    public static void main(String[] args) {
        RectangleArea test = new RectangleArea();
        System.out.println(test.computeArea(0, 0, 0, 0, -1, -1, 1, 1));
    }

}
