
public class StringWithoutAAAorBBB {
	
	public String strWithout3a3b(int A, int B) {
		StringBuilder sb = new StringBuilder();
		
		while(A > 0 || B > 0) {
			if(A > B) {
				if(A > 1) {
					sb.append("aa");
					A = A-2;
				}else {
					sb.append("a");
					A = A-1;
				}
				
				if(B > 0) {
					sb.append("b");
					B--;
				}
			}else if(B > A) {
				if(B > 1) {
					sb.append("bb");
					B = B-2;
				}else {
					sb.append("b");
					B--;
				}
				if(A > 0) {
					sb.append("a");
					A--;
				}
				
			}else {
				sb.append("ab");
				A--;
				B--;
			}
		}
		
		return sb.toString();
    }
	
	public static void main(String[] args) {
		StringWithoutAAAorBBB test = new StringWithoutAAAorBBB();
		System.out.println(test.strWithout3a3b(1, 3));
	}
	
}
