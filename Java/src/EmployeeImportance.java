import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class EmployeeImportance {
    
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };
    
    public int getImportance(List<Employee> employees, int id) {
        
        int res = 0;
        
        HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
        LinkedList<Employee> queue = new LinkedList<Employee>();
        for(Employee employee : employees) {
            map.put(employee.id, employee);
        }
        
        queue.add(map.get(id));
        while(!queue.isEmpty()) {
            Employee poped = queue.removeFirst();
            
            res += poped.importance;
            for(int sub : poped.subordinates) {
                queue.addLast(map.get(sub));
            }
        }
        
        return res;
    }

}
