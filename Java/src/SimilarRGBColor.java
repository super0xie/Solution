import java.util.Arrays;

public class SimilarRGBColor {
    
    public String similarRGB(String color) {
        int [] shortArray = {0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x88, 0x99, 0xaa, 0xbb, 0xcc, 0xdd, 0xee, 0xff};
        String [] shortStrArray = {"00", "11", "22", "33", "44", "55", "66", "77", "88", "99", "aa", "bb", "cc", "dd", "ee", "ff"};
        
        String res = "#";
        
        for(int i = 1; i <= 5; i=i+2) {
            String str = color.substring(i, i+2);
            int val = Integer.parseInt(str, 16);
            int ip = Arrays.binarySearch(shortArray, val);
            int target = 0;
            if(ip >= 0) {
                target = ip;
            }else {
                ip = -ip-1;
                target = shortArray[ip]-val <= val -shortArray[ip-1] ? ip : ip-1;
            }
            res += shortStrArray[target];
        }
        
        return res;
        
        
    }
    
    public static void main(String[] args) {
        SimilarRGBColor test = new SimilarRGBColor();
        System.out.println(test.similarRGB("#09f166"));
    }

}
