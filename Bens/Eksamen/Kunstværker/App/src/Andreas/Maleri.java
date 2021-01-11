//  Teoretiske emner: access modifiers, arv og andre relationer mellem klasser og objekter (5,8,9).

package Andreas;

public class Maleri extends Kunstvaerk {
    protected int laengde;
    protected int bredde;
    protected Museum museum;

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
