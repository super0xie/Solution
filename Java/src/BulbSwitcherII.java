
public class BulbSwitcherII {
	public int flipLights(int n, int m) {
		if(m == 0) return 1;
        if(n == 1) return 2;
        else if(n ==2 ) {
        	if(m <= 1) return 3;
        	else return 4;
        }
        else{
        	if(m == 1) return 4;
        	if(m == 2) return 7;
        	else return 8;
        }
    }
}
