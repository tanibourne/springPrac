import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PracGenerics {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("strring");
        Collection<String> collection = list;


        List<Exception> exceptions = new ArrayList<>();
        Collection<Exception> exceptionCollection = exceptions;

        List<IllegalArgumentException> illegalArgumentExceptions = new ArrayList<>();

        exceptionCollection.addAll(illegalArgumentExceptions); // Exception의 자식 클래스중 하나인
        // IllegalArgumentException를 상속받은 illegalArgumentExceptions를 넣을 수 있다.
    }
}
