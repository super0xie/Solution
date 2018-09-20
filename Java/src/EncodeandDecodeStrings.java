import java.util.ArrayList;
import java.util.List;

public class EncodeandDecodeStrings {
 
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length() + "/");
            sb.append(str);
        }
        return sb.toString();
        
    }

    public List<String> decode(String s) {
        int i = 0;
        List<String> res = new ArrayList<String>();
        while(i < s.length()) {
            int start = i;
            while(i < s.length() && s.charAt(i) <= '9' && s.charAt(i) >= '0') i++;
            int length = Integer.parseInt(s.substring(start, i));
            res.add(s.substring(i+1, i+1+length));
            i = i+1+length;
        }
        return res;
        
    }
    
    public static void main(String[] args) {
        EncodeandDecodeStrings test = new EncodeandDecodeStrings();
        ArrayList<String> strs = new ArrayList<String>();
        strs.add("123");
        strs.add("world");
//        System.out.println(test.encode(strs));
        List<String> res = test.decode(test.encode(strs));
        System.out.println("hello");
    }
}
