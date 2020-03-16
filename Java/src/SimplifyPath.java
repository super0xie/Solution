import java.util.LinkedList;


public class SimplifyPath {
	public String simplifyPath(String path) {
        String[] dir = path.split("/+");
        StringBuilder sb = new StringBuilder();
        LinkedList<String> s = new LinkedList<>();
        for(String str : dir) {
        	if(str.equals(".")) continue;
        	else if(str.equals("..")) {
        		if(!s.isEmpty()) s.removeLast();
        	}
        	else if(str.length() > 0) s.add(str);
        }
        
        if(s.isEmpty()) return "/";
        for(String str : s) {
        	sb.append("/" + str);
        }
        
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		SimplifyPath test = new SimplifyPath();
		System.out.println(test.simplifyPath("/a//b////c/d//././/.."));
	}
}
