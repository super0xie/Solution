import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class WordSearchII {
    
    private class TrieNode {
        TrieNode [] children;
        boolean isEnd;
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    private class Trie {
        TrieNode root;
        
        Trie(String[] words) {
            root = new TrieNode();
            for(String str : words) {
                this.add(str, root, 0);
            }
        }
        
        void add(String str, TrieNode node, int idx) {
            if(node.children[str.charAt(idx) - 'a'] == null) {
                TrieNode n = new TrieNode();
                node.children[str.charAt(idx) - 'a'] = n;
            }
            if(idx < str.length()-1)
                add(str, node.children[str.charAt(idx) - 'a'], idx+1);
            else
                node.children[str.charAt(idx) - 'a'].isEnd = true;
        }
        //-1 no, 1 prefix, 0 match
        int search(String str) {
            return searchHelper(str, 0, root);
        }
        
        int searchHelper(String str, int idx, TrieNode n) {
            if(n.children[str.charAt(idx)-'a'] == null) return -1;
            if(idx == str.length()-1) {
                if(n.children[str.charAt(idx)-'a'].isEnd) return 0;
                else return 1;
            }else {
                return searchHelper(str, idx+1, n.children[str.charAt(idx)-'a']);
            }
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie(words);
        HashSet<String> res = new HashSet<String>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(i, j, visited, "", res, trie, board);
            }
        }
        
        List<String> ret = new ArrayList<String>();
        for(String str : res) {
            ret.add(str);
        }
        return ret;
    }
    
    private void dfs(int i, int j, boolean[][] visited, String cur, HashSet<String> res, Trie trie, char[][] board) {
        visited[i][j] = true;
        String current = cur + board[i][j];
        
        int search = trie.search(current);
        if(search >= 0) {
            if(search == 0) res.add(current);
            if(i > 0 && !visited[i-1][j]) dfs(i-1, j, visited, current, res, trie, board);
            if(i < board.length-1 && !visited[i+1][j]) dfs(i+1, j, visited, current, res, trie, board);
            if(j > 0 && !visited[i][j-1]) dfs(i, j-1, visited, current, res, trie, board);
            if(j < board[0].length-1 && !visited[i][j+1]) dfs(i, j+1, visited, current, res, trie, board);
        }
        
        visited[i][j] = false;
        
    }
    
    public static void main(String[] args) {
        WordSearchII test = new WordSearchII();
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
              };
        String[] words = {"oath","pea","eat","rain"};
        test.findWords(board, words);
    }

}
