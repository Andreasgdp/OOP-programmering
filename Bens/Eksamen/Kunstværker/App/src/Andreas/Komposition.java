//  Teoretiske emner: access modifiers, arv og andre relationer mellem klasser og objekter (5,8,9).

package Andreas;

public class Komposition extends Kunstvaerk {
    protected String genre;
    protected int spiletid;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getSpiletid() {
        return spiletid;
    }

    public void setSpiletid(int spiletid) {
        this.spiletid = spiletid;
    }

    public Komposition(String titel, int udgivelsesaar, String genre, int spiletid) {
        super(titel, udgivelsesaar);
        this.genre = genre;
        this.spiletid = spiletid;
    }
}
