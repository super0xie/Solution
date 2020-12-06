
public class CheckArrayFormationThroughConcatenation {
	
	public boolean canFormArray(int[] arr, int[][] pieces) {
		
		int i = 0;
		while(i < arr.length) {
			int j = 0;
			for(; j < pieces.length; j++) {
				if(pieces[j][0] == arr[i]) {
					for(int k = 0; k < pieces[j].length; k++) 
						if(arr[i+k] != pieces[j][k]) return false;
					i = i + pieces[j].length;
					break;
				}
			}
			if(j == pieces.length) return false;
		}
		
        return true;
    }
	
}
