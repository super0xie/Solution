
public class ConverttoBase2 {
	
	private int[][] aux = {{1,1},{-2,-1},{2,5},{-10,-3},{6,21},{-42,-11},{22,85},{-170,-43},{86,341},{-682,-171},{342,1365},{-2730,-683},{1366,5461},{-10922,-2731},{5462,21845},{-43690,-10923},{21846,87381},{-174762,-43691},{87382,349525},{-699050,-174763},{349526,1398101},{-2796202,-699051},{1398102,5592405},{-11184810,-2796203},{5592406,22369621},{-44739242,-11184811},{22369622,89478485},{-178956970,-44739243},{89478486,357913941},{-715827882,-178956971},{357913942,1431655765}};
	
	public String baseNeg2(int N) {
		if(N == 0) return "0";
        int n = 1 << 30;
        boolean start = false;
        StringBuilder sb = new StringBuilder();
        
        for(int i = aux.length-1; i >= 0; i--) {
        	if(N >= aux[i][0] && N <= aux[i][1]) {
        		start = true;
        		sb.append(1);
        		if(i % 2 == 0) N -= n;
        		else N += n;
        	}else {
        		if(start) sb.append(0);
        	}
        	
        	n = n >>> 1;
        }
        
        return sb.toString();
        
    }
	
	public static void main(String[] args) {
//		int[][] aux = new int[31][2];
//		aux[0][0] = 1;
//		aux[0][1] = 1;
//		aux[1][0] = -2;
//		aux[1][1] = -1;
//		
//		int n = 4;
//		for(int i = 2; i <= 30; i++) {
//			if(i % 2 == 0) {
//				aux[i][0] = n + aux[i-1][0];
//				aux[i][1] = n + aux[i-2][1];
//			}else {
//				aux[i][0] = n + aux[i-2][0];
//				aux[i][1] = n + aux[i-1][1];
//			}
//			n = n << 1;
//			n = -n;
//		}
//		
//		for(int[] arr : aux) {
//			System.out.print("{" + arr[0] + "," + arr[1] + "},");
//		}
		ConverttoBase2 test = new ConverttoBase2();
		System.out.println(test.baseNeg2(12));
	}
	
}
