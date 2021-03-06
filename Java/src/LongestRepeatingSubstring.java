import java.util.HashMap;
import java.util.HashSet;

public class LongestRepeatingSubstring {

    public int longestRepeatingSubstring(String S) {
        int l = 0;
        int r = S.length()-1;

        String res = "";
        while(l < r){
            int mid = r - (r - l) / 2;
            String ret = containsDuplicateOfLength(S, mid);
            if(ret == null){
                r = mid-1;
            }else{
                l = mid;
                res = ret;
            }
        }

        return res.length();
    }

    private String containsDuplicateOfLength(String s, int len){
        if(len == 0) return "";
        if(len >= s.length()) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i + len <= s.length(); i++){
            String sub = s.substring(i, i+len);
            int hash = sub.hashCode();
            if(map.containsKey(hash) && helper(s, map.get(hash), i, len)) return sub;
            map.put(sub.hashCode(), i);
        }
        return null;
    }
    
    private boolean helper(String s, int i, int j, int len) {
    	for(int k = 0; k < len; k++)
    		if(s.charAt(i+k) != s.charAt(j+k)) return false;
    	return true;
    }

    public static void main(String[] args) {
        LongestRepeatingSubstring test = new LongestRepeatingSubstring();
        System.out.println(test.longestRepeatingSubstring("aaabaabaaaababaaaaaaaabaabaaabbbaaaabbbabbbaaaababbbababbbabaaabbaabaaabbaabbaaaabbbaaaabababbbbbaabbbabbaaabababbbbbbaabaaaabbbaaaaaabbbababbaabbbbaabaaabbababbbbabbbabbaabaaaaaabbabaabbbbbabaabababaabbabaaaabbbabbbbbabbaaaaabaababbbbabbaaaaaababbbbaabbbaabaaabaabbbbabbabaabaaaabaaabaaaaaabbbbabbbabbabaaabbbaaaaababaabaabbbbbababaaabbaaaabbbabababaabaabbababbbaaaaabbbabaabbbbbaaabbbaaaaaaabbbbbbbbabbaabbbabaaaabbbbabababababbabbbbbababaaaaababaabbabbbbaababaabbbbbabbbabbaaabbababaabbabbbbaaabaabbaaabbbababaabaaaaaabababaaababaaabaabaabaababaabbaaaaaabababbbabbaababbbababbabababbbabbababbbabbaaaabbbaaabbaababababaaaabbababbbbaaababababbabababbaaaaaabababbbabbabbbaabaaaaabbbbaabaababbbbbbbbbbbbaaaaaaababbbbbaaabaaaaaabaababaababaabaaabbbbaabbbaabbaaaaabaaabaaaababbaabaaaababbbaabbbabaabbaabbbbbabaaaaabaabbabaabbaaaabbababaaabaabbabbbaaaaaaababbbabaaaaaabbbaaabbbabaaabbaaaabbbaabaabbaaaaaaaaabababaaabbaabaaaaaaabbbbabbabbbbbbabbbbbbbaabbbaaaabbabbbbbaabaabbbbbbaabbabbabbaababbbaababbbaab"));
    }

}