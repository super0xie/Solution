import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveInterval {
	
	public List<List<Integer>> removeInterval(int[][] intervals, int[] tbr) {
		
		List<List<Integer>> res = new ArrayList<>();
		for(int[] inter : intervals) {
			if(inter[1] <= tbr[0] || inter[0] >= tbr[1]) res.add(Arrays.asList(inter[0], inter[1]));
			else if(inter[0] < tbr[0] && inter[1] > tbr[1]) {
				res.add(Arrays.asList(inter[0], tbr[0]));
				res.add(Arrays.asList(tbr[1], inter[1]));
			}else if(inter[0] < tbr[0] && inter[1] > tbr[0]) {
				res.add(Arrays.asList(inter[0], tbr[0]));
			}else if(inter[0] < tbr[1] && inter[1] > tbr[1]) {
				res.add(Arrays.asList(tbr[1], inter[1]));
			}
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		RemoveInterval test = new RemoveInterval();
		int[][] intervals = {{0,2},{3,4},{5,7}};
		int[] tbr = {1,6};
		List<List<Integer>> res = test.removeInterval(intervals, tbr);
		for(List<Integer> r : res) {
			System.out.println(r.get(0) + ", " + r.get(1));
		}
	}
	
}
