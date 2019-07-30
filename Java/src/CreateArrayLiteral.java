
public class CreateArrayLiteral {
    
    public static void main(String[] args) {
        String origin = "[[1,2,5],[1,3,6],[2,3,1]]";
        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        System.out.println(origin);
    }

}
