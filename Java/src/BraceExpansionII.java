import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class BraceExpansionII {

    public List<String> braceExpansionII(String str) {
        List<List<String>> s = new ArrayList<>();
        List<String> cur = null;
        for(int i = 0; i < str.length(); i++){
            List<String> tmp = null;
            
            if(str.charAt(i) == '{'){
                int count = 1;
                int j = i+1;
                for(; j < str.length(); j++){
                    if(str.charAt(j) == '{') count++;
                    else if(str.charAt(j) == '}') {
                        count--;
                        if(count == 0) break;
                    }
                }
                tmp = braceExpansionII(str.substring(i+1, j));
                i = j;
            }else if(str.charAt(i) == ',') {
                continue;
            }else{
            	int j = i;
            	while(j < str.length() && str.charAt(j) >= 'a' && str.charAt(j) <= 'z') j++;
                tmp = new ArrayList<>();
                tmp.add(str.substring(i, j));
                i = j-1;
            }
            
            if(cur != null) {
            	cur = concat(cur, tmp);
            }else {
            	cur = tmp;
            }
            
            if(i == str.length()-1 || str.charAt(i+1) == ',') {
            	if(cur != null) {
            		s.add(cur);
            		cur = null;
            	}	
            }
        }
        
        List<String> res = union(s);
        Collections.sort(res);
        return res;
    }
    
    private List<String> union(List<List<String>> s){
        HashSet<String> set = new HashSet<>();
        for(List<String> l : s) {
        	for(String str : l) {
        		set.add(str);
        	}
        }
        
        List<String> res = new ArrayList<>();
        for(String str : set) res.add(str);
        return res;
    }

    private List<String> concat(List<String> l1, List<String> l2){
        List<String> res = new ArrayList<>();
        for(String str1 : l1){
            for(String str2 : l2){
                res.add(str1 + str2);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        BraceExpansionII test = new BraceExpansionII();
        List<String> res = test.braceExpansionII("{a,b}{c{d,e}}");
        for(String str : res) System.out.println(str);
    }
    
}