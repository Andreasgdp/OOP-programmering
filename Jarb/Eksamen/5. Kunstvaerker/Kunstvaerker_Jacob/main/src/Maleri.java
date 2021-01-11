// Teoretiske emner: access modifiers, arv og andre relationer mellem klasser og objekter

public class Maleri extends Kunstvaerk {
    protected int laengde;
    protected int bredde;
    protected Museum museum;

    public Maleri(String etNavn, int etAar, int enLaengde, int enBredde, Museum etMuseum) {
        super(etNavn, etAar);
        laengde = enLaengde;
        bredde = enBredde;
        museum = etMuseum;
    }

    public Museum getMuseum() {
        return museum;
    }
}
