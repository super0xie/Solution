public class SudokuSolver{


    public void solveSudoku(char[][] board) {
        int[][] b = new int[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                b[i][j] = board[i][j] == '.' ? 0 : board[i][j] - '0';
            }
        }

        boolean cont = true;
        while(cont){
            cont = false;
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    if(b[i][j] != 0) continue;
                    boolean[] cand = new boolean[10];
                    getCand(b, i, j, cand);
                    int ans = 0;
                    int count = 0;
                    for(int k = 1; k <= 9; k++){
                        if(!cand[k]) {
                            ans = k;
                            count++;
                            if(count > 1) break;
                        }
                    }
                    if(count == 1){
                        b[i][j] = ans;
                        cont = true;
                    }
                }
            }
        }


        dfs(b, 0, 0);

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                board[i][j] = (char)('0' + b[i][j]); 
            }
        }
    }

    private boolean dfs(int[][] b, int i, int j){
        
        if(i == 1 && j == 2) {
            System.out.println("break");
        }
        
        if(b[i][j] == 0){
            boolean[] cand = new boolean[10];
            int ni;
            int nj;
            if(j < 8){
                ni = i;
                nj = j+1;
            }else{
                ni = i+1;
                nj = 0;
            }

            getCand(b, i, j, cand);

            for(int k = 1; k <= 9; k++){
                if(!cand[k]){
                    b[i][j] = k;
                    if(i == 8 && j == 8) return true;
                    else if(dfs(b, ni, nj)) return true;
                }
            }

            b[i][j] = 0;
            return false;
        }else{
            if(i == 8 && j == 8) return true;
            int ni;
            int nj;
            if(j < 8){
                ni = i;
                nj = j+1;
            }else{
                ni = i+1;
                nj = 0;
            }
            return dfs(b, ni, nj);
        }
    }

    void getCand(int[][] b, int r, int c, boolean[] cand){
        
        for(int j = 0; j < 9; j++){
            if(b[r][j] != 0) cand[b[r][j]] = true;
        }

        for(int i = 0; i < 9; i++){
            if(b[i][c] != 0) cand[b[i][c]] = true;
        }

        int is = r / 3 * 3;
        int js = c / 3 * 3;
        int iend = is+3;
        int jend = js+3;

        for(int i = is; i < iend; i++){
            for(int j = js; j < jend; j++){
                if(b[i][j] != 0) cand[b[i][j]] = true;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
        SudokuSolver test = new SudokuSolver();
        test.solveSudoku(board);
        System.out.println("");
        System.out.println("");
        System.out.println("");

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(board[i][j] + ", ");
            }
            System.out.println("");
        }
    }

}