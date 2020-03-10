
public class CreateArrayLiteral {
    
    public static void main(String[] args) {
        String origin = "[[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]]";
        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        System.out.println(origin);
    }

}
