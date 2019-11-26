
public class EncodeNumber {
	
	private int[] min = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823};
	private int[] max = {2, 6, 14, 30, 62, 126, 254, 510, 1022, 2046, 4094, 8190, 16382, 32766, 65534, 131070, 262142, 524286, 1048574, 2097150, 4194302, 8388606, 16777214, 33554430, 67108862, 134217726, 268435454, 536870910, 1073741822, 2147483646};
		
	public String encode(int num) {
		if(num == 0) return "";
		
		int len = 0;
		for(int i = 0; i < min.length; i++) {
			if(num >= min[i] && num <= max[i]) {
				len = i+1;
				break;
			}
		}
		
		char[] chars = new char[len];
		int cur = (int)Math.pow(2, len);
		for(int i = len-1; i >= 0; i--) {
			int idx = len-1-i;
			if(i == 0) {
				if(num == 1) {
					chars[idx] = '0';
				} else {
					chars[idx] = '1';
				}
			}else {
				if(num >= cur && num-cur >= min[i-1] && num-cur <= max[i-1]) {
					chars[idx] = '1';
					num -= cur;
				}else {
					chars[idx] = '0';
					num -= cur/2;
				}
			}
			cur = cur / 2;
		}
		
        
        
        return String.valueOf(chars);
    }
	
	public static void main(String[] args) {
		EncodeNumber test = new EncodeNumber();
		System.out.println(test.encode(107));
//		int n = 1;
//		for(int i = 0; i < 31; i++) {
//			n = n * 2;
//			System.out.print(n-2 + ", ");
//		}
	}
	
}
