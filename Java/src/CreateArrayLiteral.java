
public class CreateArrayLiteral {
    
    public static void main(String[] args) {
        String origin = "[[2,1,5],[3,3,7]]";
        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        System.out.println(origin);
    }

}
