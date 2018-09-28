import java.util.Arrays;

public class AssignCookies {
    
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i = 0;
        int j = 0;
        
        int res = 0;
        
        while(i < g.length && j < s.length) {
            if(s[j] >= g[i]) {
                j++;
                i++;
                res++;
            }else {
                j++;
            }
        }
        
        return res;
    }
}
