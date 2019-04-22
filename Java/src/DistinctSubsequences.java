import java.util.HashMap;
import java.util.TreeMap;

public class DistinctSubsequences {

    public int numDistinctOld(String s, String t) {
        HashMap<Character, TreeMap<Integer, Integer>> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            TreeMap<Integer, Integer> indice = map.getOrDefault(s.charAt(i), new TreeMap<>());
            if(s.charAt(i) == t.charAt(0)) {
                res++;
                indice.put(i, 1);
            }
            else indice.put(i, 0);
            map.put(s.charAt(i), indice);
        }

        for(int i = 1; i < t.length(); i++){
            TreeMap<Integer, Integer> aux = new TreeMap<>();
            if(!map.containsKey(t.charAt(i))) return 0;
            res = 0;
            TreeMap<Integer, Integer> prev = map.get(t.charAt(i-1));
            for(int j : map.get(t.charAt(i)).keySet()){
                int sum = 0;
                for(int k : prev.keySet()){
                    if(k >= j) break;
                    sum += prev.get(k);
                }
                aux.put(j, sum);
                res += sum;
            }
            if(res == 0) return 0;
            map.put(t.charAt(i), aux);
        }

        return res;
    }

    public int numDistinctHashMap(String s, String t) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == t.charAt(0)) {
                count.put(i, 1);
                res++;
            }
        }

        for(int i = 1; i < t.length(); i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            res = 0;
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == t.charAt(i)) {
                    map.put(j, sum);
                    res += sum;
                }
                if(s.charAt(j) == t.charAt(i-1)) sum += count.get(j);
            }
            count = map;
        }

        return res;
    }

    public int numDistinct(String s, String t) {
        int[] count = new int[s.length()];
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == t.charAt(0)) {
                count[i] = 1;
                res++;
            }
        }

        for(int i = 1; i < t.length(); i++){
            int[] aux = new int[s.length()];
            int sum = 0;
            res = 0;
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == t.charAt(i)) {
                    aux[j] = sum;
                    res += sum;
                }
                if(s.charAt(j) == t.charAt(i-1)) sum += count[j];
            }
            count = aux;
        }

        return res;
    }

    public static void main(String[] args) {
        DistinctSubsequences test = new DistinctSubsequences();
        System.out.println(test.numDistinct("babgbag", "bag"));
    }

}