
public class CandyCrush {
    
    private int m,n;
    int[][] adj = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    public int[][] candyCrushv1(int[][] board) {
        m = board.length;
        n = board[0].length;
        while(true) {
            boolean needCrush = false;
            boolean[][] visited = new boolean[m][n];
            
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(board[i][j] == 0) continue;
                    int c = count(board, i, j, board[i][j], visited);
                    if(c >= 3) {
                        needCrush = true;
                        replace(board, i, j, board[i][j]);
                    }
                }
            }
            
            if(!needCrush) break;
            
            for(int j = 0; j < n; j++) {
                int i = m-1;
                while(i >= 0) {
                    if(board[i][j] != 0) i--;
                    else {
                        int k = i;
                        while(k >= 0 && board[k][j] == 0) k--;
                        if(k >= 0) {
                            int temp = board[i][j];
                            board[i][j] = board[k][j];
                            board[k][j] = temp;
                            i--;
                        }else {
                            break;
                        }
                    }
                }
            }   
        }
        
        return board;
    }
    
    public int[][] candyCrush(int[][] board) {
        m = board.length;
        n = board[0].length;
        while(true) {
            boolean needCrush = false;
            boolean[][] update = new boolean[m][n];
            
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(board[i][j] == 0) continue;
                    int k = j;
                    while(k < n && board[i][k] == board[i][j]) k++;
                    int count = k - j;
                    if(count >= 3) {
                        needCrush = true;
                        for(int l = j; l < k; l++) {
                            update[i][l] = true;
                        }
                    }
                    j = k-1;
                }
            }
            
            for(int j = 0; j < n; j++) {
                for(int i = 0; i < m; i++) {
                    if(board[i][j] == 0) continue;
                    int k = i;
                    while(k < m && board[k][j] == board[i][j]) k++;
                    int count = k - i;
                    if(count >= 3) {
                        needCrush = true;
                        for(int l = i; l < k; l++) {
                            update[l][j] = true;
                        }
                    }
                    i = k-1;
                }
            }
            
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(update[i][j]) board[i][j] = 0;
                }
            }
            
            if(!needCrush) break;
            
            for(int j = 0; j < n; j++) {
                int i = m-1;
                while(i >= 0) {
                    if(board[i][j] != 0) i--;
                    else {
                        int k = i;
                        while(k >= 0 && board[k][j] == 0) k--;
                        if(k >= 0) {
                            int temp = board[i][j];
                            board[i][j] = board[k][j];
                            board[k][j] = temp;
                            i--;
                        }else {
                            break;
                        }
                    }
                }
            }   
        }
        
        return board;
    }
    
    private int count(int[][] board, int i, int j, int target, boolean[][] visited) {
        if(i >= m || i < 0 || j >= n || j < 0) return 0;
        if(visited[i][j]) return 0;
        if(board[i][j] != target) return 0;
        
        visited[i][j] = true;
        int c = 1;
        for(int k = 0; k < 4; k++) {
            c += count(board, i+adj[k][0], j+adj[k][1], target, visited);
        }
        return c;
    }
    
    private void replace(int[][] board, int i, int j, int target) {
        if(i >= m || i < 0 || j >= n || j < 0) return;
        if(board[i][j] != target) return;
        board[i][j] = 0;
        for(int k = 0; k < 4; k++) {
            replace(board, i+adj[k][0], j+adj[k][1], target);
        }
    }
    
    public static void main(String[] args) {
        CandyCrush test = new CandyCrush();
        int[][] board = {{110,5,112,113,114},{210,211,5,213,214},{310,311,3,313,314},{410,411,412,5,414},{5,1,512,3,3},{610,4,1,613,614},{710,1,2,713,714},{810,1,2,1,1},{1,1,2,2,2},{4,1,4,4,1014}};
        test.candyCrush(board);
    }
    
}
