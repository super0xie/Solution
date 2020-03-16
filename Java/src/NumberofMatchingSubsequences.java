import java.util.ArrayList;
import java.util.TreeSet;

public class NumberofMatchingSubsequences {
    
    
    
    
    public int numMatchingSubseqSlow(String S, String[] words) {
        int res = 0;
        TreeSet<Integer>[] arr = new TreeSet[26];
        
        for(int i = 0; i < S.length(); i++) {
            if(arr[S.charAt(i)-'a'] == null) arr[S.charAt(i)-'a'] = new TreeSet<Integer>();
            arr[S.charAt(i)-'a'].add(i);
        }
        
        for(String str : words) {
            int s = 0;
            int i = 0;
            for(; i < str.length(); i++) {
                if(arr[str.charAt(i)-'a'] == null) break;
                Integer ceil = arr[str.charAt(i)-'a'].ceiling(s);
                if(ceil == null) break;
                s = ceil+1;
            }
            if(i == str.length()) res++;
        }
        
        return res;
    }
    
    class IdxStr{
        String str;
        int idx;
        
        IdxStr(String str){
            this.str = str;
            idx = 0;
        }
    }
    
    public int numMatchingSubseq(String S, String[] words) {
        int res = 0;
        ArrayList<IdxStr>[] arr = new ArrayList[26];
        
        for(int i = 0; i < 26; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for(String str : words) {
            if(arr[str.charAt(0)-'a'] == null) arr[str.charAt(0)-'a'] = new ArrayList<>();
            arr[str.charAt(0)-'a'].add(new IdxStr(str));
        }
        
        for(int i = 0; i < S.length(); i++) {
            ArrayList<IdxStr> l = arr[S.charAt(i)-'a'];
            arr[S.charAt(i)-'a'] = new ArrayList<>();
            for(IdxStr str : l) {
                str.idx++;
                if(str.idx == str.str.length()) res++;
                else {
                    if(arr[str.str.charAt(str.idx)-'a'] == null) arr[str.str.charAt(str.idx)-'a'] = new ArrayList<>();
                    arr[str.str.charAt(str.idx)-'a'].add(str);
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        NumberofMatchingSubsequences test = new NumberofMatchingSubsequences();
        String[] words = {"a", "bb", "acd", "ace"};
        String S = "abcde";
        System.out.println(test.numMatchingSubseq(S, words));
        
    }
    
}
