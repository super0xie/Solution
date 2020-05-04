
public class NumberofStepstoReduceaNumberinBinaryRepresentationtoOne {
	
	public int numSteps(String s) {
		if(s.contentEquals("1")) return 0;
        char[] str = s.toCharArray();
        
        char[] arr = new char[s.length()+1];
        System.arraycopy(str, 0, arr, 1, str.length);
        arr[0] = '0';
        int res = 0;
        int j = arr.length-1;
        
        while(true) {
        	if(arr[j] == '1') {
        		arr[j] = '0';
        		int k = j-1;
        		while(arr[k] == '1') {
        			arr[k] = '0';
        			k--;
        		}
        		arr[k] = '1';
        	}else {
        		j--;
        	}
        	res++;
        	
        	if(j == 0 || (arr[0] == '0' && j == 1)) break;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		NumberofStepstoReduceaNumberinBinaryRepresentationtoOne test = new NumberofStepstoReduceaNumberinBinaryRepresentationtoOne();
		System.out.println(test.numSteps("1"));
	}
	
}
