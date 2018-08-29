import java.util.HashMap;

public class SentenceSimilarityII {
	
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
    	if(words1.length != words2.length) return false;
        int index = 0;
        HashMap<String, Integer> indice = new HashMap<String, Integer>();
        for(int i = 0; i < pairs.length; i++) {
        	if(!indice.containsKey(pairs[i][0])) {
        		indice.put(pairs[i][0], index);
        		index++;
        	}
        	
        	if(!indice.containsKey(pairs[i][1])) {
        		indice.put(pairs[i][1], index);
        		index++;
        	}
        }
        
        int [] uf = new int [index];
        for(int i = 0; i < uf.length; i++) {
        	uf[i] = i;
        }
        
        for(int i = 0; i < pairs.length; i++) {
        	int indexL = indice.get(pairs[i][0]);
        	int indexR = indice.get(pairs[i][1]);
        	int rootL = getRoot(uf, indexL);
        	int rootR = getRoot(uf, indexR);
        	uf[rootR] = rootL;
        }
        
        for(int i = 0; i < words1.length; i++) {
        	if(words1[i].equals(words2[i])) continue;
        	if(!indice.containsKey(words1[i]) || !indice.containsKey(words2[i])) return false;
        	
        	int indexL = indice.get(words1[i]);
        	int indexR = indice.get(words2[i]);
        	if(getRoot(uf, indexL) != getRoot(uf, indexR)) return false;
        }
        
        return true;
        
    }
    
    
    private int getRoot(int[] uf, int index) {
    	
    	if(uf[index] == index) return index;
    	else {
    		int result = getRoot(uf, uf[index]);
    		uf[index] = result;
    		return result;
    	}
    }
    
    public static void main(String[] args) {
    	String[] words1 = {"this","summer","thomas","get","really","very","rich","and","have","any","actually","wonderful","and","good","truck","every","morning","he","drives","an","extraordinary","truck","around","the","nice","city","to","eat","some","extremely","extraordinary","food","as","his","meal","but","he","only","entertain","an","few","well","fruits","as","single","lunch","he","wants","to","eat","single","single","and","really","healthy","life"};
    	String[] words2 = {"this","summer","thomas","get","very","extremely","rich","and","possess","the","actually","great","and","wonderful","vehicle","every","morning","he","drives","unique","extraordinary","automobile","around","unique","fine","city","to","drink","single","extremely","nice","meal","as","his","super","but","he","only","entertain","a","few","extraordinary","food","as","some","brunch","he","wants","to","take","any","some","and","really","healthy","life"};
    	String[][] pairs = {{"good","wonderful"},{"nice","well"},{"fine","extraordinary"},{"excellent","good"},{"wonderful","nice"},{"well","fine"},{"extraordinary","excellent"},{"great","wonderful"},{"one","the"},{"a","unique"},{"single","some"},{"an","one"},{"the","a"},{"unique","single"},{"some","an"},{"any","the"},{"car","wagon"},{"vehicle","car"},{"auto","vehicle"},{"automobile","auto"},{"wagon","automobile"},{"truck","wagon"},{"have","have"},{"take","take"},{"eat","eat"},{"drink","drink"},{"entertain","entertain"},{"meal","food"},{"lunch","breakfast"},{"super","brunch"},{"dinner","meal"},{"food","lunch"},{"breakfast","super"},{"brunch","dinner"},{"fruits","food"},{"own","own"},{"have","have"},{"keep","keep"},{"possess","own"},{"very","very"},{"super","super"},{"really","really"},{"actually","actually"},{"extremely","extremely"}};
    	SentenceSimilarityII test = new SentenceSimilarityII();
    	System.out.println(test.areSentencesSimilarTwo(words1, words2, pairs));
    }
}
