public class Museum {
    private String navn;
    private String adresse;

    public Museum(String etNavn, String enAdresse) {
        navn = etNavn;
        adresse = enAdresse;
    }

    public String getMuseumNavn() {
        return navn;
    }
}
