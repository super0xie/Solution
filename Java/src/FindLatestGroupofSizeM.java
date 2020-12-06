
public class FindLatestGroupofSizeM {
	
	public int findLatestStep(int[] arr, int m) {
		int n = arr.length;
        boolean[] a = new boolean[n];
        int[][] aux = new int[n][2];
        int res = -1;
        int count = 0;
        for(int i = 0; i < n; i++) {
        	int idx = arr[i]-1;
        	a[idx] = true;
        	
        	if((idx == 0 || !a[idx-1]) && (idx == n-1 || !a[idx+1])) {
        		aux[idx][0] = idx;
        		aux[idx][1] = idx;
        		if(m == 1) count++;
        	}else if(idx > 0 && a[idx-1] && idx < n-1 && a[idx+1]) {
        		int ll = aux[idx-1][1]-aux[idx-1][0] + 1;
        		int lr = aux[idx+1][1]-aux[idx+1][0] + 1;
        		if(ll == m) count--;
        		if(lr == m) count--;
        		if(ll + lr + 1 == m) count++;
        		
        		aux[aux[idx-1][0]][1] = aux[idx+1][1];
        		aux[aux[idx+1][1]][0] = aux[idx-1][0];
        	}else if(idx > 0 && a[idx-1]) {
        		int ll = aux[idx-1][1]-aux[idx-1][0] + 1;
        		aux[idx][0] = aux[idx-1][0];
        		aux[idx][1] = idx;
        		aux[aux[idx-1][0]][1] = idx;
        		if(ll == m) count--;
        		if(ll + 1 == m) count++;
        	}else {
        		int lr = aux[idx+1][1]-aux[idx+1][0] + 1;
        		aux[idx][0] = idx;
        		aux[idx][1] = aux[idx+1][1];
        		aux[aux[idx+1][1]][0] = idx;
        		if(lr == m) count--;
        		if(lr + 1 == m) count++;
        	}
        	
        	if(count > 0) res = i+1;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] arr = {3,2,5,6,10,8,9,4,1,7};
		FindLatestGroupofSizeM test = new FindLatestGroupofSizeM();
		test.findLatestStep(arr, 3);
	}
	
}
