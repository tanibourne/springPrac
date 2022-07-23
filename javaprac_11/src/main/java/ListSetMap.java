import java.util.*;

public class ListSetMap {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        // 앞에서 계속 int 같은 primitive type을 사용했는데, Collection framework을 쓰기 위해서
        // 자료구조가 담는것은 객체이다 보니까 객체를 담을 수 있는 type이어야한다. 객체를 담을 수 있는 type은
        // 참조형 자료여야만 하기 때문에  primitive type은 사용할 수 없다.
        // 대신에 int,boolean,long 등등에 해당되는 Class가 이미 java에 정의되어 있기 때문에 Integer class로 사용하면 의미는 같아진다.
        integerList.add(1);
        integerList.add(5);
        integerList.add(3);
        integerList.add(11);
        integerList.add(12);

        System.out.println(integerList);

        Collections.sort(integerList);
        System.out.println(integerList);
        System.out.println(integerList.size());

        integerList.remove(4);

        System.out.println(integerList);

        for (int i=0;i < integerList.size();i++){
            System.out.println(integerList.get(i));
        }

        for(int integer: integerList){
            System.out.println(integer);
        }

        System.out.println("=========Set=========");

        Set<Integer> integerSet = new HashSet<>(); // 중복을 허용하지 않는다.

        Set<String> stringSet = new HashSet<>();




    }
}
