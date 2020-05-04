import java.util.Arrays;

public class FindtheMinimumNumberofFibonacciNumbersWhoseSumIsK {
	
	private static int[] nums = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903};
	
	public int findMinFibonacciNumbers(int k) {
		int res = 1;
        while(k > 0) {
        	int ret = Arrays.binarySearch(nums, k);
        	if(ret >= 0) return res;
        	else {
        		ret = - ret - 1;
        		k -= nums[ret-1];
        		res++;
        	}
        }
        return -1;
    }
	
	
	public static void main(String[] args) {
//		int i = 1;
//		int j = 1;
//		
//		for(int n = 0; n < 100; n++) {
//			int sum = i+j;
//			System.out.print(sum+", ");
//			i = j;
//			j = sum;
//		}
		
//		System.out.println(Arrays.binarySearch(nums, 4));
		FindtheMinimumNumberofFibonacciNumbersWhoseSumIsK test = new FindtheMinimumNumberofFibonacciNumbersWhoseSumIsK();
		System.out.println(test.findMinFibonacciNumbers(19));
		
	}
}
