public class Komposition extends Kunstvaerk {
    private String genre;
    private int spiletid;

    public Komposition(String titel, int udgivelsesaar, String genre, int spiletid) {
        super(titel, udgivelsesaar);
        this.genre = genre;
        this.spiletid = spiletid;
    }
}
