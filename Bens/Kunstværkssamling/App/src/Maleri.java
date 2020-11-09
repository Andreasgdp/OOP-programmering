public class Maleri extends Kunstvaerk {
    private int laengde;
    private int bredde;
    private Museum museum;

    public Maleri(String navn, int aar, int laengde, int bredde, Museum smk) {
        super(navn, aar);
        this.laengde = laengde;
        this.bredde = bredde;
        this.museum = smk;
    }

    public Museum getMuseum() {
        return museum;
    }
}
