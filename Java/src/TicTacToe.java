
public class TicTacToe {
    
    private int[] rows;
    private int[] cols;
    private int ld;
    private int rd;
    private int n;
    public TicTacToe(int n) {
        this.n = n;
        ld = 0;
        rd = 0;
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int flag = 0;
        if(player == 1) flag = 1;
        else flag = -1;
        
        rows[row] += flag;
        cols[col] += flag;
        if(row == col) rd += flag;
        if(row + col == n - 1) ld += flag;
        
        if(Math.abs(rows[row]) == n 
                || Math.abs(cols[col]) == n
                || Math.abs(ld) == n
                || Math.abs(rd) == n) {
            return player;
        }else {
            return 0;
        }
    }
}
