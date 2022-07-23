import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PracLambda {
    public static void main(String[] args) {
        List <String> list = new ArrayList<>();

        list.add("korea");
        list.add("spain");
        list.add("france");

        Stream<String> stream = list.stream();
        stream.map(str -> {
            System.out.println(str);
            return str.toUpperCase();
        }).forEach(System.out::println);

    }
}
