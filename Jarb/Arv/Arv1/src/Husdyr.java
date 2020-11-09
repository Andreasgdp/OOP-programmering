public abstract class Husdyr {
    private String navn;
    private String livret;

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
