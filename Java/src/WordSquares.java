import java.util.ArrayList;
import java.util.List;

public class WordSquares {
	
	private class TrieNode {
		TrieNode [] children;
		List<String> prefix;
		
		TrieNode(){
			children = new TrieNode[26];
			prefix = new ArrayList<String>();
		}
	}
	
	private class Trie {
		TrieNode root;
		List<String> words;
		
		Trie(String[] words) {
			root = new TrieNode();
			this.words = new ArrayList<String>();
			for(String str : words) {
				this.add(str, root, 0);
				this.words.add(str);
			}
		}
		
		void add(String str, TrieNode node, int idx) {
			if(node.children[str.charAt(idx) - 'a'] == null) {
				TrieNode n = new TrieNode();
				node.children[str.charAt(idx) - 'a'] = n;
				n.prefix.add(str);
			}else {
				node.children[str.charAt(idx) - 'a'].prefix.add(str);
			}
			if(idx < str.length()-1)
				add(str, node.children[str.charAt(idx) - 'a'], idx+1);
		}
		
		List<String> prefix(String str){
			if(str.length() == 0) return words;
			return prefix(str, root, 0);
		}
		
		List<String> prefix(String str, TrieNode node, int idx){
			if(node.children[str.charAt(idx) - 'a'] == null) return null;
			
			if(idx == str.length()-1) {
				return node.children[str.charAt(idx) - 'a'].prefix;
			}else {
				return prefix(str, node.children[str.charAt(idx) - 'a'], idx+1);
			}
		}
	}
	
	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> aux = new ArrayList<String>();
		Trie trie = new Trie(words);
		int n = words[0].length();
		
		
		dfs(aux, n , res, trie);
		
		return res;
		
    }
	
	private void dfs(List<String> list, int n, List<List<String>> res, Trie trie) {
		
		String prefix = "";
		int size = list.size();
		
		if(list.size() > 0) {
			for(String str : list) {
				prefix = prefix + str.charAt(size);
			}
		}
		
		List<String> candidate = trie.prefix(prefix);
		if(candidate == null) return;
		else {
			for(String str : candidate) {
				if(size == n-1) {
					List<String> oneRes = new ArrayList<String>(list);
					oneRes.add(str);
					res.add(oneRes);
				}else {
					list.add(str);
					dfs(list, n, res, trie);
					list.remove(list.size()-1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String[] words = {"a", "b"};
		WordSquares test = new WordSquares();
		test.wordSquares(words);
	}

}
