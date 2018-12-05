import java.util.ArrayList;

public class DesignCompressedStringIterator {
    
    private ArrayList<Character> chars;
    private ArrayList<Integer> counts;
    private int idx;
    
    
    public void StringIterator(String str) {
        int i = 0;
        chars = new ArrayList<>();
        counts = new ArrayList<>();
        while(i < str.length()) {
            chars.add(str.charAt(i));
            int s = i+1;
            while(s < str.length() && str.charAt(s) <= '9' && str.charAt(s) >= '0') s++;
            int c = Integer.parseInt(str.substring(i+1, s));
            counts.add(c);
            i = s;
        }
    }
    
    public char next() {
        if(hasNext()) {
            char ret;
            if(counts.get(idx) == 0) idx++;
            ret = chars.get(idx);
            counts.set(idx, counts.get(idx)-1);
            return ret;
        }else {
            return ' ';
        }
    }
    
    public boolean hasNext() {
        if(idx != chars.size()-1) return true;
        else {
            return counts.get(idx) > 0;
        }
    }
}
