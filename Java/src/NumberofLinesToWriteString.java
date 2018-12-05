
public class NumberofLinesToWriteString {
    
    public int[] numberOfLines(int[] widths, String S) {
        int c = 1;
        int idx = 1;
        for(int i = 0; i < S.length(); i++) {
            int w = widths[S.charAt(i)-'a'];
            if(idx + w <= 101) idx += w;
            else {
                c++;
                idx = 1 + w;
            }
        }
        return new int[] {c, idx-1};
    }
    
}
