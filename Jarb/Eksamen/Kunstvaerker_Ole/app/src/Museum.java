import java.util.*;
public class Museum
{
    protected String navn;
    protected String adresse;


    public Museum(String n, String a)
    {
        navn = n;
        adresse = a;
    }


    public String getNavn()
    {
        return navn;
    }


    public String getAdresse()
    {
        return adresse;
    }
}
