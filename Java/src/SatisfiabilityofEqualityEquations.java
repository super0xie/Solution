public class SatisfiabilityofEqualityEquations{

    public boolean equationsPossible(String[] equations) {
        int[] uf = new int[26];
        for(int i = 0; i < uf.length; i++){
            uf[i] = i;
        }

        for(String str : equations){
            if(str.charAt(1) == '='){
                union(uf, str.charAt(0)-'a', str.charAt(3)-'a');
            }
        }

        for(String str : equations){
            if(str.charAt(1) == '!'){
                int r1 = root(uf, str.charAt(0)-'a');
                int r2 = root(uf, str.charAt(3)-'a');

                if(r1 == r2) return false;
            }
        }

        return true;
    }

    private void union(int[] uf, int i, int j){
        int ri = root(uf, i);
        int rj = root(uf, j);
        if(ri != rj)
            uf[ri] = rj;
    }

    private int root(int[] uf, int i){
        if(uf[i] == i) return uf[i];
        else {
            int r = root(uf, uf[i]);
            uf[i] = r;
            return r;
        }
    }
}