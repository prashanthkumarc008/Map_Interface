import java.util.Arrays;
import java.util.List;

public class Stream1   {
    public static void main(String[] args) {
        List<String> Enames= Arrays.asList("ananda","dinesha","boli");
        System.out.println("Enames :"+Enames);
        Enames.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}

