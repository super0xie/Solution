public class StrobogrammaticNumberIII {
    
    private int res = 0;
    
    public int strobogrammaticInRange(String low, String high) {
        char[][] pairs = new char [][] {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
        int ret = 0;
        long l = Long.parseLong(low);
        long h = Long.parseLong(high);
        for(int i = low.length(); i <= high.length(); i++) {
            res = 0;
            dfs(0, "", "", i, pairs, l, h);
            ret += res;
        }
        return ret;
    }
    
    
    private void dfs(int ind, String l, String r, int n, char[][] pairs, long low, long high) {
        if(n % 2 == 1 && ind == n/2) {
            long aux = Long.parseLong(l+"0"+r);
            if (aux >= low && aux <= high) res++;
            aux = Long.parseLong(l+"1"+r);
            if (aux >= low && aux <= high) res++;
            aux = Long.parseLong(l+"8"+r);
            if (aux >= low && aux <= high) res++;
            return;
        }
        
        int start = 0;
        if(ind == 0) start = 1;
        
        for(int i = start; i < pairs.length; i++) {
            if(ind == (n-1) / 2) {
                String str = l+pairs[i][0] + pairs[i][1] + r;
                long aux = Long.parseLong(str);
                if (aux >= low && aux <= high) res++;
            }
            else
                dfs(ind+1, l+pairs[i][0], pairs[i][1] + r, n, pairs, low, high);
        }
    }
    
    public static void main(String[] args) {
        StrobogrammaticNumberIII test = new StrobogrammaticNumberIII();
        System.out.println(test.strobogrammaticInRange("50", "100"));
//        System.out.println("50".compareTo("100"));
        
    }
}
