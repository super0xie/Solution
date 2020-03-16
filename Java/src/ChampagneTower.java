
public class ChampagneTower {
    
    public double champagneTower(int poured, int row, int col) {
        if(row == 0) return poured >= 1 ? 1 : poured;
        double[] overflow = new double[row+1];
        overflow[0] = poured > 1 ? poured-1 : 0;
        
        for(int i = 1; i < row; i++) {
            for(int j = i+1; j >= 0; j--) {
                double received = overflow[j]/2 + (j > 0 ? overflow[j-1]/2 : 0);
                overflow[j] = received > 1 ? received-1 : 0;
            }
        }
        
        double received = overflow[col]/2 + (col > 0 ? overflow[col-1]/2 : 0);
        return received > 1 ? 1 : received;
    }
    
    public static void main(String[] args) {
        ChampagneTower test = new ChampagneTower();
        System.out.println(test.champagneTower(4, 2, 0));
    }
    
}
