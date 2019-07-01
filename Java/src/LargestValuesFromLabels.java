import java.util.Arrays;
import java.util.HashMap;


public class LargestValuesFromLabels {

    class Node {
        int v;
        int l;
        Node(int v, int l){
            this.v = v;
            this.l = l;
        }
    }

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        
        Node[] l = new Node[values.length];
        for(int i = 0; i < values.length; i++){
            l[i] = new Node(values[i], labels[i]);
        }

        Arrays.sort(l, (a, b)->{
            return b.v - a.v;
        });

        HashMap<Integer, Integer> map = new HashMap<>();

        int res = 0;
        int count = 0;
        for(int i = 0; i < l.length; i++){
            if(map.containsKey(l[i].l) && map.get(l[i].l) == use_limit) continue;
            map.put(l[i].l, map.getOrDefault(l[i].l, 0)+1);
            count++;
            res += l[i].v;
            if(count == num_wanted) break;
        }
    
        return res;
    }


    public static void main(String[] args) {
        LargestValuesFromLabels test = new LargestValuesFromLabels();
        int[] values = {9,8,8,7,6};
        int[] labels = {0,0,0,1,1};
        System.out.println(test.largestValsFromLabels(values, labels, 3, 1));
    }

}