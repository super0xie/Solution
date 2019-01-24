
public class AndroidUnlockPatterns {
    
    private int[][] jump;
    
    public int numberOfPatterns(int m, int n) {
        int res = 0;
        jump = new int [10][10];
        jump[1][3] = 2;
        jump[1][7] = 4;
        jump[1][9] = 5;
        jump[2][8] = 5;
        jump[3][1] = 2;
        jump[3][7] = 5;
        jump[3][9] = 6;
        jump[4][6] = 5;
        jump[6][4] = 5;
        jump[7][1] = 4;
        jump[7][3] = 5;
        jump[7][9] = 8;
        jump[8][2] = 5;
        jump[9][1] = 5;
        jump[9][3] = 6;
        jump[9][7] = 8;
        
        boolean[] visited = new boolean[10];        
        int[] c;
        for(int i = m; i <= n; i++) {
            c = new int [1];
            dfs(visited, 1, i, c);
            res += 4 * c[0];
            
            c = new int [1];
            dfs(visited, 2, i, c);
            res += 4 * c[0];
            
            c = new int [1];
            dfs(visited, 5, i, c);
            res += c[0];
        }
        
        return res;
    }
    
    private void dfs(boolean[] visited, int cur, int left, int[] count) {
        if(left == 1) count[0]++;
        visited[cur] = true;
        
        for(int i = 1; i <= 9; i++) {
            if(visited[i]) continue;
            if(jump[cur][i] != 0 && !visited[jump[cur][i]]) continue;
            dfs(visited, i, left-1, count);
        }
        
        visited[cur] = false;
    }
    
    
    public static void main(String[] args) {
        AndroidUnlockPatterns test = new AndroidUnlockPatterns();
        
        System.out.println(test.numberOfPatterns(1, 9));
    }
    
    
}
