import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CalculateDateTime {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1995,3,16);

        Period periodBtoT= Period.between(birthday,today);
        Period periodTtoB= Period.between(today,birthday);

        System.out.println(periodBtoT.getYears()); // 27년 후 start: birthday -> end: today
        System.out.println(periodBtoT.getMonths()); // 4달 후
        System.out.println(periodBtoT.getDays()); // 6일 후
        System.out.println("++++++++++++++++++");
        System.out.println(periodTtoB.getYears()); //27년 전  start: today -> end: birthday
        System.out.println(periodTtoB.getMonths());// 4달 전
        System.out.println(periodTtoB.getDays()); // 6일 전

       // 오늘의 날짜와 시간을 [연도/월/일 시간/일자]의 형식으로 값으로 출력해보세요.

        // pattern localtime formatstyle formatter

        System.out.println("++++++++++++++++++");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd h/mm");
        String totoday = formatter.format(LocalDateTime.now());
        System.out.println(totoday);
        System.out.println("++++++++++++++++++");
        int hour = LocalTime.now().getHour();
        int day = LocalDate.now().getDayOfMonth();
        System.out.println(hour);
        System.out.println(day);

        System.out.println(totoday+" "+hour+"/"+day);



    }
}
