public class GreatestCommonDivisorofStrings{

    public String gcdOfStrings(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());

        for(int i = len; i > 1; i--){
            if(helper(str1, str2, i)) return str1.substring(0, i);
        }

        return "";
    }

    private boolean helper(String str1, String str2, int n){
        if(str1.length() % n != 0 || str2.length() % n != 0) return false;

        String sub = str1.substring(0, n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str1.length() / n; i++){
            sb.append(sub);
        }
        if(!sb.toString().equals(str1)) return false;
        
        sb = new StringBuilder();
        for(int i = 0; i < str2.length() / n; i++){
            sb.append(sub);
        }

        if(!sb.toString().equals(str2)) return false;

        return true;
    }

    public static void main(String[] args) {
        GreatestCommonDivisorofStrings test = new GreatestCommonDivisorofStrings();
        System.out.println(test.gcdOfStrings("ABABAB", "AB"));
    }

}