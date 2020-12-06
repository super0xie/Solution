import java.util.HashSet;

public class MinimumSwapstoArrangeaBinaryGrid {
	
	public int minSwaps(int[][] grid) {
		int n = grid.length;
        int[] target = new int[n];
        boolean[] used = new boolean[n];
        int assigned = 0;
        
        for(int i = 0; i < grid.length; i++) {
        	int j = n-1;
        	int count = 0;
        	while(j >= 0 && grid[i][j] == 0) {
        		count++;
        		j--;
        	}
        	
        	for(int k = 0; k < n; k++) {
        		if(count >= n-1-k && !used[k]) {
        			used[k] = true;
        			assigned++;
        			target[i] = k;
        			break;
        		}
        	}
        }
        
        if(assigned < n) return -1;
        return bubbleSort(target);
        
    }
	
	
	private int bubbleSort(int[] arr) {
		int count = 0;
		
		for(int i = 1; i < arr.length; i++) {
			int j = i;
			while(j > 0 && arr[j] < arr[j-1]) {
				int t = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = t;
				count++;
				j--;
			}
		}
		
		return count;
	}
	
	
	public static void main(String[] args) {
		MinimumSwapstoArrangeaBinaryGrid test = new MinimumSwapstoArrangeaBinaryGrid();
		int[][] grid = {{1,0,0},{1,1,0},{1,1,1}};
//		int[] arr = {3, 1, 5, 4, 2};
//		test.bubbleSort(arr);
//		for(int i : arr) System.out.print(i + ", ");
		System.out.println(test.minSwaps(grid));
	}
}
