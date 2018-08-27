
public class DailyTemperatures {
	
    public int[] dailyTemperatures(int[] temperatures) {
        int[] aux = new int [71];
        int[] result = new int [temperatures.length];
        
        for(int i = temperatures.length-1; i >= 0; i--) {
        	int temp = temperatures[i];
        	int index = temp - 30;
        	
        	int min = Integer.MAX_VALUE;
        	for(int j = index+1; j < aux.length; j++) {
        		if(aux[j] != 0 && aux[j] < min) min = aux[j];
        	}
        	
        	if(min != Integer.MAX_VALUE) {
        		result[i] = min - i;
        	}
        	
        	aux[index] = i;
        }
        
        return result;
        
    }
    
}
