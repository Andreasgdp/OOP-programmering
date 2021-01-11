import java.util.Calendar;
import java.util.Date;

public class CprNr
{
    String nummeret;

    public CprNr() {

    }

    public CprNr(String etCprNr) {
        nummeret = etCprNr;
    }

    public String getCprNr() {
        return nummeret;
    }

    public void setCprNr(String etCprNr) {
        nummeret = etCprNr;
    }

    public int getDag() {
        int d = Integer.parseInt(nummeret.substring(0,2));
        return d;
    }

    public int getMaaned() {
        int m = Integer.parseInt(nummeret.substring(2,4));
        return m;
    }

    public int getAar() {
        int aarhundrede = 0;
        if (nummeret.charAt(6) >= '0' && nummeret.charAt(6) <= '3')
            aarhundrede = 1900;
        else
        if (nummeret.charAt(6) == '4' || nummeret.charAt(6) == '5')
            aarhundrede = 1800;
        else
            aarhundrede = 2000;

        return aarhundrede + Integer.parseInt(nummeret.substring(4,6));
    }

    // Precondition: nummeret indeholder en korrekt dato
    public Dato getDato() {
        Dato d = new Dato(getAar(),getMaaned(),getDag());

        return d;
    }

    public int getAlder() {
        return 2020 - getAar();
    }

    public boolean erMand() {
        int n = Integer.parseInt(nummeret.substring(9,10));
        return n % 2 == 1;
    }

    public boolean erKvinde() {
        return !erMand();
    }

    public boolean erValid() {
        if (nummeret.length() != 10)
            return false;
        for (int i = 0; i < 10; i++)
            if (nummeret.charAt(i) < '0' || nummeret.charAt(i) > '9')
                return false;
        Dato d = getDato();
        if (!d.validerDato())
            return false;
        int udregnet = 0;
        udregnet += Integer.parseInt(nummeret.substring(0,1))*4;
        udregnet += Integer.parseInt(nummeret.substring(1,2))*3;
        udregnet += Integer.parseInt(nummeret.substring(2,3))*2;
        udregnet += Integer.parseInt(nummeret.substring(3,4))*7;
        udregnet += Integer.parseInt(nummeret.substring(4,5))*6;
        udregnet += Integer.parseInt(nummeret.substring(5,6))*5;
        udregnet += Integer.parseInt(nummeret.substring(6,7))*4;
        udregnet += Integer.parseInt(nummeret.substring(7,8))*3;
        udregnet += Integer.parseInt(nummeret.substring(8,9))*2;
        udregnet += Integer.parseInt(nummeret.substring(9,10))*1;
        if (udregnet % 11 != 0)
            return false;
        return true;
    }


}
