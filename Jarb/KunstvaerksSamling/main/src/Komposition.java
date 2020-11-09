public class Komposition extends Kunstvaerk {
    private String genre;
    private int spilletid;

    public Komposition(String etNavn, int etAar, String enGenre, int enSpilletid) {
        super(etNavn, etAar);
        genre = enGenre;
        spilletid = enSpilletid;
    }

}
