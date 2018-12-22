
public class BinaryNumberwithAlternatingBits {
    
    public boolean hasAlternatingBits(int n) {
        int last = n%2;
        n = n >> 1;
        while(n > 0) {
            if(n%2 == last) return false;
            last = n%2;
            n = n >> 1;
        }
        return true;
    }
    
}
