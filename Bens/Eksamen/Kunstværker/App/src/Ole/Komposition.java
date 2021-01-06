package Ole;

public class Komposition extends Kunstvaerk
{
   protected String genre;
   protected int spilletid;
   

   public Komposition(String titel, int aar, String enGenre, int enSpilletid)
   {
       super(titel, aar);
       genre = enGenre;
       spilletid = enSpilletid;
   }
   
   public String getGenre()
   {
        return genre;
   }
   
   public int getSpilletid()
   {
        return spilletid;
   }
}
