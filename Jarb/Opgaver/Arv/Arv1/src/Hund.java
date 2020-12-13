public class Hund extends Husdyr {
    private Date sidstKlippet;

    public Hund(String etN, String enL, Date sK) {
        super(etN, enL);
        sidstKlippet = sK;
    }

    public Date getSidstKlippet() {
        return sidstKlippet;
    }

    public String givLyd() {
        return "Vov-vov";
    }
}
