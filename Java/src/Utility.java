import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Utility {
	public static void print2DArray(int[][] mat) {
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + ", ");
			}
			System.out.print("\n");
		}
	}
	
	public static void print2DArray(char[][] mat) {
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + ", ");
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		
		try {
//			File file = new File("C:\\Users\\sxie\\Desktop\\work\\Solution\\Java\\src\\98.txt");
//			Scanner sc = new Scanner(file);
//			StringBuilder sb = new StringBuilder();
//			while(sc.hasNext()) {
//				sb.append(sc.nextLine());
//			}
			
			String str = "hello world";
			byte[] input = str.getBytes("UTF-8");
			System.out.println("length before compress is: " + input.length);
			//compress
			byte[] output = new byte[100];
			Deflater compresser = new Deflater();
			compresser.setInput(input);
		    compresser.finish();
		    int len = compresser.deflate(output);
		    System.out.println("length after compress is: " + len);
		    
		    byte[] toExtract = new byte[len];
		    System.arraycopy(output, 0, toExtract, 0, len);
		    Inflater decompresser = new Inflater();
		    decompresser.setInput(toExtract, 0, len);
		    byte[] result = new byte[100];
		    int resultLength = decompresser.inflate(result);
		    decompresser.end();
		    String outputString = new String(result, 0, resultLength, "UTF-8");
		    
		    System.out.println(outputString);
		    
		    
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
