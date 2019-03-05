import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SmallestRange {

    public int[] smallestRange(List<List<Integer>> nums) {
        HashMap<Integer, ArrayList<Integer>> tmap = new HashMap<>();

        int idx = 0;
        for(List<Integer> l : nums){
            for(int i : l){
                if(tmap.get(i) == null) tmap.put(i, new ArrayList<>());
                tmap.get(i).add(idx);
            }
            idx++;
        }

        int r = -1;
        int l = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> keys = new ArrayList<>();

        for(int i : tmap.keySet()){
            keys.add(i);
        }
        Collections.sort(keys);

        int[] res = new int[]{0, Integer.MAX_VALUE};
        while(r < keys.size()){
            if(map.size() < nums.size()){
                r++;
                if(r < keys.size()){
                    for(int i : tmap.get(keys.get(r))){
                        map.put(i, map.getOrDefault(i, 0)+1);
                    }
                }
            }else{
                if(keys.get(r) - keys.get(l) < res[1]-res[0]){
                    res[0] = keys.get(l);
                    res[1] = keys.get(r);
                }

                for(int i : tmap.get(keys.get(l))){
                    map.put(i, map.getOrDefault(i, 0)-1);
                    if(map.get(i) == 0) map.remove(i);
                }
                l++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{-89,1,69,89,90,98},{-43,-36,-24,-14,49,61,66,69},{73,94,94,96},{11,13,76,79,90},{-40,-20,1,9,12,12,14},{-91,-31,0,21,25,26,28,29,29,30},{23,88,89},{31,42,42,57},{-2,6,11,12,12,13,15},{-3,25,34,36,39},{-7,3,29,29,31,32,33},{4,11,14,15,15,18,19},{-34,9,12,19,19,19,19,20},{-26,4,47,53,64,64,64,64,64,65},{-51,-25,36,38,50,54},{17,25,38,38,38,38,40},{-30,12,15,19,19,20,22},{-14,-13,-10,68,69,69,72,74,75},{-39,42,70,70,70,71,72,72,73},{-67,-34,6,26,28,28,28,28,29,30,31}};
        List<List<Integer>> nums = new ArrayList<>();
        for(int[] a :  arr){
            List<Integer> l = new ArrayList<>();
            for(int i : a){
                l.add(i);
            }
            nums.add(l);
        }
        SmallestRange test = new SmallestRange();
        int[] res = test.smallestRange(nums);

        System.out.println("" + res[0] + ", " + res[1]);
    }

}