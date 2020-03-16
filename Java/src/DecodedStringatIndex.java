import java.util.ArrayList;

public class DecodedStringatIndex {

    public String decodeAtIndex(String S, int K) {
        ArrayList<Long> len = new ArrayList<>();
        ArrayList<Integer> numOfRepeat = new ArrayList<>();
        ArrayList<String> strs = new ArrayList<>();
        long idx = (long)(K-1);
        if(!isDigit(S.charAt(S.length()-1))) S = S + '1';
        long curLen = 0;
        int lastDigit = -1;
        for(int i = 0; i < S.length(); i++){
            if(!isDigit(S.charAt(i))) curLen++;
            else {
                strs.add(S.substring(lastDigit+1, i));
                lastDigit = i;
                len.add(curLen);
                int n = S.charAt(i)-'0';
                numOfRepeat.add(n);
                curLen *= n;
            }
        }

        int i = len.size()-1;
        for(; i >= 0; i--){
            idx = idx % len.get(i);
            if(i > 0 && idx >= len.get(i-1) * numOfRepeat.get(i-1) && idx < len.get(i)){
                break;
            }
            if(i == 0) break;
        }

        if(i > 0){
            idx -= len.get(i-1) * numOfRepeat.get(i-1);
        }

        return "" + strs.get(i).charAt((int)idx);
    }

    private boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        DecodedStringatIndex test = new DecodedStringatIndex();
        System.out.print(test.decodeAtIndex("a2345678999999999999999", 1));
        // System.out.print(-1%1);
    }

}