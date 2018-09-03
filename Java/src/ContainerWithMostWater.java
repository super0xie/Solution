
public class ContainerWithMostWater {
	

	public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int res = Integer.MIN_VALUE;
        
        while(i < j) {
        	res = Math.max(res, (j-i) * Math.min(height[i], height[j]));
        	
        	if(height[i] < height[j]) i++;
        	else j--;
        }
        return res;
    }
	
	
	
	public static void main(String[] args) {
		int[] height = {10,9,8,7,6,5,4,3,2,1};
		ContainerWithMostWater test = new ContainerWithMostWater();
		System.out.println(test.maxArea(height));
	}
	
}
