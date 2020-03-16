import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class LargestRectangleinHistogram {

    public int largestRectangleAreaOld(int[] heights) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        for(int i = 0; i < heights.length; i++){
            ArrayList<Integer> l = map.getOrDefault(heights[i], new ArrayList<>());
            l.add(i);
            map.put(heights[i], l);
        }

        TreeSet<Integer> set = new TreeSet<>();
        int res = 0;
        for(int i : map.keySet()){
            ArrayList<Integer> l = map.get(i);
            for(int idx : l){
                Integer floor = set.floor(idx);
                int left = floor == null ? 0 : floor + 1;
                Integer ceil = set.ceiling(idx);
                int right = ceil == null ? heights.length-1 : ceil-1;

                res = Math.max(res, i * (right - left + 1));
            }

            set.addAll(l);
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;

        for(int i = 0; i < heights.length; i++){
            int min = heights[i];
            for(int j = i; j < heights.length; j++){
                min = Math.min(min, heights[j]);
                res = Math.max(res, (j-i+1)*min);
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        LargestRectangleinHistogram test = new LargestRectangleinHistogram();
        System.out.println(test.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

}