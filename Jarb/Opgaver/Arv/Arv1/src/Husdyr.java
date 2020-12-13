public abstract class Husdyr {
    protected String navn;
    protected String livret;

    public Husdyr(String etN, String enL) {
        navn = etN;
        livret = enL;
    }

    public String getNavn() {
        return navn;
    }

    public String getLivret() {
        return livret;
    }

    public String givLyd() {
        return "Ubestemt dyrelyd";
    }
}
