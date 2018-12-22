
public class FindSmallestLetterGreaterThanTarget {
    
    public char nextGreatestLetter(char[] letters, char target) {
        char res = 'z'+1;
        char min = 'z';
        
        for(char c : letters) {
            if(c < min) min = c;
            if(c > target) {
                if(c < res) res = c;
            }
        }
        
        if(res == 'z'+1) res = min;
        return res;
    }
    
    
}
