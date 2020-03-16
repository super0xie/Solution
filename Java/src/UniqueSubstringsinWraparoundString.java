import java.util.HashSet;

public class UniqueSubstringsinWraparoundString {

    public int findSubstringInWraproundStringOld(String p) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < p.length(); i++){
            int j = i;
            while(j < p.length()-1){
                if((char)((p.charAt(j)-'a'+1)%26+'a') == p.charAt(j+1)) j++;
                else break;
            }

            for(int k = i; k <= Math.min(j, i+25); k++){
                for(int l = k; l <= j; l++){
                    set.add(encode(p.charAt(k), l-k+1));
                }
            }

            i = j;
        }

        return set.size();
    }

    private int encode(char c, int len){
        return len * 30 + (c-'a');
    }

    public int findSubstringInWraproundString(String p) {
        int[] len = new int[26];
        for(int i = 0; i < p.length(); i++){
            int j = i;
            while(j < p.length()-1){
                if((char)((p.charAt(j)-'a'+1)%26+'a') == p.charAt(j+1)) j++;
                else break;
            }

            for(int k = i; k <= Math.min(j, i+25); k++){
                len[p.charAt(k)-'a'] = Math.max(len[p.charAt(k)-'a'], j-k+1);
            }
            i = j;
        }

        int res = 0;
        for(int i : len){
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        UniqueSubstringsinWraparoundString test = new UniqueSubstringsinWraparoundString();
        System.out.println(test.findSubstringInWraproundString("zab"));

    }

}