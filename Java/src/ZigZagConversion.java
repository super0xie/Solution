
public class ZigZagConversion {
    
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder [] sbs = new StringBuilder[numRows];
        for(int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        
        int idx = 0;
        boolean down = true;
        for(int i = 0; i < s.length(); i++) {
            sbs[idx].append(s.charAt(i));
            if(idx == numRows - 1 && down) {
                if(idx - 1 >= 0) --idx;
                down = !down;
            }else if(idx == 0 && !down) {
                if(idx + 1 < numRows) ++idx;
                down = !down;
            }else if(down) {
                ++idx;
            }else if(!down) {
                --idx;
            }
        }
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            res.append(sbs[i]);
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        ZigZagConversion test = new ZigZagConversion();
        System.out.println(test.convert("PAYPALISHIRING", 1));
    }
    
}
