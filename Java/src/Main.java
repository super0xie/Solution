import java.math.BigInteger;
import java.util.Random;

public class Main {
	
	private static int seq;
	
	public static int test(int i) {
        try 
        {
          throw new Exception();
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally {
            return 2;
        }
    }
	
	public static void main(String[] args) {
//		BigInteger a = new BigInteger("8866128975287528");
//		BigInteger b = new BigInteger("8778405442862239");
//		BigInteger c = new BigInteger("2736111468807040");
//		
//		
//		System.out.println(a.multiply(a).multiply(a).subtract(b.multiply(b).multiply(b)).subtract(c.multiply(c).multiply(c)));
//		System.out.println(b.multiply(b).multiply(b).toString());
//		System.out.println(c.multiply(c).multiply(c).toString());
		
		
		test(1);
	
	}
}
