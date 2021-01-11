// Teoretiske emner: access modifiers, arv og andre relationer mellem klasser og objekter

public class Komposition extends Kunstvaerk {
    protected String genre;
    protected int spilletid;

    public Komposition(String etNavn, int etAar, String enGenre, int enSpilletid) {
        super(etNavn, etAar);
        genre = enGenre;
        spilletid = enSpilletid;
    }

}
