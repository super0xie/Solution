
public class CreateArrayLiteral {
    
    
    
    public static void main(String[] args) {
        String origin = "[[53487036, -14015982, 53487038, -14015981], [-50242787, -25148635, -50242784, -25148633], [1261120, -29805890, 1261122, -29805889], [28991269, 54212557, 28991271, 54212559]]";

        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        System.out.println(origin);
    }

}
