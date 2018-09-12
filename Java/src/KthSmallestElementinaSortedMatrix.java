import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {
	
	private class Node {
		int r;
		int c;
		int v;
		
		Node(int r, int c, int v){
			this.r = r;
			this.c = c;
			this.v = v;
		}
		
	}
	
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->{return a.v - b.v;}) ;
		
		for(int j = 0; j < n; j++) pq.add(new Node(0, j, matrix[0][j]));
		
		for(int i = 0; i < k-1; i++) {
			Node polled = pq.poll();
			if(polled.r != n-1) {
				pq.add(new Node(polled.r+1, polled.c, matrix[polled.r+1][polled.c]));
			}
		}
		
		return pq.poll().v;
    }
	
	public static void main(String[] args) {
		int[][] matrix =  {{1,3,5},{6,7,12},{11,14,14}};
		int k = 3;
		
		KthSmallestElementinaSortedMatrix test = new KthSmallestElementinaSortedMatrix();
		System.out.println(test.kthSmallest(matrix, k));
		
		
	}

}
