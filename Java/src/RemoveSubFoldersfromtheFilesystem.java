import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RemoveSubFoldersfromtheFilesystem {
	
	class Node{
		HashMap<String, Node> map;
		boolean isEnd = false;
		Node(){
			map = new HashMap<>();
		}
	}
	
	private Node root = new Node();
	
	private boolean add(Node n, String[] strs, int i) {
		
		if(n.map.containsKey(strs[i])) {
			if(n.map.get(strs[i]).isEnd) return false;
			return add(n.map.get(strs[i]), strs, i+1);
		}else {
			Node node = new Node();
			n.map.put(strs[i], node);
			if(i == strs.length-1) {
				node.isEnd = true;
				return true;
			} else {
				return add(node, strs, i+1);
			}
		}
	}
	
	public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder, (a, b)->{return a.length()-b.length();});
        for(int i = 0; i < folder.length; i++)
        	if(add(root, folder[i].split("/"), 0)) res.add(folder[i]);
        return res;
    }
	
	public static void main(String[] args) {
		RemoveSubFoldersfromtheFilesystem test = new RemoveSubFoldersfromtheFilesystem();
		List<String> res = test.removeSubfolders(new String[] {"/a/b/c","/a/b/ca","/a/b/d"});
		for(String str : res) System.out.println(str);
	}
}
