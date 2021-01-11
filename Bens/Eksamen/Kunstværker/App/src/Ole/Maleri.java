package Ole;

import java.util.*;
public class Maleri extends Kunstvaerk
{
    protected int laengde;
    protected int bredde;
    protected Museum museum;
    
    
    public Maleri(String titel, int aar,int enLaengde, int enBredde, Museum etMuseum)
    {
        super(titel,aar);
        laengde = enLaengde;
        bredde = enBredde;
        museum = etMuseum;
    }

    public String getNavnPaaMuseum()
    {
        return museum.getNavn();
    }
    
    public int getLaengde()
    {
        return laengde;
    }
    
    public int getBredde()
    {
        return bredde;
    }
}
