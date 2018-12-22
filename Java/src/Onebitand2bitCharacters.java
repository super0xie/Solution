
public class Onebitand2bitCharacters {
    
    public boolean isOneBitCharacter(int[] bits) {
        boolean [] canDecode = new boolean[bits.length];
        if(bits.length == 1) return true;
        if(bits.length == 2) {
            if(bits[0] == 0) return true;
            else return false;
        }
        
        if(bits[0] == 0) canDecode[0] = true;
        if(bits[0] == 1 || (bits[0] == 0 && bits[1] == 0)) canDecode[1] = true;
        
        for(int i = 2; i < bits.length; i++) {
            if(bits[i] == 0) {
                if(canDecode[i-1]) {
                    canDecode[i] = true;
                } else if(bits[i-1] == 1 && canDecode[i-2]) {
                    canDecode[i] = true;
                }
            }else {
                if(bits[i-1] == 1 && canDecode[i-2]) canDecode[i] = true;
            }
        }
        
        return bits[bits.length-2] == 0 || (canDecode[bits.length-2] && !canDecode[bits.length-3]);
    }
}
