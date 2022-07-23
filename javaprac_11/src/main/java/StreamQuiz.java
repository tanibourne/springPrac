import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamQuiz {
    public static void main(String[] args) {
        String [] arr = {"김정우", "김호정", "이하늘", "이정희", "박정우", "박지현", "정우석", "이지수"};
        List<String> names = Arrays.asList(arr);
        long result = names.stream()
                .filter(name -> name.startsWith("이"))
                .count();






        System.out.println(result);
    }
}
