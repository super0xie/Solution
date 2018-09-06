import java.util.HashSet;

public class UniqueMorseCodeWords {
    
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<String>();
        String [] encode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        for(String str : words) {
            String res = "";
            for(int i = 0; i < str.length(); i++) {
                res += encode[str.charAt(i)-'a'];
            }
            
            set.add(res);
            
        }
        return set.size();
        
    }
    
}
