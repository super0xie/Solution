
public class ReadNCharactersGivenRead4 extends Reader4{
	
	public int read(char[] buf, int n) {
		int index = 0;
		while(n > 0) {
			char[] buffer = new char[4];
			int read = read4(buffer);
			
			int i = 0;
			while(n > 0 && i < read) {
				buf[index++] = buffer[i++];
				n--;
			}
			
			if(read < 4)
				break;
		}
		
		return index;
    }

}
