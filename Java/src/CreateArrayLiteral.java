
public class CreateArrayLiteral {
    
    
    
    public static void main(String[] args) {
        String origin = "[[10,16],[2,8],[1,6],[7,12]]";

        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        System.out.println(origin);
    }

}
