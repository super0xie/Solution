
public class TrappingRainWater {
    
    
    public int trapV0(int[] height) {
        if(height.length < 2) return 0;
        
        int [] water = new int [height.length];
        
        int start = -1;
        int end = -1;
        int result = 0;
        
        for(int i = 0; i < height.length; i++) {
            if(start < 0) {
                if(i < height.length-1 && height[i] > height[i+1]) start = i;
            }else {
                if(height[i] > height[i-1]) {
                    end = i;
                    int newLevel = Math.min(height[start], height[end]);
                    
                    for(int j = start; j <= end; j++) {
                        if(newLevel > water[j])
                            water[j] = newLevel;
                    }

                    if(height[end] >= height[start]) {
                        start = end;
                    }
                }

            }
        }
        
        for(int i = 0; i < height.length; i++) {
            if(water[i] > height[i])
                result += water[i] - height[i];
        }
        
        return result;

    }
    
    public int trap(int[] height) {
        if(height.length < 2) return 0;
        
        int [] leftMax = new int [height.length];
        int [] rightMax = new int [height.length];
        int [] water = new int [height.length];
        int result = 0;
        
        
        int max = 0;
        for(int i = 0; i < height.length; i++) {
            if(height[i] > max) max = height[i];
            leftMax[i] = max;
        }
        max = 0;
        for(int i = height.length-1; i >= 0; i--) {
            if(height[i] > max) max = height[i];
            rightMax[i] = max;
        }
        
        for(int i = 0; i < height.length; i++) {
            water[i] = Math.min(leftMax[i], rightMax[i]);
            if(water[i] > height[i])
                result += water[i] - height[i];
        }

        return result;

    }
    
    public static void main(String[] args) {
        
//        int [] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
//        int [] heights = {5,4,3,2,3,1,4};
//        int [] heights = {5,5,1,7,1,1,5,2,7,6};
        int [] heights = {9,2,4,0,3,4};
        
        TrappingRainWater test = new TrappingRainWater();
        
        System.out.println(test.trap(heights));
        
    }
}
