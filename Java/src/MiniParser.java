import java.util.HashMap;
import java.util.Stack;

public class MiniParser {
    
    public NestedInteger deserialize(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '[') stack.push(i);
            else if(s.charAt(i) == ']') map.put(stack.pop(), i);
        }
        
        if(s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }else {
            return helper(map, s, 0, s.length()-1);
        }
        
    }
    
    private NestedInteger helper(HashMap<Integer, Integer> map, String s, int l, int r) {
        NestedInteger ni = new NestedInteger();
        
        for(int i = l+1; i < r; i++) {
            if((s.charAt(i) <= '9' && s.charAt(i) >= '0') || s.charAt(i) == '-') {
                int j = i;
                while(j < r && s.charAt(j) != ',' && s.charAt(j) != ']') j++;
                ni.add(new NestedInteger(Integer.parseInt(s.substring(i, j))));
                i = j;
            }else if(s.charAt(i) == '[') {
                int right = map.get(i);
                ni.add(helper(map, s, i, right));
                i = right;
            }else if(s.charAt(i) == ',') continue;
        }
        
        return ni;
    }
    
}
