import java.util.Arrays;
import java.util.HashSet;

public class LongestUncommonSubsequenceII{

    public int findLUSlengthOld(String[] strs) {
        HashSet<String> visited = new HashSet<>();
        HashSet<String> dup = new HashSet<>();
        for(String str : strs){
            if(visited.contains(str)){
                dup.add(str);
            }else{
                visited.add(str);
            }
        }

        String[] aux = new String[visited.size()];
        int idx = 0;
        for(String str : visited){
            aux[idx++] = str;
        }

        Arrays.sort(aux, (a, b)->{
            return b.length()-a.length();
        });


        for(int i = 0; i < aux.length; i++){
            if(dup.contains(aux[i])) continue;
            else{
                int j = 0;
                for(; j < i; j++){
                    if(isSubsequence(aux[i], aux[j])) break;
                }
                if(j == i) return aux[i].length();
            }
        }

        return -1;
    }

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b)->{
            return b.length()-a.length();
        });

        for(int i = 0; i < strs.length; i++){
            int j = 0;
            for(; j < strs.length; j++){
                if(j == i) continue;
                if(strs[i].length() > strs[j].length()) {
                    j = strs.length;
                    break;
                }
                if(isSubsequence(strs[i], strs[j])) break;
            }
            if(j == strs.length) return strs[i].length();
        }
        return -1;

    }

    private boolean isSubsequence(String s, String t) {
        int i = 0;
        for(int j = 0; j < t.length(); j++){
            if(i < s.length() && s.charAt(i) == t.charAt(j)) i++;
        }
        if(i == s.length()) return true;
        else return false;
    }

    public static void main(String[] args) {
        LongestUncommonSubsequenceII test = new LongestUncommonSubsequenceII();
        String[] strs = {"aabbcc", "aabbcc","c","e","aabbcd"};
        System.out.print(test.findLUSlength(strs));
    }

}