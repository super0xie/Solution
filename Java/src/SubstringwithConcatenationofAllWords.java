import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s.length() == 0 || words.length == 0) return res;
        int len = words[0].length();
        int sumLen = len * words.length;

        HashMap<String, Integer> dic = new HashMap<>();
        for(String str : words) {
            dic.put(str, dic.getOrDefault(str, 0)+1);
        }
        

        for(int i = 0; i <= s.length()-sumLen; i++){
            HashMap<String, Integer> map = new HashMap<>();
            int j = 0;
            for(; j < words.length; j++){
                String sub = s.substring(i + j * len, i+(j+1) * len);
                if(!dic.containsKey(sub)) break;
                else if(map.getOrDefault(sub, 0) == dic.get(sub)) break;
                else map.put(sub, map.getOrDefault(sub, 0)+1);
            }

            if(j == words.length) res.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        SubstringwithConcatenationofAllWords test = new SubstringwithConcatenationofAllWords();
        for(int i : test.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"})){
            System.out.println(i);
        }
        
    }

}
