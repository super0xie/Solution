import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class TallestBillboard {

    public int tallestBillboardTLE(int[] rods) {
        TreeMap<Integer, ArrayList<ArrayList<Integer>>> map = new TreeMap<>(Collections.reverseOrder());

        for(int i = 0; i < rods.length; i++){
            HashMap<Integer, ArrayList<ArrayList<Integer>>> aux = new HashMap<>();

            for(int n : map.keySet()){
                int sum = n + rods[i];
                if(!aux.containsKey(sum)){
                    aux.put(sum, new ArrayList<>());
                }
                ArrayList<ArrayList<Integer>> l = map.get(n);

                for(ArrayList<Integer> list : l){
                    ArrayList<Integer> copy = new ArrayList<>(list);
                    copy.add(i);
                    aux.get(sum).add(copy);
                }
            }

            for(int key : aux.keySet()){
                if(map.containsKey(key)){
                    map.get(key).addAll(aux.get(key));
                }else{
                    map.put(key, aux.get(key));
                }
            }

            if(!map.containsKey(rods[i])){
                map.put(rods[i], new ArrayList<>());
            }
            map.get(rods[i]).add(new ArrayList<>(Arrays.asList(i)));
        }

        for(int key : map.keySet()){
            ArrayList<ArrayList<Integer>> l = map.get(key);
            if(l.size() < 2) continue;

            for(int i = 0; i < l.size(); i++){
                boolean[] visited = new boolean[rods.length];
                
                for(int idx : l.get(i)) visited[idx] = true;
                
                for(int j = i + 1; j < l.size(); j++){
                    if(l.get(i).size() + l.get(j).size() > rods.length) continue;
                    boolean overlap = false;
                    for(int idx : l.get(j)) {
                        if(visited[idx]) {
                            overlap = true;
                            break;
                        }
                    }
                    if(!overlap) return key;
                }
            }

        }

        return 0;
        
    }
    
    public int tallestBillboardOld(int[] rods) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : rods){
            HashMap<Integer, Integer> aux = new HashMap<>();

            ArrayList<Integer> l = new ArrayList<>();
            l.add(i);
            l.add(-i);

            for(int key : map.keySet()){
                for(int j : l){
                    int sum = key + j;
                    int max = 0;
                    if(j > 0) max = map.get(key) + j;
                    else max = map.get(key);
                    
                    if(aux.containsKey(sum)) aux.put(sum, Math.max(aux.get(sum), max));
                    else aux.put(sum, max);
                }
            }

            for(int key : aux.keySet()){
                if(map.containsKey(key)) map.put(key, Math.max(map.get(key), aux.get(key)));
                else map.put(key, aux.get(key));
            }

            for(int j : l){
                if(map.containsKey(j)) map.put(j, Math.max(map.get(j), j));
                else map.put(j, j);
            }
        }

        if(map.containsKey(0)) return map.get(0);
        else return 0;
    }
    
    public int tallestBillboard(int[] rods) {
        HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[10001];
        Arrays.fill(arr, Integer.MIN_VALUE);

        for(int i : rods){
            HashMap<Integer, Integer> aux = new HashMap<>();

            ArrayList<Integer> l = new ArrayList<>();
            l.add(i);
            l.add(-i);

            for(int key : set){
                for(int j : l){
                    int sum = key + j;
                    int max = 0;
                    if(j > 0) max = arr[key+5000] + j;
                    else max = arr[key+5000];
                    
                    if(aux.containsKey(sum)) aux.put(sum, Math.max(aux.get(sum), max));
                    else aux.put(sum, max);
                }
            }

            for(int key : aux.keySet()){
                set.add(key);
                arr[key+5000] = Math.max(arr[key+5000], aux.get(key));
            }

            for(int j : l){
                arr[j+5000] = Math.max(arr[j+5000], j);
                set.add(j);
            }
        }

        if(arr[5000] != Integer.MIN_VALUE) return arr[5000];
        else return 0;
    }
    

    public static void main(String[] args) {
        int[] rods = {1,2,4,8,16,32,64,128,256,512,50,50,50,150,150,150,100,100,100,123};
        TallestBillboard test = new TallestBillboard();
        System.out.println(test.tallestBillboard(rods));
    }

}
