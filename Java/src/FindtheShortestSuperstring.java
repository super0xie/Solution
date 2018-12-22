import java.util.ArrayList;

public class FindtheShortestSuperstring {
	
	public String shortestSuperstring(String[] A) {
		ArrayList<String> l = new ArrayList<>();
		for(String str : A) l.add(str);
		
		while(l.size() > 0) {
			int max = 0;
			int ii = 0;
			int jj = 0;
			String toAdd = "";
			for(int i = 0; i < l.size()-1; i++) {
				for(int j = i+1; j < l.size(); j++) {
					String[] ret = new String[1];
					int match = overlap(l.get(i), l.get(j), ret);
					if(match > max) {
						ii = i;
						jj = j;
						toAdd = ret[0];
						max = match;
					}
				}
			}
			
			if(max == 0) {
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < l.size(); i++) {
					sb.append(l.get(i));
				}
				return sb.toString();
			}else {
				l.remove(jj);
				l.remove(ii);
				l.add(toAdd);
			}
		}
		return l.get(0);
    }
	
	int overlap(String a, String b, String[] ret) {
		int t = a.length() + b.length() - 1;
		int res = 0;
		for(int i = 0; i < t; i++) {
			int aux = 0;
			int j = Math.max(a.length()-1-i, 0);
			int k = 0;
			if(i > a.length()) k = i-a.length()+1;
			while(j < a.length() && k < b.length()) {
				if(a.charAt(j) == b.charAt(k)) {
					j++;
					k++;
					aux++;
				}
				else {
					aux = 0;
					break;
				}
			}
			if(aux > res) {
				StringBuilder sb = new StringBuilder();
				j = Math.max(a.length()-1-i, 0);
				k = 0;
				if(i > a.length()) k = i-a.length()+1;
				if(j > 0) {
					sb.append(a);
					sb.append(b.substring(k+aux));
				}else {
					sb.append(b);
					if(aux < a.length()) sb.append(a.substring(aux));
				}
				ret[0] = sb.toString();
				res = aux;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		FindtheShortestSuperstring test = new FindtheShortestSuperstring();
		String[] A = {"ift","efd","dnete","tef","fdn"};
//		test.overlap("abc", "bcdabcd", ret);
		System.out.println(test.shortestSuperstring(A));
	}

}
