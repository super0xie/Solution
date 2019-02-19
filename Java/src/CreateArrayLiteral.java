
public class CreateArrayLiteral {
    
    
    
    public static void main(String[] args) {
        String origin = "[[2,1,1],[1,1,0],[0,1,1]]";
        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        System.out.println(origin);
    }

}
