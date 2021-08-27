package javaapplication23;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class JavaApplication23 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate from = LocalDate.now();
//        System.out.println(from);
//        LocalDate to = LocalDate.parse(sc.nextLine(),formatter);

//        long result = ChronoUnit.DAYS.between(from, to);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate a = LocalDate.now();
        String b = "10/07/2021";
        LocalDate c = LocalDate.parse(b, formatter);
        
        long result = ChronoUnit.DAYS.between(a, c);
        System.out.println(result);
    }

}
