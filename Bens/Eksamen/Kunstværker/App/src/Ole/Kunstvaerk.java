package Ole;

import java.util.*;
public abstract class Kunstvaerk
{
    protected String titel;
    protected int aar;
    protected Person[] ophavsmaend;
    protected int antalOphavsmaend;

    public Kunstvaerk(String enTitel,int etAar)
    {
        titel = enTitel;
        aar = etAar;
        ophavsmaend = new Person[5];
        
    }
    
    public boolean addOphavsmand(Person enPerson)
    {
        if (antalOphavsmaend < 5)
        {
            ophavsmaend[antalOphavsmaend] = (Person) enPerson;
            antalOphavsmaend++;
            return true;
        }
        return false;
    }
    
    public int getOphavsmaend()
    {
        return antalOphavsmaend;
    }
    
    public String getTitel()
    {
        return titel;
    }
    public int getAar()
    {
       return aar;
    }
    
}

