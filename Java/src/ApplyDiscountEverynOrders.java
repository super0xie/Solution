import java.util.HashMap;

public class ApplyDiscountEverynOrders {
    
    private int n;
    private int discount;
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int count;
    
    public void Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        for(int i = 0; i < products.length; i++) {
            map.put(products[i], prices[i]);
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        count++;
        int sum = 0;
        for(int i = 0; i < product.length; i++) {
            sum += amount[i] * map.get(product[i]);
        }
        
        if(count % n == 0) {
            return sum - ((double)discount * sum)/100;
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        ApplyDiscountEverynOrders test = new ApplyDiscountEverynOrders();
        System.out.println(1-0.5d);
    }
}
