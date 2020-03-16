
public class CheckIfNandItsDoubleExist {
	
	public boolean checkIfExist(int[] arr) {
        boolean[] exist = new boolean[2001];
        
        for(int i : arr) {
        	if(i * 2 <= 1000 && i * 2 >= -1000 && exist[i*2+1000]) return true;
        	if(i % 2 == 0 && exist[i/2 + 1000]) return true;
        	exist[i+1000] = true;
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		CheckIfNandItsDoubleExist test = new CheckIfNandItsDoubleExist();
		int[] arr = {-778,-481,842,495,44,1000,-572,977,240,-116,673,997,-958,-539,-964,-187,-701,-928,472,965,-672,-88,443,36,388,-127,115,704,-549,1000,998,291,633,423,57,-77,-543,72,328,-938,-192,382,179};
		System.out.println(test.checkIfExist(arr));
	}
	
}
