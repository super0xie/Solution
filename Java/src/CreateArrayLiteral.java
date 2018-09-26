
public class CreateArrayLiteral {
    
    
    
    public static void main(String[] args) {
        String origin = "[[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]";
        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        
        System.out.println(origin);
    }

}
