
public class AverageSalaryExcludingtheMinimumandMaximumSalary {
	
	public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i : salary) {
        	sum += i;
        	min = Math.min(min, i);
        	max = Math.max(max, i);
        }
        
        return (double)(sum - max - min) / (salary.length-2);
    }
	
}
