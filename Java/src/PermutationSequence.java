import java.util.ArrayList;

public class PermutationSequence {
    
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> l = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            l.add(i);
        }
        int num = n-1;
        int fac = 1;
        for(int i = 2; i < n; i++) {
            fac = fac * i;
        }
        while(l.size() > 0) {
            int idx = (k-1)/fac;
            k = k - idx * fac;
            if(num > 0)
                fac = fac / num;
            num--;
            sb.append(l.get(idx));
            l.remove(idx);
        }
        return sb.toString();
    }
    
    
    
    public static void main(String[] args) {
        PermutationSequence test = new PermutationSequence();
//        StringBuilder sb = new StringBuilder();
        System.out.println(test.getPermutation(4, 9));
    }
}
