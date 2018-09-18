
public class Remove9 {
	
	public int newInteger(int n) {
        return Integer.parseInt(Integer.toString(n, 9));
    }
	
	public static void main(String[] args) {
		System.out.println(Integer.toString(10, 9));
	}
	
}
