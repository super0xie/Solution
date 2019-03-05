public class StringtoInteger{
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0) return 0;
        int sign = 1;
        int i = 0;
        if(str.charAt(0) == '-'){
            sign = -1;
            i++;
        }else if(str.charAt(0) == '+'){
            i++;
        }
        str = str.substring(i);
        if(str.length() == 0 || str.charAt(0) < '0' || str.charAt(0) > '9') return 0;

        String[] strs = str.split("[^0123456789]");
        if(strs.length == 0 || strs[0].length() == 0) return 0;

        str = strs[0];
        long res = 0;
        for(i = 0; i < str.length(); i++){
            res = res * 10;
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                res += str.charAt(i)-'0';
            }else{
                return 0;
            }
            if((sign > 0 && res > Integer.MAX_VALUE) || (sign < 0 && res > Integer.MAX_VALUE + 1l)){
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        return (int)(sign * res);
    }

    public static void main(String[] args) {
        StringtoInteger test = new StringtoInteger();
        System.out.print(test.myAtoi("-42"));
    }
}