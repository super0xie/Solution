import java.util.Arrays;

public class ValidBoomerang {
	
	public boolean isBoomerang(int[][] p) {
        Arrays.sort(p, (a, b)->{
        	if(a[0] != b[0]) return a[0]-b[0];
        	else return a[1]-b[1];
        });
        
        for(int i = 0; i < p.length-1; i++) {
        	if(p[i][0] == p[i+1][0] && p[i][1] == p[i+1][1]) return false;
        }
        
        if(p[0][0] == p[1][0]) {
        	if(p[2][0] == p[0][0]) return false;
        	else return true;
        }else {
        	if(p[1][0] == p[2][0]) return true;
        	float f1 = (float)(p[1][1]-p[0][1]) / (p[1][0]-p[0][0]);
        	float f2 = (float)(p[2][1]-p[1][1]) / (p[2][0]-p[1][0]);
        	if(f1 == f2) return false;
        	return true;
        }
    }
	
}
