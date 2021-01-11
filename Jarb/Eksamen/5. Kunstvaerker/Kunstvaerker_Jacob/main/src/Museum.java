// Teoretiske emner: access modifiers, arv og andre relationer mellem klasser og objekter

public class Museum {
    protected String navn;
    protected String adresse;

    public Museum(String etNavn, String enAdresse) {
        navn = etNavn;
        adresse = enAdresse;
    }

    public String getMuseumNavn() {
        return navn;
    }
}
