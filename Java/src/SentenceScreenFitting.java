
public class SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int strIndex = 0;
        int result = 0;
        int i = 0;
        while(i < rows) {
            int j = 0;
            if(result != 0 && strIndex == 0) {
                int rowUsed = (int)(rows/i) * i;
                result = result * (int)(rows / i);
                i = rowUsed;
            }
            
            while(j < cols && i < rows) {
                int spaceLeft = cols - j;
                if(spaceLeft >= sentence[strIndex].length()) {
                    j += sentence[strIndex].length();
                    j++;
                    
                    if(strIndex < sentence.length-1) {
                        strIndex++;
                    }else {
                        result++;
                        strIndex = 0;
                    }
                }else {
                    break;
                }
            }
            i++;
            
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        SentenceScreenFitting test = new SentenceScreenFitting();
//        String[] sentence = {"abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r","abcdef","ghijkl","mnop","qrs","tuv","wxyz","asdf","ogfd","df","r"};
        String[] sentence = {"f"};
        System.out.println(test.wordsTyping(sentence, 2, 3));
    }
}
