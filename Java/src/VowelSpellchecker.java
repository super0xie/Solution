import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class VowelSpellchecker {
    
    private char[] vows = {'a', 'e', 'i', 'o', 'u'};
    
    public String[] spellcheckerOld(String[] wordlist, String[] queries) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, String> capMap = new HashMap<>();
        HashMap<String, String> vowMap = new HashMap<>();
        String[] res = new String[queries.length];
        
        for(String str : wordlist) {
            set.add(str);
            String lower = str.toLowerCase();
            if(!capMap.containsKey(lower)) capMap.put(lower, str);
            
            char[] chars = lower.toCharArray();
            boolean[] isVow = new boolean[chars.length];
            for(int i = 0; i < chars.length; i++) {
                if(isVow(chars[i])) isVow[i] = true;
            }
            ArrayList<String> l = new ArrayList<>();
            helper(chars, isVow, l, 0);
            for(String replaced : l) {
                if(!vowMap.containsKey(replaced))
                    vowMap.put(replaced, str);
            }
        }
        
        
        for(int i = 0; i < queries.length; i++) {
            String str = queries[i];
            if(set.contains(str)) {
                res[i] = str;
                continue;
            }
            String lower = str.toLowerCase();
            if(capMap.containsKey(lower)) {
                res[i] = capMap.get(lower);
                continue;
            }
            
            if(vowMap.containsKey(lower)) {
                res[i] = vowMap.get(lower);
                continue;
            }
            
            res[i] = "";
            
        }
        
        return res;
    }
    
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, String> capMap = new HashMap<>();
        HashMap<String, String> vowMap = new HashMap<>();
        String[] res = new String[queries.length];
        
        for(String str : wordlist) {
            set.add(str);
            String lower = str.toLowerCase();
            if(!capMap.containsKey(lower)) capMap.put(lower, str);
            char[] chars = lower.toCharArray();
            for(int i = 0; i < chars.length; i++) {
                if(isVow(chars[i])) chars[i] = ' ';
            }
            String replace = String.valueOf(chars);
            if(!vowMap.containsKey(replace)) vowMap.put(replace, str);
        }
        
        
        for(int i = 0; i < queries.length; i++) {
            String str = queries[i];
            if(set.contains(str)) {
                res[i] = str;
                continue;
            }
            String lower = str.toLowerCase();
            if(capMap.containsKey(lower)) {
                res[i] = capMap.get(lower);
                continue;
            }
            
            
            char[] chars = lower.toCharArray();
            for(int j = 0; j < chars.length; j++) {
                if(isVow(chars[j])) chars[j] = ' ';
            }
            String replace = String.valueOf(chars);
            if(vowMap.containsKey(replace)) {
                res[i] = vowMap.get(replace);
                continue;
            }
            
            res[i] = "";
            
        }
        
        return res;
    }
    
    private void helper(char[] chars, boolean[] isVow, ArrayList<String> ret, int i){
        if(i == chars.length) {
            ret.add(String.valueOf(chars));
            return;
        }
        
        if(!isVow[i]) {
            helper(chars, isVow, ret, i+1);
        } else {
            for(char c : vows) {
                chars[i] = c;
                helper(chars, isVow, ret, i+1);
            }
        }
    }
    
    private boolean isVow(char c) {
        for(char v : vows) {
            if(c == v) return true;
        }
        return false;
    }

}
