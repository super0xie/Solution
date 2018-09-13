import java.util.Stack;

public class DecodeString {
    
    public String decodeString(String s) {
        String res = "";
        
        
        int repeat = 0;
        int count = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if(count == 0) {
                    int j = i;
                    while(j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') j++;
                    repeat = Integer.parseInt(s.substring(i, j));
                    i = j-1;
                }
                
            }else if(s.charAt(i) == '[') {
                if(count == 0)
                    start = i+1;
                count++;
            }else if(s.charAt(i) == ']') {
                count--;
                if(count == 0) {
                    String sub = s.substring(start, i);
                    String decodedSub = decodeString(sub);
                    for(int j = 0; j < repeat; j++) {
                        res = res + decodedSub;
                    }
                }
            }else {
                if(count == 0) {
                    res = res + s.charAt(i);
                }
            }
        }
        
        return res;
        
    }
    
    public static void main(String[] args) {
        DecodeString test = new DecodeString();
        System.out.println(test.decodeString("10[leetcode]"));
    }

}
