public class Museum {
    public String museumNavn;
    public String museumAdresse;

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
