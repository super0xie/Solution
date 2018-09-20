
public class DecodeWays {
    
    
    public int numDecodings(String s) {
        int[] mem = new int[s.length()];
        return dfs(s, 0, mem);
    }
    
    private int dfs(String s, int idx, int[] mem) {
        if(idx >= s.length()) return 1;
        if(mem[idx] > 0) return mem[idx];
        int res = 0;
        
        if(s.charAt(idx) != '0') {
            if(idx < s.length()-1 && Integer.parseInt(s.substring(idx, idx+2)) <= 26) {
                res = dfs(s, idx+1, mem) + dfs(s, idx+2, mem);
            }else {
                res = dfs(s, idx+1, mem);
            }
        }else {
            res = 0;
        }
        
        mem[idx] = res;
        return res;
    }
    
    public static void main(String[] args) {
        DecodeWays test = new DecodeWays();
        System.out.println(test.numDecodings("01"));
    }

}
