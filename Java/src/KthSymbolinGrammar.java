
public class KthSymbolinGrammar {
    
    
    public int kthGrammar(int N, int K) {
        if(N <= 2) {
            if(N == 1) return 0;
            if(K == 1) return 0;
            if(K == 2) return 1;
        }
        
        int len = 2 << N-2;
        if(K <= len / 2) return kthGrammar(N-1, K);
        if(K > len/2 && K <= len*3/4) return kthGrammar(N-1, K-len/4);
        else return kthGrammar(N-1, K-len*3/4);
    }
    
    
    
    public static void main(String[] args) {
        
        String str = "0";
        for(int i = 0; i < 30; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '0') sb.append("01");
                else sb.append("10");
            }
            
            str = sb.toString();
            System.out.println(str);
        }
        
//        KthSymbolinGrammar test = new KthSymbolinGrammar();
//        System.out.println(test.kthGrammar(5, 10));

    }

}
