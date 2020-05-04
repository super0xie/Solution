
public class MaximumPointsYouCanObtainfromCards {
	
	public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int width = cardPoints.length-k;
        int min = Integer.MAX_VALUE;
        int total = 0;
        for(int i = 0; i < cardPoints.length; i++) {
        	sum += cardPoints[i];
        	total += cardPoints[i];
        	if(i >= width) sum -= cardPoints[i-width];
        	
        	if(i >= width-1) min = Math.min(min, sum);
        }
        
        return total - min;
    }
	
	public static void main(String[] args) {
		MaximumPointsYouCanObtainfromCards test = new MaximumPointsYouCanObtainfromCards();
		System.out.println(test.maxScore(new int[] {1,2,3,4,5,6,1}, 3));
	}
	
}
