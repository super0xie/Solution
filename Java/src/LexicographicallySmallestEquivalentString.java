
public class LexicographicallySmallestEquivalentString {

    public String smallestEquivalentString(String A, String B, String S) {
        int[] uf = new int[26];
        for(int i = 0; i < uf.length; i++) uf[i] = i;
        for(int i = 0; i < A.length(); i++){
            union(uf, A.charAt(i)-'a', B.charAt(i)-'a');
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            sb.append((char)('a' + getRoot(uf, S.charAt(i)-'a')));
        }

        return sb.toString();
    }

    private int getRoot(int[] uf, int i){
        if(uf[i] == i) return i;
        else{
            int r = getRoot(uf, uf[i]);
            uf[i] = r;
            return r;
        }
    }

    private void union(int[] uf, int i, int j){
        int r1 = getRoot(uf, i);
        int r2 = getRoot(uf, j);

        if(r1 != r2){
            if(r1 < r2){
                uf[r2] = r1;
            }else{
                uf[r1] = r2;
            }
        }
    }

    public static void main(String[] args) {
        LexicographicallySmallestEquivalentString test = new LexicographicallySmallestEquivalentString();
        System.out.println(test.smallestEquivalentString("parker", "morris", "parser"));
        
    }

}
