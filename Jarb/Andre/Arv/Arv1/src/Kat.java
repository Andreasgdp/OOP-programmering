public class Kat extends Husdyr {
    private int antalMysFanget;

    public Kat(String etN, String enL) {
        super(etN, enL);
        antalMysFanget = 0;
    }

    public int getAntalMysFanget() {
        return antalMysFanget;
    }

    public String givLyd() {
        return "Miau";
    }
}
