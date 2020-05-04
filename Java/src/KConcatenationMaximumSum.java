import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KConcatenationMaximumSum {
	
	public int kConcatenationMaxSum(int[] arr, int k) {
		long res = 0;
		int mod = 1000000000+7;
		
		int prefixSumMax = Math.max(0, arr[0]);
		int dp = arr[0];
		res = Math.max(res, dp);
		int prefixSum = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			prefixSum += arr[i];
			prefixSumMax = Math.max(prefixSumMax, prefixSum);
			dp = Math.max(dp+arr[i], arr[i]);
			res = Math.max(res, dp);
		}
		
		int sum = prefixSum;
		
		int suffixSum = 0;
		int suffixSumMax = 0;
		
		for(int i = arr.length-1; i >= 0; i--) {
			suffixSum += arr[i];
			suffixSumMax = Math.max(suffixSumMax, suffixSum);
		}
		
		if(k > 1) {
			long aux = prefixSumMax + suffixSumMax;
			if(sum > 0) {
				aux += (long)(k-2) * (long)sum;
			}
			
			res = Math.max(res, aux);
		}
		res = res % mod;
		
		return (int)res;
	}
	
	public static void main(String[] args) {
		KConcatenationMaximumSum test = new KConcatenationMaximumSum();
		File file = new File("C:\\Users\\sxie\\Desktop\\work\\Solution\\Java\\src\\testcase");
		try {
			Scanner sc = new Scanner(file);
			String str = sc.nextLine();
			String[] nums = str.split(",");
			int[] arr = new int[nums.length];
			for(int i = 0; i < nums.length; i++) arr[i] = Integer.parseInt(nums[i]);
			System.out.println(test.kConcatenationMaxSum(arr, 36263));
			
			
			
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
//		int[] arr = {1,-1};
//		System.out.println(test.kConcatenationMaxSum(arr, 1));
	}
	
}
