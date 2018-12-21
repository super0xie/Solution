
public class NumberofSegmentsinaString {
    
    public int countSegments(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                res++;
                int j = i;
                while(j < s.length() && s.charAt(j) != ' ') j++;
                i = j-1;
            }
        }
        return res;
    }
    
}
