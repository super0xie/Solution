import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class HighFive {

    public int[][] highFive(int[][] items) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int[] i : items){
            if(!map.containsKey(i[0])) map.put(i[0], new ArrayList<>());
            map.get(i[0]).add(i[1]);
        }

        int[][] res = new int[map.size()][2];
        int idx = 0;
        for(int i : map.keySet()){
            ArrayList<Integer> l = map.get(i);
            Collections.sort(l);

            int sum = 0;
            for(int j = l.size()-1; j >= l.size()-5; j--) sum += l.get(j);

            res[idx][0] = i;
            res[idx++][1] = sum / 5;
        }

        return res;
    }

}