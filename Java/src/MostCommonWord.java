import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
    
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
//        paragraph = paragraph.replaceAll("[!?',;.]", "");
        char last = paragraph.charAt(paragraph.length()-1);
        if(last == '!' || last == '?' || last == '\'' || last == ',' || last == ';' || last == '.')
            paragraph = paragraph.substring(0, paragraph.length()-1);
        String[] strs = paragraph.split("[!?',;.]? ");
        
        HashSet<String> ban = new HashSet<String>();
        for(String str : banned) {
            ban.add(str);
        }
        
        int max = 0;
        String res = null;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(String str : strs) {
            if(!ban.contains(str)) {
                int count = map.getOrDefault(str, 0)+1;
                if(count > max) {
                    max = count;
                    res = str;
                }
                map.put(str, count);
                
            }
            
        }
        return res;
    }
    
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        
        MostCommonWord test = new MostCommonWord();
        test.mostCommonWord(paragraph, banned);
    }

}
