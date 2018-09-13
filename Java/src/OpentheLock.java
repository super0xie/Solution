import java.util.HashSet;
import java.util.LinkedList;

public class OpentheLock {
	
	public int openLock(String[] deadends, String target) {
		HashSet<String> queue = new HashSet<String>();
		HashSet<String> visited = new HashSet<String>();
		
		for(String str : deadends) visited.add(str);
		if(!visited.contains("0000"))
			queue.add("0000");
		int count = 0;
		while(!queue.isEmpty()) {
			HashSet<String> aux = new HashSet<String>();
			
			for(String poped : queue) {
				visited.add(poped);
				if(poped.equals(target)) return count;
				else {
					char[] chars = poped.toCharArray();
					
					for(int i = 0; i < poped.length(); i++) {
						char saved = chars[i];
						chars[i] = (char) (chars[i] == '9' ? '0' : chars[i]+1);
						String str = String.valueOf(chars);
						if(!visited.contains(str)) {
							aux.add(str);
						}
						chars[i] = saved;
						chars[i] = (char) (chars[i] == '0' ? '9' : chars[i]-1);
						str = String.valueOf(chars);
						if(!visited.contains(str)) {
							aux.add(str);
						}
						chars[i] = saved;
					}
				}
			}
			
			queue = aux;
			count++;
		}
		
		return -1;
        
    }
	
	public static void main(String[] args) {
		OpentheLock test = new OpentheLock();
		String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
		String target = "8888";
		System.out.println(test.openLock(deadends, target));
	}

}
