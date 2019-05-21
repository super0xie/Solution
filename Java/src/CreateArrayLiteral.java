
public class CreateArrayLiteral {
    
    public static void main(String[] args) {
        String origin = "[[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]";
        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        System.out.println(origin);
    }

}
