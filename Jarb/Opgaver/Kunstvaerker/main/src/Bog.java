public class Bog extends Kunstvaerk {
    private String genre;
    private int antalSider;

    public Bog(String etNavn, int etAar, String enGenre, int etAntalSider) {
        super(etNavn, etAar);
        genre = enGenre;
        antalSider = etAntalSider;
    }

    public int getAntalSider() {
        return antalSider;
    }
}
