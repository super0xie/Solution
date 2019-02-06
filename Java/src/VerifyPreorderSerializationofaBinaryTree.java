import java.util.Stack;

public class VerifyPreorderSerializationofaBinaryTree {
    
    public boolean isValidSerialization(String preorder) {
        
        String[] strs = preorder.split(",");
        Stack<String> s = new Stack<>();
        for(String str : strs) {
            if(str.equals("#")) {
                if(!s.isEmpty() && s.peek().equals("#")) {
                    while(!s.empty() && s.peek().equals("#")) {
                        s.pop();
                        if(s.isEmpty()) return false;
                        s.pop();
                    }
                    s.push("#");
                }else {
                    s.push("#");
                }
            }else {
                s.push(str);
            }
            
        }
        
        return s.size() == 1 && s.peek().equals("#");
        
    }
}
