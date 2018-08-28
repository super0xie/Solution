import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        String[] strs = input.split("\\n");
        
        int prefixLen = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int currentLevel = 0;
        int result = 0;
        int lastRaw = 0;
        for(String str : strs) {
        	int level = 0;
        	int i = 0;
        	while(str.charAt(i) == '\t') {
        		i++;
        		level++;
        	}
        	int rawLen = str.length() - i;
        	
        	if(level == currentLevel) {
        		int abs = prefixLen + rawLen;
        		if(abs > result && str.contains(".")) result = abs;
        	}else if(level == currentLevel + 1) {
        		stack.push(lastRaw);
        		prefixLen += lastRaw + 1;
        		currentLevel = level;
        		int abs = prefixLen + rawLen;
        		if(abs > result && str.contains(".")) result = abs;
        	}else {
        		int levelDif = currentLevel - level;
        		for(i = 0; i < levelDif; i++) {
        			int poped = stack.pop();
        			prefixLen = prefixLen - poped - 1;
        		}
        		currentLevel = level;
        		int abs = prefixLen + rawLen;
        		if(abs > result && str.contains(".")) result = abs;
        	}
        	lastRaw = rawLen;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	LongestAbsoluteFilePath test = new LongestAbsoluteFilePath();
//    	System.out.println("dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext");
    	System.out.println(test.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}
