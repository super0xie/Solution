
public class CreateArrayLiteral {
    
    public static void main(String[] args) {

        String origin = "\r\n" + 
        		"[[1,3,5],[4,1,1],[1,5,3]]";

        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        System.out.println(origin);
    }

}
