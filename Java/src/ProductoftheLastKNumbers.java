import java.util.ArrayList;

public class ProductoftheLastKNumbers {
     
    public void ProductOfNumbers() {
        
    }
    
    private ArrayList<Integer> l = new ArrayList<>();
    
    public void add(int num) {
        if(num == 0) l.clear();
        else {
            if(l.isEmpty()) {
                l.add(num);
            }else {
                l.add(l.get(l.size()-1) * num);
            }
        }
    }
    
    public int getProduct(int k) {
        if(k > l.size()) return 0;
        else if(k == l.size()) {
            return l.get(l.size()-1);
        } else {
            int prod = l.get(l.size()-1);
            int prefix = l.get(l.size()-k-1);
            return prod / prefix;
        }
    }
    
    public static void main(String[] args) {
        ProductoftheLastKNumbers test = new ProductoftheLastKNumbers();
        test.add(3);
        test.add(0);
        test.add(2);
        test.add(5);
        test.add(4);
        System.out.println(test.getProduct(2));
        System.out.println(test.getProduct(3));
        System.out.println(test.getProduct(4));
        test.add(8);
        System.out.println(test.getProduct(2));
        
        
    }
    
}
