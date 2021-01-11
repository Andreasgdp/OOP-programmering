package Ole;

public class Bog extends Kunstvaerk
{
    protected String genre;
    protected int antalSider;
    
    
    public Bog(String titel, int aar, String enGenre, int etAntalSider)
    {
        super(titel,aar);
        genre = enGenre;
        antalSider = etAntalSider;
    }

    public String getGenre()
    {
        return genre;
    }
    
    public int antalSider()
    {
        return antalSider;
    }
}
