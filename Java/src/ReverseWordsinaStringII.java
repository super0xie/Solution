
public class ReverseWordsinaStringII {
    
    public void reverseWords(char[] str) {
        int i = 0;
        int j = str.length-1;
        while(i < j) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            i++;
            j--;
        }
        
        for(i = 0; i < str.length; i++) {
            if(str[i] != ' ') {
                j = i;
                while(j < str.length && str[j] != ' ') j++;
                j--;
                int k = j;
                
                while(i < k) {
                    char tmp = str[i];
                    str[i] = str[k];
                    str[k] = tmp;
                    i++;
                    k--;
                }
                
                i = j;
            }
        }
    }
    
    
    
}
