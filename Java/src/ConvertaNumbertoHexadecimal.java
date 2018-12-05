
public class ConvertaNumbertoHexadecimal {
    
    private char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
//    public String toHex(int num) {
//        long sum = 4294967296l;
//        StringBuilder sb = new StringBuilder();
//        
//        if(num < 0) {
//            num = (int)(sum + num);
//            System.out.println(sum + num);
//            System.out.println(num == Integer.MAX_VALUE);
//        }
//        
//        return "";
//        
//    }
    
    public String toHex(int num) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(num != 0) {
            int n = num & 0x0000000f;
            sb.append(chars[n]);
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        ConvertaNumbertoHexadecimal test = new ConvertaNumbertoHexadecimal();
        
        System.out.println(test.toHex(26));
    }

}
