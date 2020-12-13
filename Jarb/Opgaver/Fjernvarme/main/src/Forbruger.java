public class Forbruger {
    private String navn;
    private int maalerNr;
    private int nyAflaesning;
    private int forrigeAflaesning;
    private int maalerMax;


    public Forbruger() {
        this.navn = "navn";
        this.maalerNr = 0;
        this.nyAflaesning = 0;
        this.forrigeAflaesning = 0;
        this.maalerMax = 0;
    }

    public Forbruger(String navn, int maalerNr, int maalerMax) {
        this.navn = navn;
        this.maalerNr = maalerNr;
        this.nyAflaesning = 0;
        this.forrigeAflaesning = 0;
        this.maalerMax = maalerMax;
    }

    public int getMaalerNr() {
        return maalerNr;
    }

    public String setNavn(String nytNavn) {
        return navn = nytNavn;
    }

    public String getNavn() {
        return navn;
    }

    public void aflæsMaaler(int forbrugerAflaesning) {
        forrigeAflaesning = nyAflaesning;
        nyAflaesning = forbrugerAflaesning;
    }

    public int beregnForbrug() {
        return java.lang.Math.abs(maalerMax - (nyAflaesning - forrigeAflaesning));
    }
}