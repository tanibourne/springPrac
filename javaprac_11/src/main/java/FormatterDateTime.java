import java.time.LocalDate;
import java.time.LocalTime;
//import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormatterDateTime {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        String shortFormat = formatter.format(LocalTime.now());

        System.out.println(LocalTime.now());
        System.out.println(shortFormat);
        System.out.println("===============");

        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String myDate = myFormatter.format(LocalDate.now());
        System.out.println(LocalDate.now());
        System.out.println(myDate);


    }
}
