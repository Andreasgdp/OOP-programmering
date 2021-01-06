import java.util.*;
public class Person
{
    protected String navn;
    protected String nationalitet;
    protected int foedselsaar;
    protected int doedsaar;

    public Person(String n, String l, int f, int d)
    {
        navn = n;
        nationalitet = l;
        foedselsaar = f;
        doedsaar = d;
    }

    public String getNavn()
    {
        return navn;
    }

    public String getNationalitet()
    {
        return nationalitet;
    }

    public int getFoedselsaar()
    {
        return foedselsaar;
    }

    public int getDoedsaar()
    {
        return doedsaar;
    }


}
