public class ShortestPalindrome{

    public String shortestPalindrome(String s) {
        if(s.length() == 0) return s;
        
        int len = Integer.MAX_VALUE;
        int midIdx = 0;
        int mode = 0;

        for(int i = 0; i < s.length(); i++){
            boolean cont = false;
            int l = i-1;
            int r = i+1;
            int curLen = 2 * (s.length()-1-i) + 1;
            if(i - 0 <= s.length()-1-i && curLen < len){
                cont = true;
                while(l >= 0 && r < s.length()){
                    if(s.charAt(l) != s.charAt(r)) break;
                    l--;
                    r++;
                }

                if(l == -1){
                    mode = 1;
                    midIdx = i;
                    len = curLen;
                }
            }

            l = i;
            r = i+1;
            curLen = 2 * (s.length()-i-1);
            if(i - 0 <= s.length()-1-i-1 && curLen < len){
                cont = true;
                while(l >= 0 && r < s.length()){
                    if(s.charAt(l) != s.charAt(r)) break;
                    l--;
                    r++;
                }

                if(l == -1){
                    mode = 2;
                    midIdx = i;
                    len = curLen;
                }
            }

            if(!cont) break;
        }

        if(mode == 1){
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(midIdx+1, s.length()));
            String right = sb.toString();
            return sb.reverse().toString() + s.charAt(midIdx) + right;
        } else{
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(midIdx+1, s.length()));
            String right = sb.toString();
            return sb.reverse().toString() + right;
        }
    }

    public static void main(String[] args) {
        ShortestPalindrome test = new ShortestPalindrome();
        System.out.println(test.shortestPalindrome("aaaa"));
    }

}