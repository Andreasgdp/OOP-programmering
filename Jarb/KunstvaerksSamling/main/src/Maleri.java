public class Maleri extends Kunstvaerk {
    private int laengde;
    private int bredde;
    private Museum museum;

    public Maleri(String etNavn, int etAar, int enLaengde, int enBredde, Museum etMuseum) {
        super(etNavn, etAar);
        laengde = enLaengde;
        bredde = enBredde;
        museum = etMuseum;
    }
}
