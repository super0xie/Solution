
public class DecryptStringfromAlphabettoIntegerMapping {
	public String freqAlphabets(String s) {
		String[] strs = s.split("#");
		StringBuilder sb = new StringBuilder();
		
		
		for(int i = 0; i < strs.length; i++) {
			String str = strs[i];
			if(str.length() < 2 || (i == strs.length-1 && s.charAt(s.length()-1) != '#')) {
				for(int j = 0; j < str.length(); j++)
					sb.append((char)('a'+((int)(str.charAt(j) - '0')-1)));
			} else {
				for(int j = 0; j < str.length()-2; j++) {
					sb.append((char)('a'+((int)(str.charAt(j) - '0')-1)));
				}
				
				int n = Integer.parseInt(str.substring(str.length()-2, str.length()));
				sb.append((char)('a'+(n-1)));
			}
		}
		return sb.toString();
        
    }
	
	public static void main(String[] args) {
		DecryptStringfromAlphabettoIntegerMapping test = new DecryptStringfromAlphabettoIntegerMapping();
		System.out.println(test.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
//		System.out.println((char)('a' + 1));
	}
}
