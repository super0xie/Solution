import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestcaseFileReader {
	
	public static ArrayList<int[]> getIntArrays(){
		ArrayList<int[]> res = new ArrayList<>();
		File file = new File("C:\\Users\\sxie\\Desktop\\work\\Solution\\Java\\src\\testcase");
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				String str = sc.nextLine();
				String[] nums = str.split(",");
				int[] arr = new int[nums.length];
				for(int i = 0; i < nums.length; i++) arr[i] = Integer.parseInt(nums[i]);
				res.add(arr);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static ArrayList<int[]> getIntArrays(String path){
		ArrayList<int[]> res = new ArrayList<>();
		File file = new File(path);
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				String str = sc.nextLine();
				String[] nums = str.split(",");
				int[] arr = new int[nums.length];
				for(int i = 0; i < nums.length; i++) arr[i] = Integer.parseInt(nums[i]);
				res.add(arr);
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static List<List<Integer>> getListArrays(){
		ArrayList<List<Integer>> res = new ArrayList<>();
		File file = new File("C:\\Users\\sxie\\Desktop\\work\\Solution\\Java\\src\\testcase");
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				String str = sc.nextLine();
				String[] nums = str.split("\\],\\[");
				
				for(int i = 0; i < nums.length; i++) {
					String[] ns = nums[i].split(",");
					res.add(Arrays.asList(Integer.parseInt(ns[0]), Integer.parseInt(ns[1])));
				}
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
		
	}
	
	public static String getString(){
		String res = null;
		File file = new File("C:\\Users\\super\\eclipse-workspace\\Solution\\Java\\src\\testcase");
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				res = sc.nextLine();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

}
