
public class CountOddNumbersinanIntervalRange {
	public int countOdds(int low, int high) {
        int count = high - low + 1;
        int res = 0;
        if(low % 2 == 1 && count % 2 == 1) res = count / 2 + 1;
        else res = count / 2;
        return res;
    }
}
