package Ole;

public class Dato {

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

    static public final
    String[] MONTH_TABLE = {"Jan.", "Feb.", "Mar.",
            "Apr.", "May", "June", "July",
            "Aug.", "Sep.", "Oct.",
            "Nov.", "Dec."};

    /*******************
     Data Members
     *******************/

    private int datoen;

    /*******************
     Constructors
     *******************/

    public Dato() {
    }

    public Dato(int enD) {
        datoen = enD;
    }

    public Dato(int etAar, int enMaaned, int enDag) {
        datoen = etAar * 10000 + enMaaned * 100 + enDag;
    }

    /***********************
     get og set metoder
     ***********************/

    public int getDatoen() {
        return datoen;
    }

    public void setDatoen(int enDato) {
        datoen = enDato;
    }

    public int getAar() {
        return datoen / 10000;
    }

    public void setAar(int etAar) {
        datoen = etAar * 10000 + datoen % 10000;
    }

    public int getMaaned() {
        return datoen / 100 % 100;
    }

    public void setMaaned(int enMaaned) {
        datoen = datoen / 10000 * 10000 + enMaaned * 100 + datoen % 100;
    }

    public int getDag() {
        return datoen % 100;
    }

    public void setDag(int enDag) {
        datoen = datoen / 100 * 100 + enDag;
    }

    public int getKvartalet() {
        return (getMaaned() - 1) / 3 + 1;
    }

    public boolean skudAar() {
        int aar = getAar();

        if (aar % 4 != 0)
            return false;
        else return (aar % 400 == 0) || (aar % 100 != 0);
    }


    public boolean validerDato() {
        if (datoen < 17000301)
            return false;

        if (getMaaned() < 1 || getMaaned() > 12)
            return false;

        if (getDag() < 1 || getDag() > 31)
            return false;

        if (skudAar() && getMaaned() == 2 && getDag() > 29)
            return false;

        if (!skudAar() && getMaaned() == 2 && getDag() > 28)
            return false;

        return getDag() <= 30 ||
                (getMaaned() != 4 && getMaaned() != 6 &&
                        getMaaned() != 9 && getMaaned() != 11);
    }

    public int dagIAar() {
        int skudDag;
        if (skudAar())
            skudDag = 1;
        else
            skudDag = 0;

        switch (getMaaned()) {
            case 1:
                return getDag();
            case 2:
                return getDag() + 31;
            case 3:
                return getDag() + skudDag + 59;
            case 4:
                return getDag() + skudDag + 90;
            case 5:
                return getDag() + skudDag + 120;
            case 6:
                return getDag() + skudDag + 151;
            case 7:
                return getDag() + skudDag + 181;
            case 8:
                return getDag() + skudDag + 212;
            case 9:
                return getDag() + skudDag + 243;
            case 10:
                return getDag() + skudDag + 273;
            case 11:
                return getDag() + skudDag + 304;
            default:
                return getDag() + skudDag + 334;
        }
    }

    public int restDageIAar() {
        if (skudAar())
            return 366 - dagIAar();
        else
            return 365 - dagIAar();
    }

    public void setDatoPlusEn() {
        datoen++;
        while (!validerDato())
            datoen++;
    }

    public void setDatoMinusEn() {
        datoen--;
        while (!validerDato())
            datoen--;

    }

    public void setNyDato(int antalDage) {
        if (antalDage > 0)
            for (int i = 0; i < antalDage; i++)
                setDatoPlusEn();
        else if (antalDage < 0)
            for (int i = 0; i > antalDage; i--)
                setDatoMinusEn();
    }

    public int forskelIDage(Dato enDato) {
        int antalDage = 0;

        Dato kopiDato = new Dato();
        kopiDato.datoen = datoen;

        if (kopiDato.datoen < enDato.datoen) {
            while (kopiDato.datoen != enDato.datoen) {
                kopiDato.setDatoPlusEn();
                antalDage++;
            }
        } else if (kopiDato.datoen > enDato.datoen) {
            while (kopiDato.datoen != enDato.datoen) {
                kopiDato.setDatoMinusEn();
                antalDage--;
            }
        }
        return antalDage;
    }

    public int ugeDag() {
        Dato udgDato = new Dato();
        udgDato.datoen = 17000301;

        return udgDato.forskelIDage(this) % 7 + 1;

    }

    public String ugeDagTekst() {
        return UGEDAG_TABEL[ugeDag() - 1];
    }

    public String maanedTekst() {
        return MAANED_TABEL[getMaaned() - 1];
    }

    public String printNum() {
        String s = getAar() + ".";
        if (getMaaned() <= 9)
            s += "0";
        s += getMaaned() + ".";
        if (getDag() <= 9)
            s += "0";
        s += getDag();
        return s;
    }

    public String printDato() {
        String print = "";
        if (!validerDato())
            return "N/A";
        print += MONTH_TABLE[getMaaned() - 1];
        print += " " + getDag();
        if (getDag() == 1 || getDag() == 21 || getDag() == 31)
            print += "st ";
        else if (getDag() == 2 || getDag() == 22)
            print += "nd ";
        else if (getDag() == 3)
            print += "rd ";
        else
            print += "th ";
        print += getAar();
        return print;
    }
}
