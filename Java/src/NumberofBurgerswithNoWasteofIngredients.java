import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberofBurgerswithNoWasteofIngredients {
	
	public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        int x2 = tomatoSlices - 2 * cheeseSlices;
        if(x2 < 0 || x2 % 2 == 1) return res;
        int x = x2 / 2;
        int y = cheeseSlices - x;
        if(y < 0) return res;
        return Arrays.asList(x, y);
    }
	
	public static void main(String[] args) {
		NumberofBurgerswithNoWasteofIngredients test = new NumberofBurgerswithNoWasteofIngredients();
		List<Integer> res = test.numOfBurgers(2, 1);
		for(int i : res) System.out.print(i + ", ");
	}
	
}
