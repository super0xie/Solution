import java.util.Random;

public class Main {
	
	private static int seq;
	
	public static void main(String[] args) {
		int count = 0;
		Long last = -1l;
		Random r = new Random();
		while(true) {
//			long cur = System.currentTimeMillis() / 100 * 10000000 + seq++;
			long cur = seq++;

			System.out.println(cur);
			if(cur == last) break;
			last = cur;
			count++;
		}
		
		System.out.println("break at:" + count);
		System.out.println(1 / 10 * 10);
	}
}
