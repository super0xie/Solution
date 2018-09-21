import java.util.LinkedList;

public class ReadNCharactersGivenRead4IICallmultipletimes extends Reader4 {
    
    private LinkedList<Character> leftover = new LinkedList<Character>();
    
    public int read(char[] buf, int n) {
        int idx = 0;
        while(n > 0) {
            if(leftover.size() > 0) {
                buf[idx++] = leftover.removeFirst();
                n--;
            }else {
                char[] buffer = new char [4];
                int read = read4(buffer);
                
                int i = 0;
                while(n > 0 && i < read) {
                    buf[idx++] = buffer[i++];
                    n--;
                }
                
                if(n == 0 && i < read) {
                    while(i < read) {
                        leftover.addLast(buffer[i++]);
                    }
                }
                
                if(read < 4) break;
            }
        }
        
        return idx;
    }

}
