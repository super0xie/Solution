import java.util.ArrayList;
import java.util.List;

public class SplitArrayintoFibonacciSequence {
    
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        int end = 0;
        if(S.charAt(0) == '0') end = 1;
        else end = Math.min(S.length()-2, 10);

        for(int i = 1; i <= end; i++){
            long first = Long.parseLong(S.substring(0, i));
            if(first > Integer.MAX_VALUE) return res;
            int a = (int)first;

            int r = 0;
            if(S.charAt(i) == '0') r = i+1;
            else r = Math.min(S.length()-1, i + 10);
            for(int j = i+1; j <= r; j++){
                long second = Long.parseLong(S.substring(i, j));
                if(second > Integer.MAX_VALUE) break;
                int b = (int)second;
                if(helper(a, b, S, j)){
                    res.add(a);
                    res.add(b);
                    int len = j;
                    while(len < S.length()){
                        int sum = a + b;
                        res.add(sum);
                        a = b;
                        b = sum;
                        len += String.valueOf(sum).length();
                    }

                    return res;
                }
            }
        }
        return res;
    }

    private boolean helper(int a, int b, String s, int idx){
        if(idx == s.length()) return true;
        int sum = a + b;
        String str = String.valueOf(sum);
        if(s.length() < idx + str.length()) return false;
        
        for(int i = idx; i < idx + str.length(); i++){
            if(s.charAt(i) != str.charAt(i-idx)) return false;
        }
        return helper(b, sum, s, idx+str.length());
    }

    public static void main(String[] args) {
        String S = "1320581321313221264343965566089105744171833277577";
        SplitArrayintoFibonacciSequence test = new SplitArrayintoFibonacciSequence();
        for(int i : test.splitIntoFibonacci(S)) System.out.println(i);
    }
}