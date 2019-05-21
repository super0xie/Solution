import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DesignInMemoryFileSystem {

    class Node{
        boolean isFile;
        HashMap<String, Node> next;
        StringBuilder sb;
        Node(){
            next = new HashMap<>();
        }
    }

    private Node root;
    public void FileSystem() {
        root = new Node();
        root.next.put("", new Node());
    }
    
    private List<String> ls(Node n, int idx, String[] path){
        if(idx == path.length){
            List<String> res = new ArrayList<>();
            if(n.isFile) res.add(path[path.length-1]);
            else{
                for(String key : n.next.keySet()) res.add(key);
                Collections.sort(res);
            }
            return res;
        }else{
            if(n.next.containsKey(path[idx])){
                return ls(n.next.get(path[idx]), idx+1, path);
            }else{
                return null;
            }
        }
    }

    public List<String> ls(String path) {
    	if(path.length() == 1) return ls(root, 0, new String[] {""});
        return ls(root, 0, path.split("/"));
    }

    private void mkdir(Node n, int idx, String[] path){
        if(idx == path.length) return;
        if(!n.next.containsKey(path[idx])) n.next.put(path[idx], new Node());
        mkdir(n.next.get(path[idx]), idx+1, path);
    }
    
    public void mkdir(String path) {
        mkdir(root, 0, path.split("/"));
    }

    private void addContentToFile(Node n, int idx, String[] path, String content){
        if(idx == path.length){
            n.isFile = true;
            if(n.sb == null) n.sb = new StringBuilder();
            n.sb.append(content);
        }else{
            if(!n.next.containsKey(path[idx])) n.next.put(path[idx], new Node());
            addContentToFile(n.next.get(path[idx]), idx+1, path, content);
        }
    }

    public void addContentToFile(String filePath, String content) {
        addContentToFile(root, 0, filePath.split("/"), content);
    }
    
    private String readContentFromFile(Node n, int idx, String[] path){
        if(idx == path.length){
            return n.sb.toString();
        }else{
            return readContentFromFile(n.next.get(path[idx]), idx+1, path);
        }
    }

    public String readContentFromFile(String filePath) {
        return readContentFromFile(root, 0, filePath.split("/"));
    }

    public static void main(String[] args) {
        DesignInMemoryFileSystem test = new DesignInMemoryFileSystem();
        test.FileSystem();
        List<String> res = test.ls("/");
        for(String str : res) System.out.println(str);
        test.mkdir("/a/b/c");
        test.addContentToFile("/a/b/c/d","hello");
        res = test.ls("/");
        for(String str : res) System.out.println(str);
        System.out.println(test.readContentFromFile("/a/b/c/d"));
    }

}