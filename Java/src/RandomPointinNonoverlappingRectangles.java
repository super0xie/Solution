import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomPointinNonoverlappingRectangles {
    
    
    private ArrayList<Integer> l;
    private int[][] rects;
    private Random r;
    private int sum;
    
    public void Solution(int[][] rects) {
        this.rects = rects;
        r = new Random();
        l = new ArrayList<>();
        sum = 0;
        for(int i = 0; i < rects.length; i++) {
            int area = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            sum += area;
            l.add(sum);
        }
    }
    
    public int[] pick() {
        int ran = r.nextInt(sum);
        int i = Collections.binarySearch(l, ran);
        if(i >= 0) i++;
        else if(i < 0) i = -i-1;
        
        int x = r.nextInt(rects[i][2] - rects[i][0] + 1) + rects[i][0];
        int y = r.nextInt(rects[i][3] - rects[i][1] + 1) + rects[i][1];
        return new int[] {x, y};
    }
    
    public static void main(String[] args) {
        RandomPointinNonoverlappingRectangles test = new RandomPointinNonoverlappingRectangles();
        int[][] rects = {{53487036, -14015982, 53487038, -14015981}, {-50242787, -25148635, -50242784, -25148633}, {1261120, -29805890, 1261122, -29805889}, {28991269, 54212557, 28991271, 54212559}};
        test.Solution(rects);
        
    }
}
