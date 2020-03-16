public class IntegertoEnglishWords{

    public String numberToWords(int num) {
        String str = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        if(str.length() > 9){
            sb.append(helper(str.substring(0, str.length()-9)));
            sb.append(" ");
            sb.append("Billion");
        }

        if(str.length() > 6){
            String sub = str.substring(str.length() > 9 ? str.length()-9 : 0, str.length()-6);
            if(!sub.equals("000")){
                if(sb.length() != 0) sb.append(" ");
                sb.append(helper(sub));
                sb.append(" ");
                sb.append("Million");
            }
        }

        if(str.length() > 3){
            String sub = str.substring(str.length() > 6 ? str.length()-6 : 0, str.length()-3);
            if(!sub.equals("000")){
                if(sb.length() != 0) sb.append(" ");
                sb.append(helper(sub));
                sb.append(" ");
                sb.append("Thousand");
            }
        }

        String sub = str.substring(str.length() > 3 ? str.length()-3 : 0);
        if(!sub.equals("000")){
            if(sb.length() != 0) sb.append(" ");
            sb.append(helper(sub));
        }
        return sb.toString();
    }

    private String[] cache = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
    , "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private String[] ten = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private String helper(String str){
        StringBuilder sb = new StringBuilder();
        if(str.length() == 3 && str.charAt(0) != '0') {
            sb.append(cache[str.charAt(0)-'0'-1]);
            sb.append(" ");
            sb.append("Hundred");
        }

        if(str.length() >= 2 && str.charAt(str.length()-2) <= '1') {
            int idx = (str.charAt(str.length()-2)-'0') * 10 + (int)(str.charAt(str.length()-1)-'0');
            if(idx == 0) {
                if(sb.length() == 0) return "Zero"; 
                else return sb.toString();
            }
            String toAppend = cache[idx-1];
            if(sb.length() != 0) sb.append(" ");
            sb.append(toAppend);
            return sb.toString();
        }
        
        if(str.length() >= 2){
            int idx = (int)(str.charAt(str.length()-2) - '0') - 2;
            if(sb.length() != 0) sb.append(" ");
            sb.append(ten[idx]);
        }

        if(str.length() >= 1){
            int idx = (int)(str.charAt(str.length()-1) - '0');
            if(idx == 0){
                if(sb.length() == 0) return "Zero";
                else return sb.toString();
            }
            if(sb.length() != 0) sb.append(" ");
            sb.append(cache[idx-1]);
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        IntegertoEnglishWords test = new IntegertoEnglishWords();
        System.out.print(test.numberToWords(1000001));
    }

}