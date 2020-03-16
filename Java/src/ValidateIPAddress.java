public class ValidateIPAddress{

    public String validIPAddress(String IP) {
        if(IP.contains(".")){
            if(validIPV4(IP)) return "IPv4";
        }else if(IP.contains(":")){
            if(validIPV6(IP)) return "IPv6";
        }
        return "Neither";
    }

    private boolean validIPV4(String IP){
        if(IP.charAt(0) == '.' || IP.charAt(IP.length()-1) == '.') return false;
        String[] strs = IP.split("\\.");
        if(strs.length != 4) return false;

        for(String str : strs){
            if(str.length() == 0) return false;
            if(str.length() > 1 && str.charAt(0) == '0') return false;
            if(str.length() > 3) return false;
            int n = 0;
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    n = n * 10;
                    n += str.charAt(i) - '0';
                }else{
                    return false;
                }
            }
            if(n > 255) return false;
        }

        return true;
    }

    private boolean validIPV6(String IP){
        if(IP.charAt(0) == ':' || IP.charAt(IP.length()-1) == ':') return false;
        String[] strs = IP.split(":");
        if(strs.length != 8) return false;

        for(String str : strs){
            if(str.length() == 0) return false;
            // if(str.length() > 1 && str.charAt(0) == '0') return false;
            if(str.length() > 4) return false;

            for(int j = 0; j < str.length(); j++){
                if(!((str.charAt(j) <= '9' && str.charAt(j) >= '0')
                ||(str.charAt(j) <= 'f' && str.charAt(j) >= 'a')
                ||(str.charAt(j) <= 'F' && str.charAt(j) >= 'A'))) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidateIPAddress test = new ValidateIPAddress();
        System.out.println(test.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }

}