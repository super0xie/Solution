
public class CreateArrayLiteral {
    
    public static void main(String[] args) {

        String origin = "[[1,1],[1,1],[0,2],[1,3]]";

        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        System.out.println(origin);
    }

}
