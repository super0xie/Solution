
public class Trie {
	private class TrieNode{
		TrieNode[] next;
		boolean end;
		TrieNode(){
			next = new TrieNode [26];
			end = false;
		}

	}
	
	TrieNode root;
	
	public Trie() {
        root = new TrieNode();
    }
	
	public void insert(String word) {
        char[] chars = word.toCharArray();
        insertHelper(root, chars, 0);
        
    }
	
	private void insertHelper(TrieNode node, char[] chars, int index) {
		char c = chars[index];
		if(node.next[c-'a'] == null) {
			node.next[c-'a'] = new TrieNode();
		}
		
		if(index == chars.length-1) {
			node.next[c-'a'].end = true;
		}else {
			insertHelper(node.next[c-'a'], chars, index+1);
		}
		
	}
	
	public boolean search(String word) {
		char[] chars = word.toCharArray();
		return searchHelper(root, chars, 0);
    }
	
	private boolean searchHelper(TrieNode node, char[] chars, int index) {
		char c = chars[index];
		
		TrieNode n = node.next[c-'a'];
		if(n == null) return false;
		if(index == chars.length - 1) return n.end;
		
		
		return searchHelper(n, chars, index+1);
	}
	
	public boolean startsWith(String prefix) {
		char[] chars = prefix.toCharArray();
		return startsWithHelper(root, chars, 0);
    }
	
	private boolean startsWithHelper(TrieNode node, char[] chars, int index) {
		char c = chars[index];
		TrieNode n = node.next[c-'a'];
		
		if(n == null) return false;
		if(index == chars.length - 1) return true;
		return startsWithHelper(n, chars, index+1);

	}
	
	public static void main(String [] args) {
		Trie trie = new Trie();
		trie.insert("apple");
	}
	
	

}
