
public class CreateArrayLiteral {
    
    public static void main(String[] args) {
        String origin = "[[1,0],[2,2],[2,1]]";
        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        System.out.println(origin);
    }

}
