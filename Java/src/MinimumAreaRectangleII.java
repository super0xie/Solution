import java.util.Arrays;
import java.util.HashSet;

public class MinimumAreaRectangleII{

    public double minAreaFreeRect(int[][] points) {
        Arrays.sort(points, (a, b)->{
            if(a[1] != b[1]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
        });

        int n = points.length;
        HashSet<Integer> set = new HashSet<>();

        for(int[] p : points){
            int encode = encode(p);
            set.add(encode);
        }
        
        long areaSq = Long.MAX_VALUE;
        for(int i = 0; i < n-3; i++){
            for(int j = i+1; j < n-2; j++){
                for(int k = j+1; k < n-1; k++){
                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    int[] p3 = points[k];
                    if(vert(p1, p2, p3)){
                        int[] p4 = new int[] {p3[0]+p2[0]-p1[0], p3[1]+p2[1]-p1[1]};
                        int encode = encode(p4);
                        if(set.contains(encode)){
                            long curAreaSq = ((long)(sq(p2[0]-p1[0]) + sq(p2[1]-p1[1]))) * (sq(p3[0]-p1[0]) + sq(p3[1]-p1[1]));
                            if(curAreaSq < areaSq) areaSq = curAreaSq;
                        }
                    }
                }
            }
        }
        if(areaSq == Long.MAX_VALUE) return 0;
        return Math.sqrt(areaSq);
    }

    private int sq(int i){
        return i * i;
    }

    private int encode(int[] p){
        return 40001 * p[0] + p[1];
    }

    private boolean vert(int[] p1, int[] p2, int[] p3){
        return (p3[1]-p1[1]) * (p2[1]-p1[1]) + (p3[0]-p1[0]) * (p2[0]-p1[0]) == 0;
    }

    public static void main(String[] args) {
        int[][] points = {{24420,16685},{20235,25520},{14540,20845},{20525,14500},{16876,24557},{24085,23720},{25427,18964},{21036,14573},{24420,23315},{22805,24760},{21547,25304},{16139,23952},{21360,14645},{24715,17120},{19765,25520},{19388,25491},{22340,25005},{25520,19765},{25365,21320},{23124,15443},{20845,14540},{24301,16532},{16685,24420},{25100,17875},{22125,25100},{15699,23468},{14592,21131},{25460,19155},{17837,25084},{23468,24301},{25460,20845},{18453,25304},{21131,14592},{22805,15240},{19475,25500},{15443,23124},{25355,21360},{15285,22880},{20000,25525},{24085,16280},{22163,25084},{22880,15285},{14916,22163},{16280,24085},{24875,17400},{22600,24875},{14573,21036},{25427,21036},{17120,24715},{25500,19475}};
        MinimumAreaRectangleII test = new MinimumAreaRectangleII();
        System.out.print(test.minAreaFreeRect(points));
    }


}