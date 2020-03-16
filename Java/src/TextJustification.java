import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int idx = 0;
        List<String> res = new ArrayList<String>();

        while(idx < words.length){
            int len = 0;
            int endIdx = idx;
            while(len <= maxWidth){
                int nextLen = 0;
                if(len == 0) nextLen = words[endIdx].length();
                else nextLen = len + words[endIdx].length() + 1;
                if(nextLen <= maxWidth){
                    len = nextLen;
                    endIdx++;
                    if(endIdx == words.length) break;
                }else{
                    break;
                }
            }

            int n = endIdx - idx;
            int sumLen = len - n + 1;
            int numSpace = maxWidth - sumLen;
            
            
            StringBuilder sb = new StringBuilder();
            if(endIdx == words.length){
                int endSpace = numSpace - (n-1);

                for(int i = idx; i < endIdx; i++){
                    sb.append(words[i]);
                    if(i != endIdx-1){
                        sb.append(" ");
                    }else{
                        for(int j = 0; j < endSpace; j++) sb.append(" ");
                    }
                }


            }else{
                int avg, remain;
                if(n > 1){
                    avg = numSpace / (n-1);
                    remain = numSpace % (n-1);
                }else{
                    avg = numSpace;
                    remain = 0;
                }

                for(int i = idx; i < endIdx; i++){
                    sb.append(words[i]);
                    if(i != endIdx-1 || n == 1){
                        for(int j = 0; j < avg; j++) sb.append(" ");
                        if(remain > 0) sb.append(" ");
                        remain--;
                    }
                }
            }
            

            res.add(sb.toString());
            idx = endIdx;
        }
        return res;
    }

    public static void main(String[] args) {
        TextJustification test = new TextJustification();
        for(String str : test.fullJustify(new String[] {"Science","is","what","we","understand","well","enough","to","explain", 
        "to","a","computer.","Art","is","everything","else","we","do"}, 20)){
            System.out.println("\"" + str + "\"");
        }
    }

}