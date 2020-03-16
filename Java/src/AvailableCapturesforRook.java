
public class AvailableCapturesforRook {
	
	public int numRookCaptures(char[][] board) {
		
        for(int i = 0; i < 8; i++) {
        	for(int j = 0; j < 8; j++) {
        		if(board[i][j] == 'R') {
        			int res = 0;
        			int m = i;
        			int n = j;
        			
        			m = i-1;
        			while(m >= 0) {
        				if(board[m][n] == '.') m--;
        				else{
        					if(board[m][n] == 'p') res++;
        					break;
        				}
        			}
        			
        			m = i+1;
        			while(m < 8) {
        				if(board[m][n] == '.') m++;
        				else{
        					if(board[m][n] == 'p') res++;
        					break;
        				}
        			}
        			
        			m = i;
        			n = j-1;
        			while(n >= 0) {
        				if(board[m][n] == '.') n--;
        				else{
        					if(board[m][n] == 'p') res++;
        					break;
        				}
        			}
        			
        			n = j+1;
        			while(n < 8) {
        				if(board[m][n] == '.') n++;
        				else{
        					if(board[m][n] == 'p') res++;
        					break;
        				}
        			}
        			
        			return res;
        		}
        	}
        }
        
        return -1;
    }
	
}
