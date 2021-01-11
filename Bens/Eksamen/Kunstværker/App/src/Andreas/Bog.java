//  Teoretiske emner: access modifiers, arv og andre relationer mellem klasser og objekter (5,8,9).

package Andreas;

public class Bog extends Kunstvaerk {
    protected String genre;
    protected int antalSider;

    public Bog(String titel, int udgivelsesaar, String genre, int antalSider) {
        super(titel, udgivelsesaar);
        this.genre = genre;
        this.antalSider = antalSider;
    }

    public int getAntalSider() {
        return antalSider;
    }
}
