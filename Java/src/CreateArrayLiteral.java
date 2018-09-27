
public class CreateArrayLiteral {
    
    
    
    public static void main(String[] args) {
        String origin = "[\n" + 
                "  ['o','a','a','n'],\n" + 
                "  ['e','t','a','e'],\n" + 
                "  ['i','h','k','r'],\n" + 
                "  ['i','f','l','v']\n" + 
                "]";
        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        
        System.out.println(origin);
    }

}
