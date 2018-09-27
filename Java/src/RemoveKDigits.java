
public class RemoveKDigits {
    
    public String removeKdigits(String num, int k) {
        String res = num;
        
        while(k > 0) {
            int i = 0;
            for(; i < res.length()-1; i++) {
                if(res.charAt(i) > res.charAt(i+1)) break;
            }
            
            if(i == res.length()-1) res = res.substring(0, res.length()-1);
            else {
                if(res.charAt(i) > res.charAt(i+1)) {
                    res = res.substring(0, i) + res.substring(i+1, res.length());
                }
            }
            k--;
        }
        int i = 0;
        while(i < res.length() && res.charAt(i) == '0') i++;
        res = res.substring(i, res.length());
        
        if(res.length() == 0) return "0";
        return res;
    }
    
    public static void main(String[] args) {
        RemoveKDigits test = new RemoveKDigits();
        System.out.println(test.removeKdigits("10", 2));
    }
    
}
