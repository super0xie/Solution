
public class CouplesHoldingHands {
	
	public int minSwapsCouples(int[] row) {
		int res = 0;
		for(int i = 0; i < row.length; i+=2) {
			if(row[i]/2 != row[i+1]/2) {
				int other = 0;
				if(row[i] % 2 == 0) other = row[i]+1;
				else other = row[i]-1;
				
				int j = i+2;
				for(; j < row.length; j++) {
					if(row[j] == other) break;
				}
				
				int temp = row[i+1];
				row[i+1] = row[j];
				row[j] = temp;
				
				res++;
			}
		}
		return res;
		
        
    }

}
