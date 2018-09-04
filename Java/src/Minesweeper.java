
public class Minesweeper {
    
    private char[][] board;
    private int row;
    private int col;
    
    public char[][] updateBoard(char[][] board, int[] click) {
        this.board = board;
        this.row = board.length;
        this.col = board[0].length;
        
        int i = click[0];
        int j = click[1];
        if(board[i][j] == 'M') {
            board[i][j] = 'X';
        }else {
            dfs(i, j);
        }
        
        
        
        return board;
    }
    
    
    private void dfs(int i, int j) {
        if(board[i][j] != 'E') return;
        int count = 0;
        for(int r = i-1; r <= i+1; r++) {
            for(int c = j-1; c <= j+1; c++) {
                if(r < 0 || r >= row || c < 0 || c >= col) continue;
                if(r == i && c == j) continue;
                
                if(board[r][c] == 'M') count++;
                
            }
        }
        
        if(count > 0) {
            board[i][j] = (char) ('0' + count);
        }else {
            board[i][j] = 'B';
            for(int r = i-1; r <= i+1; r++) {
                for(int c = j-1; c <= j+1; c++) {
                    if(r < 0 || r >= row || c < 0 || c >= col) continue;
                    if(r == i && c == j) continue;
                    
                    dfs(r, c);
                    
                }
            }
        }
    }

}
