import java.util.HashMap;
import java.util.Map;

public class ex1 {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>(Map.of(101,"pacchu",
                                                            102,"anada",
                                                            103,"dinesha"));
        System.out.println(map);
        System.out.println(map.get(101));
        System.out.println(map.get(102));
        System.out.println(map.get(103));
    }
}
