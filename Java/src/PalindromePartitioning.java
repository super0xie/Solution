import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    
    char[] chars;
    List<List<String>> result;
    List<Integer> endIndice;
    
    public List<List<String>> partition(String s) {
        chars = s.toCharArray();
        result = new ArrayList<List<String>>();
        endIndice = new ArrayList<Integer>();
        dfs(0);
        return result;
    }
    
    
    private boolean isPalindrome(int start, int end) {
        while(start < end) {
            if(chars[start] != chars[end]) return false;
            start++;
            end--;
        }
        
        return true;
    }
    
    private void dfs(int start) {
        for(int i = start; i < chars.length; i++) {
            if(isPalindrome(start, i)) {
                endIndice.add(i);
                if(i == chars.length - 1) {
                    List<String> list = new ArrayList<String>();
                    int l = 0;
                    for(int r : endIndice) {
                        String str = String.copyValueOf(chars, l, r-l+1);
                        list.add(str);
                        l=r+1;
                    }
                    result.add(list);
                }
                dfs(i+1);
                endIndice.remove(endIndice.size()-1);

            }
        } 
    }
    
    public static void main(String[] args) {
        PalindromePartitioning test = new PalindromePartitioning();
        test.partition("aab");
        
    }
    
    
}
