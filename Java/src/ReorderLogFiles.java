import java.util.Arrays;

public class ReorderLogFiles {
	
	class Entry implements Comparable<Entry>{
		String org;
		boolean letter;
		String id;
		String rest;
		
		Entry(String org){
			this.org = org;
			String[] arr = org.split(" ", 2);
			this.id = arr[0];
			this.rest = arr[1];
			if(rest.charAt(0) <= '9' && rest.charAt(0) >= '0') this.letter = false;
			else this.letter = true;
		}

		@Override
		public int compareTo(Entry o) {
			if(this.letter && o.letter) {
				int cmp = this.rest.compareTo(o.rest);
				if(cmp == 0) {
					return this.id.compareTo(o.id);
				}else {
					return cmp;
				}
			}else if(this.letter && !o.letter) {
				return -1;
			}else if(!this.letter && o.letter) {
				return 1;
			}else {
				return 0;
			}
		}

		
	}
	
	public String[] reorderLogFiles(String[] logs) {
        Entry[] entries = new Entry[logs.length];
        for(int i = 0; i < logs.length; i++) {
        	entries[i] = new Entry(logs[i]);
        }
        Arrays.sort(entries);
        String[] res = new String[logs.length];
        for(int i = 0; i < logs.length; i++) {
        	res[i] = entries[i].org;
        }
        return res;
    }
	
	public static void main(String[] args) {
		ReorderLogFiles test = new ReorderLogFiles();
		String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
		String[] res = test.reorderLogFiles(logs);
		System.out.println("hehje ");
	}
}
