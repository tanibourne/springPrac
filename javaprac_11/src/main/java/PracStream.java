import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Sale {
    String fruitname;
    int price;
    float discount;

    public Sale(String fruitname, int price, float discount) {
        this.fruitname = fruitname;
        this.price = price;
        this.discount = discount;
    }
}

public class PracStream {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("서울");
        list.add("부산");
        list.add("대구");
        list.add("서울");

        System.out.println(list);

        List<String> result = list.stream()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(result);

        System.out.println("List to Set");
        Set<String> set = list.stream()
                .filter("서울"::equals) //.filter(it -> "서울".equals(it))
                .collect(Collectors.toSet());

        System.out.println(set);

        System.out.println("Array to Stream");

        String[] arr = {"SQL", "java", "python"};

        Stream<String> stringStream = Arrays.stream(arr);
        stringStream.forEach(System.out::println);

        System.out.println("map example=======");

        List<Sale> sales = Arrays.asList(
                new Sale("orange", 5000, 0.05f),
                new Sale("apple", 3000, 0.2f),
                new Sale("grape", 6000, 0)

        );
//실 구매가 얼마인지 보기
        sales.stream()
                .map(sale -> Pair.of(sale.fruitname,sale.price*(1- sale.discount)))
                .forEach(pair -> System.out.println(pair.getLeft() + " " + pair.getRight()));


        System.out.println("reduce========================");
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        System.out.println(list1.stream().reduce(0,Integer::sum)); //0부터 시작해서 다 더해라



    }
}
