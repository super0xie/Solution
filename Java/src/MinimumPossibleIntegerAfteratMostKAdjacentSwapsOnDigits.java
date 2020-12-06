import java.util.ArrayDeque;
import java.util.ArrayList;

public class MinimumPossibleIntegerAfteratMostKAdjacentSwapsOnDigits {
	
	public String minIntegerOld(String num, int k) {
        char[] chars = num.toCharArray();
        for(int i = 0; i < chars.length; i++) {
        	if(k == 0) break;
        	char min = chars[i];
        	int minIdx = i;
        	for(int j = i+1; j <= Math.min(i+k, chars.length-1); j++) {
        		if(min == '0') break;
        		if(chars[j] < min) {
        			min = chars[j];
        			minIdx = j;
        		}
        	}
        	
        	for(int j = minIdx; j > i; j--) {
        		chars[j] = chars[j-1];
        	}
        	chars[i] = min;
        	k -= minIdx-i;
        }
        
        return String.valueOf(chars);
    }
	
	
	
	public String minIntegerStillBad(String num, int k) {
        char[] chars = num.toCharArray();
        ArrayList<Integer>[] idx = new ArrayList[10];
        for(int i = 0; i < 10; i++) idx[i] = new ArrayList<>();
        int[] start = new int[10];
        for(int i = 0; i < chars.length; i++) {
        	idx[chars[i]-'0'].add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++) {
        	char min = Character.MAX_VALUE;
        	int minIdx = -1;
        	for(int j = 0; j <= 9; j++) {
        		char cur = (char)('0'+j);
        		if(cur < min) {
        			if(start[j] < idx[j].size() && idx[j].get(start[j]) <= i+k) {
        				min = cur;
        				minIdx = idx[j].get(start[j]);
        				start[j]++;
        				
        				for(int l = 0; l <= 9; l++) {
        					if(l == j) continue;
        					for(int m = start[l]; m < idx[l].size(); m++) {
        						if(idx[l].get(m) < minIdx) idx[l].set(m, idx[l].get(m)+1);
        						else break;
        					}
        				}
        				break;
        			}
        		}else {
        			break;
        		}
        	}
        	sb.append(min);
        	k -= minIdx-i;
        }
        
        return sb.toString();
    }
	
	
	public static void main(String[] args) {
		MinimumPossibleIntegerAfteratMostKAdjacentSwapsOnDigits test = new MinimumPossibleIntegerAfteratMostKAdjacentSwapsOnDigits();
		String num = TestcaseFileReader.getString();
//		System.out.println(test.minInteger(num, 1000000000));
	}
	
}
