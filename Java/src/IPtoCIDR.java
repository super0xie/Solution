import java.util.ArrayList;
import java.util.List;


public class IPtoCIDR {


    public List<String> ipToCIDR(String ip, int n) {
        int start = strToInt(ip);
        List<String> res = new ArrayList<>();
        while(n > 0){
            for(int i = 512, c = 9; i > 0; i = i >>> 1, c--){
                if(start % i == 0 && i <= n){
                    res.add(intToStr(start, c));
                    start += i;
                    n -= i;
                    break;
                }
            }
        }
        return res;
    }

    private int strToInt(String str){
        String[] arr = str.split("\\.");
        int res = 0;
        for(int i = 0; i < 4; i++){
            int n = Integer.parseInt(arr[i]);
            n = n << 24 - 8 * i;
            res = res | n;
        }
        return res;
    }

    private String intToStr(int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++){
            sb.append((n >>> 24 - 8 * i) & 255);
            if(i != 3) sb.append(".");
        }
        return sb.toString();
    }

    private String intToStr(int n, int c){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++){
            sb.append((n >>> 24 - 8 * i) & 255);
            if(i != 3) sb.append(".");
            else {
                sb.append("/" + (33-c));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IPtoCIDR test = new IPtoCIDR();
        // int n = test.strToInt("255.0.0.8");
        // System.out.println(n);
        // System.out.println(Integer.toBinaryString(n));
        // n++;
        // System.out.println(Integer.toBinaryString(n));
        // System.out.print(test.intToStr(n));
        List<String> res = test.ipToCIDR("117.145.102.62", 8);
        for(String str : res){
            System.out.println(str);
        }
    }

}