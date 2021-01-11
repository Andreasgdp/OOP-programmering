import Andreas.Date;
import Ole.Dato;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int date;
        String lenTest;
        do {
            System.out.println("Enter a date (Format: YYYYMMDD): ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            date = scanner.nextInt();
            lenTest = Integer.toString(date);

        } while (lenTest.length() != 8);

        scanner.close();

        Date dateOb = new Date(date);

        System.out.println("\nDate: " + dateOb.getDate());
        System.out.println("Year: " + dateOb.getYear());
        System.out.println("Month: " + dateOb.getMonth());
        System.out.println("Day: " + dateOb.getDay());
        System.out.println("Quarter: " + dateOb.getQuarter());
        System.out.println("Is leap year: " + dateOb.leapYear());
        System.out.println("Is valid date: " + dateOb.validDate());
        System.out.println("Day in the year: " + dateOb.dayInYear());
        System.out.println("Days left in the year: " + dateOb.restDaysInYear());
        System.out.println("The weekday of the date '" + dateOb.getDate() + "' : " + dateOb.weekDay() + " "
                + dateOb.weekDayName());
        Date dateTest = new Date(20000923);
        System.out.println("Days difference between '" + dateTest.getDate() + "' and '" + dateOb.getDate() + "': "
                + dateOb.differenceInDays(dateTest));
        dateOb.setDatePlusOne();
        System.out.println("This is the new date plus one: " + dateOb.getDate());
        dateOb.setDateMinusOne();
        dateOb.setDateMinusOne();
        System.out.println("This is the new date minus one: " + dateOb.getDate());
        dateOb.setNewDate(20220506);
        System.out.println("This is the new date after setting to '20220506': " + dateOb.getDate());
        dateOb.setNewDate(20220545);
        int dateBefore = dateOb.getDate();
        int days = -20;
        dateOb.addDaysToDate(days);
        System.out.println("This is the new date after adding " + days + " to " + dateBefore + ": " + dateOb.getDate());
    }
}
