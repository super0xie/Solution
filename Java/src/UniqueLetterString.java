import java.util.ArrayList;

public class UniqueLetterString {

    public int uniqueLetterString(String S) {
        int mod = 1000000000 + 7;
        int res = 0;

        ArrayList<Integer> [] indice = new ArrayList[26];
        int[] cur = new int[26];
        for(int i = 0; i < S.length(); i++){
            if(indice[S.charAt(i)-'A'] == null) indice[S.charAt(i)-'A'] = new ArrayList<Integer>();
            indice[S.charAt(i)-'A'].add(i);
        }

        for(int i = 0; i < S.length(); i++){
            int last = 0;
            int next = 0;
            int idx = cur[S.charAt(i)-'A']++;
            if(idx == 0) last = -1;
            else last = indice[S.charAt(i)-'A'].get(idx-1);

            if(idx == indice[S.charAt(i)-'A'].size()-1) next = S.length();
            else next = indice[S.charAt(i)-'A'].get(idx+1);

            res += (i - last) * (next - i);
            res = res % mod;
        }

        return res;
    }

    public static void main(String[] args) {
        UniqueLetterString test = new UniqueLetterString();
        System.out.println(test.uniqueLetterString("ABC"));
    }

}