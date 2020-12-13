// Teoretiske emner: simple datatyper og Strings i Java

package Andreas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Date {
    /*******************
     Class Members
     *******************/
    static public final
    String[] MAANED_TABEL = {"januar", "februar", "marts",
            "april", "maj", "juni", "juli",
            "august", "september", "oktober",
            "november", "december"};
    static public final
    String[] UGEDAG_TABEL = {"mandag", "tirsdag",
            "onsdag", "torsdag",
            "fredag", "loerdag", "soendag"};


    /*******************
     Data Members
     *******************/
    private int date;
    private int year;
    private int month;
    private int day;
    private List<Integer> shortMonths;

    /*******************
     Constructors
     *******************/

    public Date() {
    }

    public Date(int year, int month, int day) {
        date = year * 10000 + month * 100 + day;
    }

    public Date(int date) {
        this.date = date;
        this.year = this.getYear();
        this.month = this.getMonth();
        this.day = this.getDay();

        // Short months without February
        this.shortMonths = new ArrayList<>();
        this.shortMonths.addAll(Arrays.asList(4, 6, 9, 11));
    }

    /***********************
     get & set methods
     ***********************/

    public int getDate() {
        return this.date;
    }

    private void setDate(int date) {
        this.date = date;
        this.year = this.getYear();
        this.month = this.getMonth();
        this.day = this.getDay();
    }

    public int getYear() {
        return this.date / 10000;
    }

    public void setYear(int year) {
        this.year = year;
        this.updateDate();
    }

    public void setAar(int etAar) {
        date = etAar * 10000 + date % 10000;
    }

    public int getMonth() {
        return (this.date / 100) % 100;
    }

    public void setMonth(int month) {
        this.month = month;
        this.updateDate();
    }

    public void setMaaned(int enMaaned) {
        date = date / 10000 * 10000 + enMaaned * 100 + date % 100;
    }

    public int getDay() {
        return this.date % 100;
    }

    public void setDay(int day) {
        this.day = day;
        this.updateDate();
    }

    public void setDag(int enDag) {
        date = date / 100 * 100 + enDag;
    }

    public int getQuarter() {
        return ((this.getMonth() - 1) / 3) + 1;
    }

    public void updateDate() {
        String year = Integer.toString(this.year);
        String month = String.format("%02d", this.month);
        String day = String.format("%02d", this.day);
        String date = year + month + day;
        this.date = Integer.parseInt(date);
    }

    public boolean leapYear() {
        /*
         * Det er skudår hvis årstallet er deleligt med 4. Bortset fra dem der er
         * delelige med 100, bortset fra dem, der er delelige med 400 som alligevel er
         * skudår.
         */
        boolean result = false;
        if (this.year % 4 == 0)
            result = true;
        if (this.year % 100 == 0)
            result = false;
        if (this.year % 400 == 0)
            result = true;

        return result;
    }

    public boolean leapYearInput(int year) {
        /*
         * Det er skudår hvis årstallet er deleligt med 4. Bortset fra dem der er
         * delelige med 100, bortset fra dem, der er delelige med 400 som alligevel er
         * skudår.
         */
        boolean result = false;
        if (year % 4 == 0)
            result = true;
        if (year % 100 == 0)
            result = false;
        if (year % 400 == 0)
            result = true;

        return result;
    }

    public boolean skudAar() {
        int aar = getYear();

        if (aar % 4 != 0)
            return false;
        else return (aar % 400 == 0) || (aar % 100 != 0);
    }


    public boolean validDate() {
        // Check for dates before the start of the Gregorian calender
        if (this.date < 17000301)
            return false;

        // Check for correct month num
        if (!(this.month <= 12 && this.month > 0))
            return false;

        // Their is no month with more than 31 days
        if (this.day == 0 || this.day > 31)
            return false;

        if (this.shortMonths.contains(this.month))
            return this.day <= 30;
        else if (this.month == 2)
            return (this.leapYear()) ? this.day <= 29 : this.day <= 28;
        else
            return true;
    }

    public boolean validerDato() {
        if (date < 17000301)
            return false;

        if (getMonth() < 1 || getMonth() > 12)
            return false;

        if (getDay() < 1 || getDay() > 31)
            return false;

        if (skudAar() && getMonth() == 2 && getDay() > 29)
            return false;

        if (!skudAar() && getMonth() == 2 && getDay() > 28)
            return false;

        return getDay() <= 30 ||
                (getMonth() != 4 && getMonth() != 6 &&
                        getMonth() != 9 && getMonth() != 11);
    }

    private int daysInMonth(int month) {
        return (this.shortMonths.contains(month)) ? ((month != 2) ? 30 : ((this.leapYear()) ? 29 : 28)) : 31;
    }

    public int dayInYear() {
        int totalDays = 0;

        for (int i = 1; i < this.month; i++) {
            totalDays += this.daysInMonth(i);
        }
        totalDays += this.day;
        return totalDays;
    }

    public int dagIAar() {
        int skudDag;
        if (skudAar())
            skudDag = 1;
        else
            skudDag = 0;

        return switch (getMonth()) {
            case 1 -> getDay();
            case 2 -> getDay() + 31;
            case 3 -> getDay() + skudDag + 59;
            case 4 -> getDay() + skudDag + 90;
            case 5 -> getDay() + skudDag + 120;
            case 6 -> getDay() + skudDag + 151;
            case 7 -> getDay() + skudDag + 181;
            case 8 -> getDay() + skudDag + 212;
            case 9 -> getDay() + skudDag + 243;
            case 10 -> getDay() + skudDag + 273;
            case 11 -> getDay() + skudDag + 304;
            default -> getDay() + skudDag + 334;
        };
    }

    public int restDaysInYear() {
        return (this.leapYear()) ? 366 - this.dayInYear() : 365 - this.dayInYear();
    }

    public int restDageIAar() {
        if (skudAar())
            return 366 - dagIAar();
        else
            return 365 - dagIAar();
    }

    public void setDatePlusOne() {
        // Add one day to the date and go through month and year to add to if necessary
        this.setDay(this.day + 1);
        if (!this.validDate()) {
            this.setDay(1);
            this.setMonth(this.month + 1);
            if (!this.validDate()) {
                this.setMonth(1);
                this.setYear(this.year + 1);
            }
        }
    }

    public void setDatePlusOne2() {
        this.setDate(this.date + 1);
        while (!validDate()) {
            this.setDate(this.date + 1);
        }
    }

    public void setDatoPlusEn() {
        date++;
        while (!validerDato())
            date++;
    }

    public void setDateMinusOne() {
        // Remove one day to the date and go through month and year to remove to if
        // necessary
        this.setDay(this.day - 1);
        if (!this.validDate()) {
            this.setMonth(this.month - 1);
            if (this.month == 0) {
                this.setYear(this.year - 1);
                this.setMonth(12);
            }
            this.setDay(31);
            while (!this.validDate()) {
                this.setDay(this.day - 1);
            }
        }
    }

    public void setDatoMinusEn() {
        date--;
        while (!validerDato())
            date--;

    }

    public void setNewDate(int date) {
        Date newDate = new Date(date);
        if (newDate.validDate()) {
            this.day = newDate.getDay();
            this.year = newDate.getYear();
            this.month = newDate.getMonth();
            this.updateDate();
        } else
            System.out.println("The date " + date + " is not valid. The date is still: " + this.getDate());
    }

    public void addDaysToDate(int days) {
        if (days > 0) {
            for (int i = 0; i < days; i++) {
                this.setDatePlusOne();
            }
        } else {
            for (int i = 0; i < java.lang.Math.abs(days); i++) {
                this.setDateMinusOne();
            }
        }
    }

    public void setNyDato(int antalDage) {
        if (antalDage > 0)
            for (int i = 0; i < antalDage; i++)
                setDatoPlusEn();
        else if (antalDage < 0)
            for (int i = 0; i > antalDage; i--)
                setDatoMinusEn();
    }

    private Date getFistDate(Date date) {
        return (this.getDate() < date.getDate()) ? this : date;
    }

    private Date getLastDate(Date date) {
        return (this.getDate() > date.getDate()) ? this : date;
    }

    public int differenceInDays(Date date) {
        int totalDays = 0;
        Date first = this.getFistDate(date);
        Date last = this.getLastDate(date);

        while (first.getDate() != last.getDate()) {
            first.setDatePlusOne();
            totalDays += 1;
        }

        return totalDays;
    }

    public int forskelIDage(Date enDato) {
        int antalDage = 0;

        Date kopiDato = new Date();
        kopiDato.date = date;

        if (kopiDato.date < enDato.date) {
            while (kopiDato.date != enDato.date) {
                kopiDato.setDatoPlusEn();
                antalDage++;
            }
        } else if (kopiDato.date > enDato.date) {
            while (kopiDato.date != enDato.date) {
                kopiDato.setDatoMinusEn();
                antalDage--;
            }
        }
        return antalDage;
    }

    public int weekDay() {
        // 1 marts år 1700 er mandag, brug % 7
        // 17170301 % 7 = 1
        Date firstDay = new Date(17000301);
        return this.differenceInDays(firstDay) + 1 % 7;
    }

    public int ugeDag() {
        Date udgDato = new Date();
        udgDato.date = 17000301;

        return udgDato.forskelIDage(this) % 7 + 1;

    }

    public String weekDayName() {
        // 1 marts år 1700 er mandag, brug % 7
        // 17170301 % 7 = 1
        Date firstDay = new Date(17000301);
        int dayDifference = this.differenceInDays(firstDay) + 1;

        return switch (dayDifference % 7) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Freitag";
            case 6 -> "Saturday";
            case 0 -> "Sunday";
            default -> "None";
        };
    }

    public String ugeDagTekst() {
        return UGEDAG_TABEL[ugeDag() - 1];
    }

    public String maanedTekst() {
        return MAANED_TABEL[getMonth() - 1];
    }
}