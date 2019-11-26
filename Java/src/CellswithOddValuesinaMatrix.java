
public class CellswithOddValuesinaMatrix {
	
	public int oddCells(int n, int m, int[][] indices) {
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];
        
        for(int[] indice : indices) {
        	rows[indice[0]] = !rows[indice[0]];
        	cols[indice[1]] = !cols[indice[1]];
        }
        
        int nr = 0;
        int nc = 0;
        for(int i = 0; i < n; i++) if(rows[i]) nr++;
        for(int i = 0; i < m; i++) if(cols[i]) nc++;
        
        return nr * (m-nc) + nc * (n-nr);
    }
	
	public static void main(String[] args) {
		CellswithOddValuesinaMatrix test = new CellswithOddValuesinaMatrix();
		int[][] indices = {{0,0},{0,0}};
		System.out.println(test.oddCells(1, 1, indices));

	}
	
}
