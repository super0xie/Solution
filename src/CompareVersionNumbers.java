import java.util.Arrays;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        
        int i = 0;
        
        
        while(i < strs1.length && i < strs2.length) {
        	int a = Integer.parseInt(strs1[i]);
        	int b = Integer.parseInt(strs2[i]);
        	
        	if(a > b) return 1;
        	else if(a < b) return -1;
        	else i++;
        }
        
        if(strs1.length > strs2.length) {
        	for(int j = i; j < strs1.length; j++){
        		if(Integer.parseInt(strs1[j]) != 0) return 1;
        	}
        	return 0;
        }
        else if(strs1.length < strs2.length) {
        	for(int j = i; j < strs2.length; j++){
        		if(Integer.parseInt(strs2[j]) != 0)) return -1;
        	}
        	return 0;
        }
        else return 0;
        
    }
	
	public static void main(String[] args) {
		CompareVersionNumbers test = new CompareVersionNumbers();
    	System.out.println(test.compareVersion("0.1", "1.1"));
    }

}
