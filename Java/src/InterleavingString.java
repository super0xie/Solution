import java.util.ArrayList;
import java.util.HashSet;

public class InterleavingString {

    public boolean isInterleaveTLE(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        ArrayList<int[]> l = new ArrayList<>();
        l.add(new int[]{0, 0});

        for(int i = 0; i < s3.length(); i++){
            ArrayList<int[]> aux = new ArrayList<>();
            for(int[] a : l){
                if(a[0] < s1.length() && s1.charAt(a[0]) == s3.charAt(i)) aux.add(new int[]{a[0]+1, a[1]});
                if(a[1] < s2.length() && s2.charAt(a[1]) == s3.charAt(i)) aux.add(new int[]{a[0], a[1]+1});
            }

            if(aux.isEmpty()) return false;
            l = aux;
        }

        return true;
    }
    
    public boolean isInterleaveOld(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);

        for(int i = 0; i < s3.length(); i++){
            HashSet<Integer> aux = new HashSet<>();
            for(int a : set){
                int i1 = a / 10000;
                int i2 = a % 10000; 
                if(i1 < s1.length() && s1.charAt(i1) == s3.charAt(i)) aux.add((i1+1) * 10000 + i2);
                if(i2 < s2.length() && s2.charAt(i2) == s3.charAt(i)) aux.add(i1*10000 + i2+1);
            }

            if(aux.isEmpty()) return false;
            set = aux;
        }

        return true;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;

        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++){
                if(i > 0 && dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) dp[i][j] = true;
                if(j > 0 && dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) dp[i][j] = true;
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        InterleavingString test = new InterleavingString();
        System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        
    }

}