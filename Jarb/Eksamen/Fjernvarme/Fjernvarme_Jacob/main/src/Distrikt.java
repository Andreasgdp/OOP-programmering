// Teoretiske emner: arrays – anvendelse, fordele og ulemper

// Opg.2
import java.util.ArrayList;

public class Distrikt {
    private String navn;
    private double prisPrM3;
    private ArrayList<Forbruger> forbrugere = new ArrayList<Forbruger>();
    private int antalForbrugere;

    public Distrikt() {
        this.navn = "navn";
        this.prisPrM3 = 0;
        this.antalForbrugere = 0;
    }

    public Distrikt(String navn, double prisPrM3) {
        this.navn = navn;
        this.prisPrM3 = prisPrM3;
        this.antalForbrugere = 0;
    }

    public void setForbruger(Forbruger forbruger) {
        int maxAntalForbrugere = 200;
        if (antalForbrugere < maxAntalForbrugere) {
            forbrugere.add(forbruger);
            antalForbrugere++;
        } else {
            System.out.println("Der er ikke plads til flere forbrugere i distriktet!");
        }
    }

    public double afregnForbruger(int maalerNr) {
        double returnValue = -1;
        for (int i = 0; i < forbrugere.size(); i++) {
            if (forbrugere.get(i).getMaalerNr() == maalerNr) {
                Forbruger forbruger = forbrugere.get(i);
                returnValue = forbruger.beregnForbrug() * prisPrM3;
                break;
            }
        }
        return returnValue;
    }

    public String getDistriktNavn() {
        return navn;
    }

    public ArrayList<Forbruger> getForbrugerArray() {
        return forbrugere;
    }
}
