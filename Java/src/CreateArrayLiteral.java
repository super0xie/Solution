
public class CreateArrayLiteral {
    
    
    
    public static void main(String[] args) {
        String origin = "[1,3,2,3,1]";
        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        
        System.out.println(origin);
    }

}
