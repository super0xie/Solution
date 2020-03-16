import java.util.ArrayList;

public class SplitConcatenatedStrings {
    
    public String splitLoopedString(String[] strs) {
        char max = 'a';
        for(int i = 0; i < strs.length; i++) {
            String rev = rev(strs[i]);
            if(rev.compareTo(strs[i]) > 0) strs[i] = rev; 
            for(int j = 0; j < strs[i].length(); j++) {
                max = (char) Math.max(max, strs[i].charAt(j));
            }
        }
        
        
        String res = null;
        for(int i = 0; i < strs.length; i++) {
            ArrayList<Integer> l = new ArrayList<>();
            for(int j = 0; j < strs[i].length(); j++) {
                if(strs[i].charAt(j) == max) l.add(j);
            }
            
            if(l.size() > 0) {
                for(int s : l) {
                    String head = strs[i].substring(s);
                    if(res == null || head.compareTo(res.substring(0, head.length())) >= 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(head);
                        
                        for(int j = 0; j < strs.length-1; j++) {
                            int idx = (i+j+1)%strs.length;
                            sb.append(strs[idx]);
                        }
                        sb.append(strs[i].substring(0, s));
                        String str = sb.toString();
                        if(res == null || str.compareTo(res) > 0) res = str;
                    }
                }
                
                String rev = rev(strs[i]);
                for(int s : l) {
                    s = strs[i].length()-1-s;
                    String head = rev.substring(s);
                    if(head.compareTo(res.substring(0, head.length())) >= 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(head);
                        for(int j = 0; j < strs.length-1; j++) {
                            int idx = (i+j+1)%strs.length;
                            sb.append(strs[idx]);
                        }
                        sb.append(rev.substring(0, s));
                        String str = sb.toString();
                        if(res == null || str.compareTo(res) > 0) res = str;
                    }
                }
                
            }
            
        }
        
        return res;
    }
    
    private String rev(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        String[] strs = {"abc", "xyz"};
        SplitConcatenatedStrings test = new SplitConcatenatedStrings();
        System.out.println(test.splitLoopedString(strs));
    }
    
}
