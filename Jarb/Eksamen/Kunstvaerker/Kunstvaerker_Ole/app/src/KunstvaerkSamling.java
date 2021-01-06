import java.util.ArrayList;

public class KunstvaerkSamling
{
    protected ArrayList<Kunstvaerk> kunstvaerker = new ArrayList<Kunstvaerk>();

    public KunstvaerkSamling()
    {}

    public void add(Kunstvaerk kunstvaerk)
    {
        kunstvaerker.add(kunstvaerk);
    }


    public void findSangeMedFlereKomponister()
    {
        for (int i = 0; i < kunstvaerker.size(); i++)
        {
            if (kunstvaerker.get(i) instanceof Komposition && kunstvaerker.get(i).getOphavsmaend() > 1)
            {
                System.out.println(kunstvaerker.get(i).titel);
            }
        }
    }

    public void findMalerierPaaMuseum(String museum)
    {
        for (int i = 0; i < kunstvaerker.size(); i++)
        {
            if (kunstvaerker.get(i) instanceof Maleri)
            {
                Maleri billede = (Maleri) kunstvaerker.get(i);
                if (billede.getNavnPaaMuseum().equals(museum))
                {
                    System.out.println(billede.titel);
                }
            }
        }
    }

    public void beregnAntalLaesteSider()
    {
        int akumAntalSider = 0;
        for (int i = 0; i < kunstvaerker.size(); i++)
        {
            if (kunstvaerker.get(i) instanceof Bog)
            {
                Bog thisBook = (Bog) kunstvaerker.get(i);
                akumAntalSider = akumAntalSider + thisBook.antalSider();
            }
        }
        System.out.println(akumAntalSider);
    }

}


   