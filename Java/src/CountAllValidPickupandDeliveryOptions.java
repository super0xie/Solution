
public class CountAllValidPickupandDeliveryOptions {
    
    private int mod = 1_000_000_007;
    
    public int countOrders(int n) {
        if(n == 1) return 1;
        int mul = countOrders(n-1);
        int o = (2*(n-1)+2) * (2*(n-1)+1) / 2;
        long res = mul * ((long)(2*(n-1)+2)) * (2*(n-1)+1) / 2;
        
        return (int)(res % mod);
    }
    
    public static void main(String[] args) {
        CountAllValidPickupandDeliveryOptions test = new CountAllValidPickupandDeliveryOptions();
        System.out.println(test.countOrders(3));
    }
    
}
