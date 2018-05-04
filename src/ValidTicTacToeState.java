
public class ValidTicTacToeState {
	
	public boolean validTicTacToe(String[] board) {
		if(board.length != 3) return false;
		
		char [][] matrix = new char[3][3];
		
		int countX = 0;
		int countO = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[i].charAt(j) == 'X') countX++;
				if(board[i].charAt(j) == 'O') countO++;
				
				matrix[i][j] = board[i].charAt(j);
			}
		}
		
		if(!(countX == countO || countX == countO+1))
			return false;
		
		for(int i = 0; i < 3; i++) {
			if(matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2] && matrix[i][0] != ' ') {
				if(matrix[i][0] == 'X' && countX != countO+1) return false;
				if(matrix[i][0] == 'O' && countX != countO) return false;
			}
		}
		
		for(int i = 0; i < 3; i++) {
			if(matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i] && matrix[0][i] != ' ') {
				if(matrix[0][i] == 'X' && countX != countO+1) return false;
				if(matrix[0][i] == 'O' && countX != countO) return false;
			}
		}
		
		
		if((matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2])
				|| (matrix[0][2] == matrix[1][1] && matrix[2][0] == matrix[1][1])) {
			if(matrix[1][1] == 'X' && countX != countO+1) return false;
			if(matrix[1][1] == 'O' && countX != countO) return false;
		}
		
		return true;

    }
	
	public static void main(String[] args) {
		ValidTicTacToeState test = new ValidTicTacToeState();
		String[] board1 = {"O  ", "   ", "   "};
		System.out.println(test.validTicTacToe(board1));
		
		String[] board2 = {"XOX", " X ", "   "};
		System.out.println(test.validTicTacToe(board2));
		
		String[] board3 = {"XXX", "   ", "OOO"};
		System.out.println(test.validTicTacToe(board3));
		
		String[] board4 = {"XOX", "O O", "XOX"};
		System.out.println(test.validTicTacToe(board4));
		
		String[] board5 = {"XXX","OOX","OOX"};
		System.out.println(test.validTicTacToe(board5));
		
	}

}
