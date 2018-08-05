
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if(board == null || board.length == 0 || board[0].length == 0)
			return false;
		
		boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		if(DFS(i, j, board, word, 0, visited)) return true;
        	}
        }
        
        return false;
    }
	
	private boolean DFS(int i, int j, char[][] board, String word, int index, boolean[][] visited) {
		if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length -1) return false;
		if(visited[i][j]) return false;
		if(board[i][j] != word.charAt(index)) return false;
		else if(index == word.length() - 1) return true;
		
		visited[i][j] = true;
		
		boolean result = DFS(i-1, j, board, word, index+1, visited)
				|| DFS(i+1, j, board, word, index+1, visited)
				|| DFS(i, j-1, board, word, index+1, visited)
				|| DFS(i, j+1, board, word, index+1, visited);
		
		visited[i][j] = false;
		
		return result;
	}
	
	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		char [][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		System.out.println(ws.exist(board, "ABCCED"));
		System.out.println(ws.exist(board, "SEE"));
		System.out.println(ws.exist(board, "ABCB"));
	}

}
