
public class MonotoneIncreasingDigits {
    
    public int monotoneIncreasingDigits(int N) {
        String str = String.valueOf(N);
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) < str.charAt(i-1)) {
                i--;
                while(i > 0 && str.charAt(i) == str.charAt(i-1)) i--;
                
                for(int j = 0; j < i; j++) {
                    sb.append(str.charAt(j));
                }
                if(!(i == 0 && str.charAt(i)=='1')) sb.append((char)(str.charAt(i)-1));
                for(int j = i+1; j < str.length(); j++) {
                    sb.append('9');
                }
                return Integer.parseInt(sb.toString());
            }
        }
        return N;
        
    }
    
    public static void main(String[] arsg) {
        MonotoneIncreasingDigits test = new MonotoneIncreasingDigits();
        System.out.println(test.monotoneIncreasingDigits(332));
    }

}
