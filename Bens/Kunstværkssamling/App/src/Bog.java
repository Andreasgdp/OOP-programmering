public class Bog extends Kunstvaerk {
    private String genre;
    private int antalSider;

    public Bog(String titel, int udgivelsesaar, String genre, int antalSider) {
        super(titel, udgivelsesaar);
        this.genre = genre;
        this.antalSider = antalSider;
    }

    public int getAntalSider() {
        return antalSider;
    }
}
