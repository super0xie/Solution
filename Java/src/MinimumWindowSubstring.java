import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstring {

    public String minWindowOld(String s, String t) {
        int[] count = new int[26];
        for(int i = 0; i < t.length(); i++){
            count[t.charAt(i)-'A']++;
        }

        int i = 0;
        int j = 0;
        int[] scount = new int[26];
        scount[s.charAt(0)-'A']++;

        int min = Integer.MAX_VALUE;
        String res = null;
        while(j < s.length()){
            int k = 0;
            for(; k < 26; k++){
                if(count[k] > 0 && scount[k] == 0) break;
            }
            if(k == 26){
                if(j-i+1 < min){
                    min = j-i+1;
                    res = s.substring(i, j+1);
                }
                scount[s.charAt(i)-'A']--;
                i++;
            }else{
                j++;
                if(j < s.length()) scount[s.charAt(j)-'A']++;
            }
        }

        return res;
    }


    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }

        int i = 0;
        int j = -1;
        HashMap<Character, Integer> count = new HashMap<>();

        int min = Integer.MAX_VALUE;
        String res = "";
        while(j < s.length()){
            boolean contain = true;
            for(Character c : map.keySet()){
                if(!count.containsKey(c) || count.get(c) < map.get(c)){
                    contain = false;
                    break;
                }
            }
            if(contain){
                if(j-i+1 < min){
                    min = j-i+1;
                    res = s.substring(i, j+1);
                }
                int n = count.get(s.charAt(i));
                if(n == 1) count.remove(s.charAt(i));
                else count.put(s.charAt(i), n-1);
                
                i++;
            }else{
                j++;
                if(j < s.length()) {
                    count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0)+1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        System.out.println(test.minWindow("a", "aa"));
    }

}