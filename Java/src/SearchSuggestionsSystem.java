import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {
	
	class Node {
		Node[] next;
		ArrayList<String> words;
		Node(){
			next = new Node[26];
			words = new ArrayList<>();
		}
	}
	
	
	private Node root;
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		root = new Node();
        Arrays.sort(products);
        for(String str : products) add(root, 0, str);
        
        List<List<String>> res = new ArrayList<>();
        search(root, 0, searchWord, res);
        return res;
    }
	
	private void add(Node n, int i, String str) {
		if(i == str.length()) return;
		if(n.next[str.charAt(i)-'a'] == null) n.next[str.charAt(i)-'a'] = new Node();
		if(n.next[str.charAt(i)-'a'].words.size() < 3)
			n.next[str.charAt(i)-'a'].words.add(str);
		add(n.next[str.charAt(i)-'a'], i+1, str);
	}
	
	private void search(Node n, int i, String str, List<List<String>> res) {
		if(i == str.length()) return;
		if(n == null || n.next[str.charAt(i)-'a'] == null) {
			res.add(new ArrayList<>());
			search(null, i+1, str, res);
		} else {
			res.add(n.next[str.charAt(i)-'a'].words);
			search(n.next[str.charAt(i)-'a'], i+1, str, res);
		}
	}
	
	public static void main(String[] args) {
		SearchSuggestionsSystem test = new SearchSuggestionsSystem();
		String[] products = {"bags","baggage","banner","box","cloths"};
		List<List<String>> res = test.suggestedProducts(products, "bags");
		for(List<String> words : res) {
			System.out.print(":");
			for(String str : words) {
				System.out.print(str + ",");
			}
			System.out.print("\n");
		}
	}
	
}
