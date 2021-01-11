//  Teoretiske emner: access modifiers, arv og andre relationer mellem klasser og objekter (5,8,9).

package Andreas;

public class Museum {
    protected String museumNavn;
    protected String museumAdresse;

    public Museum(String museumNavn, String museumAdresse) {
        this.museumNavn = museumNavn;
        this.museumAdresse = museumAdresse;
    }

    public String getMuseumAdresse() {
        return museumAdresse;
    }

    public String getMuseumNavn() {
        return museumNavn;
    }
}
