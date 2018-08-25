import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
    
    public List<String> findRepeatedDnaSequences(String s) {
//        List<String> result = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        HashSet<String> resultSet = new HashSet<String>();
        
//        String[] strs = new String [s.length()-9];
        for(int i = 0; i <= s.length()-10; i++) {
//            strs[i] = s.substring(i, i+10);
            String str = s.substring(i, i+10);
            if(set.contains(str)) {
                resultSet.add(str);
            }else {
                set.add(str);
            }
            
            
        }
        
        List<String> result = new ArrayList<String>(resultSet);
        return result;
        
    }
}
