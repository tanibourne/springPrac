import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ControlTime {
    public static void main(String[] args) {

        System.out.println("now() usage");
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);

        System.out.println("of() usage");
        LocalDate dateOf = LocalDate.of(2022,8,19);
        LocalTime timeOf = LocalTime.of(22,50,0);

        System.out.println(dateOf);
        System.out.println(timeOf);
    }
}
