import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
	
	public List<String> removeComments(String[] source) {
		
        List<String> res = new ArrayList<String>();
        boolean inCom = false;
        String prefix = null;
        for(int i = 0; i < source.length; i++) {
        	String str = source[i];
        	if(!inCom) {
        		int idxLine = str.indexOf("//");
        		int idxBlock = str.indexOf("/*");

        		if((idxLine >= 0 && idxBlock < 0) || (idxLine < idxBlock && idxLine >= 0)) {
        			str = str.substring(0, idxLine);
            		if(str.length() > 0) res.add(str);
        		}else if((idxBlock >= 0 && idxLine < 0) || (idxBlock < idxLine && idxBlock >= 0)) {
        			
        			String pre = str.substring(0, idxBlock);
        			if(idxBlock + 2 < str.length()) {
        				str = str.substring(idxBlock + 2);
        			}
        			int idxBlockEnd = str.indexOf("*/");
        			if(idxBlockEnd >= 0) {
        				String rest = pre;
        				if(idxBlockEnd+2 < str.length()) rest += str.substring(idxBlockEnd+2);
        				if(rest.length() > 0) {
        					source[i] = rest;
            				i--;
        				}
        			}else {
        				inCom = true;
        				if(pre.length() > 0) prefix = pre;
        			}
        		}else {
        			res.add(str);
        		}
        	}else {
        		int idxLine = str.indexOf("//");
        		int idxBlock = str.indexOf("/*");
        		int idxBlockEnd = str.indexOf("*/");
        		
        		if(idxBlockEnd >= 0) {
        			String rest = "";
        			if(idxBlockEnd + 2 < str.length()) {
        				rest = str.substring(idxBlockEnd + 2);
        				if(prefix != null) rest = prefix + rest;
        			}else {
        				if(prefix != null)
        					rest = prefix;
        			}
        			
        			if(rest.length() > 0) {
    					source[i] = rest;
        				i--;
    				}
        			
        			inCom = false;
            		
        		}
        		
        	}
        	
        	
        	
        }
        
        return res;
        
    }
	
	public static void main(String[] args) {
		RemoveComments test = new RemoveComments();
		String[] source = {"main() {", "   func(1);", "   /** / more comments here", "   float f = 2.0", "   f += f;", "   cout << f; */", "}"};
		test.removeComments(source);
	}

}
