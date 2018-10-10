
public class CreateArrayLiteral {
    
    
    
    public static void main(String[] args) {
        String origin = "[\n" + 
                " [ 1, 2, 3 ],\n" + 
                " [ 4, 5, 6 ],\n" + 
                " [ 7, 8, 9 ]\n" + 
                "]";
        origin = origin.replace('[', '{');
        origin = origin.replace(']', '}');
        
        System.out.println(origin);
    }

}
