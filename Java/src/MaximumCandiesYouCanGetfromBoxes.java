import java.util.LinkedList;

public class MaximumCandiesYouCanGetfromBoxes {
	
	public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
		int n = status.length;
		boolean[] hasBox = new boolean[n];
		boolean[] visited = new boolean[n];
		boolean[] hasKey = new boolean[n];
		
		LinkedList<Integer> l = new LinkedList<>();
		for(int i : initialBoxes) {
			hasBox[i] = true;
			if(status[i] == 1) {
				visited[i] = true;
				l.add(i);
			}
		}
		int sum = 0;
		while(!l.isEmpty()) {
			int p = l.poll();
			sum += candies[p];
			
			for(int i : keys[p]) {
				hasKey[i] = true;
				if(!visited[i] && hasBox[i]) {
					visited[i] = true;
					l.add(i);
				}
			}
			
			for(int box : containedBoxes[p]) {
				hasBox[box] = true;
				
				if(!visited[box] && (status[box] == 1 || hasKey[box])) {
					visited[box] = true;
					l.add(box);
				}
				
			}
		
		}
		
		return sum;
		
	}
	
	public static void main(String[] args) {
		MaximumCandiesYouCanGetfromBoxes test = new MaximumCandiesYouCanGetfromBoxes();
		int[] status = {1,1,1};
		int[] candies = {2,3,2};
		int[][] keys = {{},{},{}};
		int[][] containedBoxes = {{},{},{}};
		int[] initialBoxes = {2,1,0};
		
		System.out.println(test.maxCandies(status, candies, keys, containedBoxes, initialBoxes));
		
	}
}
