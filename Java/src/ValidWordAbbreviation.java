
public class ValidWordAbbreviation {
    
    public boolean validWordAbbreviation(String word, String abbr) {
        int p = 0;
        
        for(int i = 0; i < abbr.length(); i++) {
            if(abbr.charAt(i) <= 'z' && abbr.charAt(i) >= 'a') {
                if(p >= word.length() || abbr.charAt(i) != word.charAt(p)) return false;
                p++;
            }else {
                if(abbr.charAt(i) == '0') return false;
                int j = i;
                while(j < abbr.length() && abbr.charAt(j) <= '9' && abbr.charAt(j) >= '0') j++;
                int count = Integer.valueOf(abbr.substring(i, j));
                for(int k = 0; k < count; k++) p++;
                if(p > word.length()) return false;
                i = j-1;
            }
        }
        
        if(p != word.length()) return false;
        
        return true;
    }
    
    public static void main(String[] args) {
        ValidWordAbbreviation test = new ValidWordAbbreviation();
        System.out.println(test.validWordAbbreviation("a", "01"));
    }
}
