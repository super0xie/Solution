
public class SolvetheEquation {
    
    
    
    public String solveEquation(String e) {
        int eqIdx = e.indexOf('=');
        
        //ax + b = 0
        int a = 0;
        int b = 0;
        
        int i = 0;
        boolean afterEqual = false;
        while(i < e.length()) {
            boolean pos = true;
            
            if(e.charAt(i) == '=') {
                afterEqual = true;
                i++;
                continue;
            }
            
            if(e.charAt(i) == '+' || e.charAt(i) == '-') {
                if(!afterEqual && e.charAt(i) == '-') pos = false;
                if(afterEqual && e.charAt(i) == '+') pos = false;
                i++;
            }else if(i > eqIdx) pos = false;
            
            int n = 0;
            
            if(e.charAt(i) == 'x') {
                if(pos) a++;
                else a--;
                i++;
            } else {
                int j = i;
                while(j < e.length() && e.charAt(j) <= '9' && e.charAt(j) >= '0') j++;
                n = Integer.parseInt(e.substring(i, j));
                i = j;
                
                if(j < e.length() && e.charAt(j) == 'x') {
                    if(pos) a += n;
                    else a -= n;
                    i++;
                }else {
                    if(pos) b += n;
                    else b -= n;
                }
            }
            
        }
        
        if(a == 0 && b != 0) return "No solution";
        if(a == 0 && b == 0) return "Infinite solutions";
        
        
        int res = -b/a;
        return "x=" + String.valueOf(res);
    }
    
    public static void main(String[] args) {
        SolvetheEquation test = new SolvetheEquation();
        System.out.println(test.solveEquation("x=x+2"));
    }
    
}
