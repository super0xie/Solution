
public class FindWinneronaTicTacToeGame {
	
	public String tictactoe(int[][] moves) {
        int[] grid = new int[9];
        for(int i = 0; i < moves.length; i++) {
        	int idx = 3 * moves[i][0] + moves[i][1];
        	grid[idx] = i%2 + 1;
        }
        
        for(int i = 0; i < 9; i += 3) {
        	if(grid[i] != 0 && grid[i] == grid[i+1] && grid[i] == grid[i+2]) {
            	if(grid[i] == 1) return "A";
            	else return "B";
            }
        }
        
        for(int i = 0; i < 3; i++) {
        	if(grid[i] != 0 && grid[i] == grid[i+3] && grid[i] == grid[i+6]) {
        		if(grid[i] == 1) return "A";
            	else return "B";
        	}
        }
        
        if(grid[0] != 0 && grid[0] == grid[4] && grid[0] == grid[8]) {
        	if(grid[0] == 1) return "A";
        	else return "B";
        }
        
        if(grid[2] != 0 && grid[2] == grid[4] && grid[2] == grid[6]) {
        	if(grid[2] == 1) return "A";
        	else return "B";
        }
        
        if(moves.length == 9) return "Draw";
        else return "Pending";
        
    }
	
	public static void main(String[] args) {
		FindWinneronaTicTacToeGame test = new FindWinneronaTicTacToeGame();
		int[][] moves = {{0,0},{1,1}};
		System.out.println(test.tictactoe(moves));
	}
	
}
