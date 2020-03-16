public class MirrorReflection{
    // h : horizontal travel distance  v : vertical travel distance
    // p / q = h / v
    // h * q = p * v
    public int mirrorReflection(int p, int q) {
        int h = p;
        int v = q;

        while(h % 2 == 0 && v % 2 == 0){
            h = h >> 1;
            v = v >> 1;
        }

        if(h % 2 == 0) return 2;
        if(v % 2 == 0) return 0;
        else return 1;
    }

}