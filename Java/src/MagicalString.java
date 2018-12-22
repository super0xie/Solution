
public class MagicalString {
	
	public int magicalString(int n) {
        String str = "1221";
        int len = 4;
        while(len < n) {
        	str = helper(str);
        	len = str.length();
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
        	if(str.charAt(i) == '1') res++;
        }
        return res;
    }
	
	private String helper(String str) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			int a = 2;
			if(i % 2 == 0) {
				a = 1;
			}
			int count = str.charAt(i) - '0';
			for(int j = 0; j < count; j++)
				sb.append(a);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] arsg) {
		MagicalString test = new MagicalString();
		System.out.println(test.magicalString(7));
	}
	
	
	
}

