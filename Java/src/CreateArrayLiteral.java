
public class CreateArrayLiteral {
    
    
    
    public static void main(String[] args) {
        String origin = "[[2,0],[4,1],[0,4],[1,3],[1,0],[3,4],[3,0],[2,3],[0,2],[0,0],[2,2],[4,2],[3,3],[4,4],[4,0],[4,3],[3,1],[2,1],[1,4],[2,4]]";
        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        
        System.out.println(origin);
    }

}
