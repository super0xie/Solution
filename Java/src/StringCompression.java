
public class StringCompression {
	public int compress(char[] chars) {
        int tar = 0;
        for(int i = 0; i < chars.length; i++) {
        	int j = i;
        	while(j < chars.length && chars[j] == chars[i]) j++;
        	if(j - i > 1) {
        		String count = String.valueOf(j-i);
        		chars[tar++] = chars[i];
        		for(int k = 0; k < count.length(); k++) {
        			chars[tar++] = count.charAt(k);
        		}
        	}else {
        		chars[tar++] = chars[i];
        	}
        	i = j-1;
        }
        return tar;
    }
	
	public static void main(String[] args) {
		char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		StringCompression test = new StringCompression();
		test.compress(chars);
	}
}
