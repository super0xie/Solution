import java.util.Arrays;
import java.util.HashSet;

public class PerfectRectangle {

    public boolean isRectangleCoverTLE(int[][] rectangles) {
        HashSet<Integer> set = new HashSet<>();

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(int i = 0; i < rectangles.length; i++){
            int[] rect = rectangles[i];
            minX = Math.min(rect[0], minX);
            minY = Math.min(rect[1], minY);
            maxX = Math.max(rect[2], maxX);
            maxY = Math.max(rect[3], maxY);

            for(int j = rect[0]; j < rect[2]; j++){
                for(int k = rect[1]; k < rect[3]; k++){
                    int encode = encode(j, k);
                    if(set.contains(encode)) return false;
                    set.add(encode);
                }
            }
        }

        return set.size() == (maxX-minX) * (maxY-minY);
    }

    public boolean isRectangleCover(int[][] rectangles) {

        Arrays.sort(rectangles, (a, b)->{
            if(a[1] != b[1]) return a[1]-b[1];
            else{
                return a[0]-b[0];
            }
        });

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for(int i = 0; i < rectangles.length; i++){
            int[] rect = rectangles[i];
            minX = Math.min(rect[0], minX);
            minY = Math.min(rect[1], minY);
            maxX = Math.max(rect[2], maxX);
            maxY = Math.max(rect[3], maxY);
        }

        int [] l = new int[maxX-minX];
        Arrays.fill(l, minY);
        
        for(int i = 0; i < rectangles.length; i++){
            int[] rect = rectangles[i];
            if(rect[2] > maxX) return false;
            if(rect[0] < minX) return false;
            for(int j = rect[0]; j < rect[2]; j++){
                if(l[j-minX] != rect[1]) return false;
                l[j-minX] = rect[3];
            }
        }

        for(int i : l) if(i != maxY) return false;
        return true;
    }

    private int encode(int i, int j){
        return i * 10000000 + j;
    }

    public static void main(String[] args) {
        PerfectRectangle test = new PerfectRectangle();
        int[][] rectangles = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        System.out.println(test.isRectangleCover(rectangles));
    }



}