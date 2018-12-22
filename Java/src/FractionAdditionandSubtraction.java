
public class FractionAdditionandSubtraction {
	
	public String fractionAddition(String exp) {
        int num = 0;
        int dom = 1;
        int i = 0;
        while(i < exp.length()) {
        	int pos = 1;
        	if(exp.charAt(i) == '+' || exp.charAt(i) == '-') {
        		if(exp.charAt(i) == '-') pos = -1;
        		i++;
        	}
        	
        	int j = i;
        	while(exp.charAt(j) != '/') j++;
        	int curNum = Integer.parseInt(exp.substring(i, j));
        	
        	int k = j+1;
        	while(k < exp.length() && exp.charAt(k) != '+' && exp.charAt(k) != '-') k++;
        	int curDom = Integer.parseInt(exp.substring(j+1, k));
        	i = k;
        	
        	int newDom = lcm(dom, curDom);
        	num = num * (newDom / dom) + pos * curNum * (newDom / curDom);
        	
        	int aux = gcd(newDom, Math.abs(num));
        	num = num / aux;
        	dom = newDom / aux;
        }
        
        return num + "/" + dom;
    }
	
	private int lcm(int a, int b) {
		if(a >= b) return a * b / gcd(a, b);
		else return a * b / gcd(b, a);
	}
	
	private int gcd(int a, int b) {
		while(b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
	
	public static void main(String[] args) {
		FractionAdditionandSubtraction test = new FractionAdditionandSubtraction();
		System.out.println(test.fractionAddition("5/3+1/3"));
	}
	
}
