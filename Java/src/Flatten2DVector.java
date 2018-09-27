import java.util.Iterator;
import java.util.List;

public class Flatten2DVector implements Iterator<Integer>{
    
    private int i;
    private int j;
    private int next;
    private List<List<Integer>> vec2d;
    private boolean hasNext;
    public void Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        i = 0;
        j = 0;
        while(i < vec2d.size() && vec2d.get(i).size() == 0) i++;
        if(i < vec2d.size()) {
            next = vec2d.get(i).get(j);
            hasNext = true;
        }else {
            hasNext = false;
        }
    }

    @Override
    public Integer next() {
        int aux = next;
        
        if(j == vec2d.get(i).size()-1) {
            j=0;
            i++;
            while(i < vec2d.size() && vec2d.get(i).size() == 0) i++;
            if(i < vec2d.size()) {
                next = vec2d.get(i).get(j);
                hasNext = true;
            }else {
                hasNext = false;
            }
        }else {
            j++;
            next = vec2d.get(i).get(j);
        }
        
        return aux;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }
}
