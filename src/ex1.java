import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ex1 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(Map.of(
                101, "pacchu",
                102, "anada",
                103, "dinesha",
                104, "carol",
                105, "dave"
        ));
        System.out.println(map);

        // For-each loop to iterate over map entries
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        // Iterator-based loop with proper generics
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> e1 = it.next();
            System.out.println(e1.getKey());
            System.out.println(e1.getValue());
        }
    }
}