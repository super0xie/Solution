
public class CreateArrayLiteral {
    
    
    
    public static void main(String[] args) {
        String origin = "[1,2],[2,2],[4,2]";
        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        System.out.println(origin);
    }

}
