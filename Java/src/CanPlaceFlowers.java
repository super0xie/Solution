
public class CanPlaceFlowers {
	
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if(n == 0) return true;
        for(int i = 0; i < flowerbed.length; i++) {
        	if(flowerbed[i] == 1) continue;
        	else {
        		int j = i;
        		while(j < flowerbed.length && flowerbed[j] == 0) j++;
                if(i == 0 && j == flowerbed.length) n-= (j-i+1)/2;
        		else if(i == 0 || j == flowerbed.length) n-= (j-i)/2;
        		else n -= (j-i-1)/2;
        		if(n <= 0) return true;
        		i = j-1;
        	}
        }
        return false;
    }
	
}
