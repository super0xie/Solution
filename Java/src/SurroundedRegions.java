import java.util.List;

public class SurroundedRegions {
	
	public void solve(char[][] board) {
		if(board == null || board.length == 0 || board[0].length == 0) return;
		
		for(int i = 0; i < board.length; i++) {
			dfs(board, i, 0, 'A');
			dfs(board, i, board[0].length - 1, 'A');
		}
		
		for(int j = 1; j < board[0].length -1; j++) {
			dfs(board, 0, j, 'A');
			dfs(board, board.length-1, j, 'A');
		}
		
		for(int i = 1; i < board.length -1; i++) {
			for(int j = 1; j < board[0].length -1; j++) {
				dfs(board, i, j, 'X');
			}
		}
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 'A') board[i][j] = 'O';
			}
		}
		
        
    }
	
	private void dfs(char[][] board, int i, int j, char replace){
		if(i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1) return;
		if(board[i][j] != 'O') return;
		
		board[i][j] = replace;
		dfs(board, i-1, j, replace);
		dfs(board, i+1, j, replace);
		dfs(board, i, j-1, replace);
		dfs(board, i, j+1, replace);

	}
	
	public static void main(String[] args) {
		SurroundedRegions test = new SurroundedRegions();
		char [][] board = {
				{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
				{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}};
		
		
		test.solve(board);
		
		System.out.println("ok");
	}
	
	

}
