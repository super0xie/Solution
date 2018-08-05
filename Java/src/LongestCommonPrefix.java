
public class LongestCommonPrefix {
    
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs.length < 1) return result;
        if(strs.length == 1) return strs[0];
        
        int lastIndex = 0;
        while(true) {
            if(lastIndex > strs[0].length() - 1) return strs[0].substring(0, lastIndex);
            
            char c = strs[0].charAt(lastIndex);
            for(String str : strs) {
                if(lastIndex > str.length() - 1 || str.charAt(lastIndex) != c) {
                    return strs[0].substring(0, lastIndex);
                }
            }
            lastIndex++;
        }
    }
    
    public static void main(String[] args) {
        LongestCommonPrefix test = new LongestCommonPrefix();
        
        String [] strs = {"dogcar","dogc","dogcar"};
        System.out.println(test.longestCommonPrefix(strs));
    }

}
