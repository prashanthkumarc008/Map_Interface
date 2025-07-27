import java.util.HashMap;
import java.util.Map;

public class ex1 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(Map.of(
                101, "pacchu",
                102, "anada",
                103, "dinesha"
        ));
        System.out.println(map);

        // For-each loop to iterate over map entries
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
    }
}