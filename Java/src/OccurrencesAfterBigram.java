import java.util.ArrayList;

public class OccurrencesAfterBigram{

    public String[] findOcurrences(String text, String first, String second) {
        String[] arr = text.split(" ");

        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i < arr.length-2; i++){
            if(arr[i].equals(first) && arr[i+1].equals(second)) res.add(arr[i+2]);
        }

        String[] ret = new String[res.size()];
        for(int i = 0; i < res.size(); i++) ret[i] = res.get(i);
        return ret;
    }

    

}