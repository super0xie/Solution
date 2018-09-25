
public class ValidSudoku {
    
    public boolean isValidSudoku(char[][] board) {
        //row
        for(int i = 0; i < board.length; i++) {
            boolean [] row = new boolean [9];
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.') {
                    if(row[board[i][j]-'1']) return false;
                    row[board[i][j]-'1'] = true;
                }
            }
        }
        
        //col
        for(int j = 0; j < board[0].length; j++) {
            boolean[] col = new boolean [9];
            for(int i = 0; i < board.length; i++) {
                if(board[i][j] != '.') {
                    if(col[board[i][j] - '1']) return false;
                    col[board[i][j]-'1'] = true;
                }
            }
        }
        
        //box
        for(int i = 0; i < board.length; i=i+3) {
            for(int j = 0; j < board[0].length; j=j+3) {
                boolean[] box = new boolean[9];
                for(int r = i; r < i+3; r++) {
                    for(int c = j; c < j+3; c++) {
                        if(board[r][c] != '.') {
                            if(box[board[r][c] - '1']) return false;
                            box[board[r][c]-'1'] = true;
                        }
                    }
                }
            }
        }
        
        return true;
        
    }
    
}
