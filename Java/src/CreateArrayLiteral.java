
public class CreateArrayLiteral {
    
    
    
    public static void main(String[] args) {
        String origin = "[[1,0],[-3,1],[-4,0],[2,3]]";

        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        System.out.println(origin);
    }

}
