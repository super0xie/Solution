import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PeopleWhoseListofFavoriteCompaniesIsNotaSubsetofAnotherList {
	
	public List<Integer> peopleIndexes(List<List<String>> f) {
		List<Integer> res = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		
		List<List<Integer>> l = new ArrayList<>();
		
		for(int i = 0; i < f.size(); i++) {
			List<Integer> cur = new ArrayList<>();
			for(String s : f.get(i)) {
				if(!map.containsKey(s)) map.put(s, map.size());
				cur.add(map.get(s));
			}
			l.add(cur);
		}
		
		int n = map.size();
		boolean[][] mat = new boolean[f.size()][map.size()];
		
		for(int i = 0; i < l.size(); i++) {
			for(int j : l.get(i)) {
				mat[i][j] = true;
			}
		}
		
		for(int i = 0; i < mat.length; i++) {
			int j = 0;
			for(; j < mat.length; j++) {
				if(j == i) continue;
				int k = 0;
				for(; k < n; k++) {
					if(mat[i][k] && !mat[j][k]) break;
				}
				if(k == n) break;
			}
			if(j == mat.length) res.add(i);
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		PeopleWhoseListofFavoriteCompaniesIsNotaSubsetofAnotherList test = new PeopleWhoseListofFavoriteCompaniesIsNotaSubsetofAnotherList();
		List<Integer> res = test.peopleIndexes(Arrays.asList(Arrays.asList("leetcode","google","facebook"), Arrays.asList("google","microsoft"), Arrays.asList("google","facebook"), Arrays.asList("google"), Arrays.asList("amazon")));
		for(int i : res) System.out.println(i);
	}
	
}
