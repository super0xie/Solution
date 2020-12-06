import java.util.ArrayDeque;
import java.util.Arrays;

public class FindtheMostCompetitiveSubsequence {
//	class N {
//		int v;
//		int i;
//		N(int v, int i){
//			this.v = v;
//			this.i = i;
//		}
//	}
//	
//	public int[] mostCompetitive(int[] nums, int k) {
//       N[] arr = new N[nums.length];
//       
//       for(int i = 0; i < nums.length; i++) {
//    	   arr[i] = new N(nums[i], i);
//       }
//       
//       Arrays.parallelSort(arr, (a, b)->{
//    	   if(a.v != b.v) return a.v - b.v;
//    	   else return a.i-b.i;
//       });
//       
//       
//       
//       
//		
//    }
	
	public int[] mostCompetitive(int[] nums, int k) {
        ArrayDeque<Integer> s = new ArrayDeque<>();
        int[] res = new int[k];
        for(int i = 0; i < nums.length-k; i++) {
        	while(!s.isEmpty() && s.peek() > nums[i]) s.pop();
        	s.push(nums[i]);
        }
        
        int idx = 0;
        for(int i = nums.length-k; i < nums.length; i++) {
        	while(!s.isEmpty() && s.peek() > nums[i]) s.pop();
        	s.push(nums[i]);
        	res[idx++] = s.pollLast();
        }
        return res;
    }
	
	public static void main(String[] args) {
		FindtheMostCompetitiveSubsequence test = new FindtheMostCompetitiveSubsequence();
		test.mostCompetitive(new int[] {3,5,2,6}, 2);
	}
	
}
