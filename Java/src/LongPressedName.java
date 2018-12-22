

public class LongPressedName {
	
	public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while(i < name.length() && j < typed.length()) {
        	if(name.charAt(i) == typed.charAt(j)) {
        		i++;
        		j++;
        	}else {
        		if(j > 0 && typed.charAt(j) == typed.charAt(j-1)) j++;
        		else return false;
        		
        	}
        }
        if(i < name.length() && j >= typed.length()) return false;
        
        return true;
    }
	
	public static void main(String[] args) {
		LongPressedName test = new LongPressedName();
		System.out.println(test.isLongPressedName("laiden", "laiden"));
	}
	
}
