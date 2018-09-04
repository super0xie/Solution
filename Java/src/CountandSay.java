
public class CountandSay {
	public String countAndSay(int n) {
		
		String pre = "1";
		String cur = "";
		for(int i = 1; i < n; i++) {
			cur = "";
			
			for(int j = 0; j < pre.length()-1; j++) {
				int count = 1;
				while(j < pre.length()-1 && pre.charAt(j) == pre.charAt(j+1)) {
					count++;
					j++;
				}
				
				cur = cur + count + pre.charAt(j);
				
			}
			
			if(!(pre.length() > 1 && pre.charAt(pre.length()-1) == pre.charAt(pre.length()-2)))
				cur = cur + 1 + pre.charAt(pre.length()-1);
			
			pre = cur;
			
		}
		
		return pre;

	}
	
	public static void main(String[] args) {
		CountandSay test = new CountandSay();
		System.out.println(test.countAndSay(5));
	}
}
