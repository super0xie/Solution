
public class CreateArrayLiteral {
    
    
    
    public static void main(String[] args) {
        String origin = "[[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]";
        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        System.out.println(origin);
    }

}
