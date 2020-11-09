import java.util.ArrayList;

public class KunstvaerkSamling {
    private ArrayList<Kunstvaerk> kunstvaerker = new ArrayList<>();

    public void add(Kunstvaerk etKunstvaerk) {
        kunstvaerker.add(etKunstvaerk);
    }

    public void findSangeMedFlereKomponister() {
        for (int i = 0;  i < kunstvaerker.size();  i++) {
            if (kunstvaerker.get(i) instanceof Komposition && kunstvaerker.get(i).getAntalOphavsmaend() > 1) {
                System.out.println(kunstvaerker.get(i).getTitel());
            }
        }
    }

    public void findMalerierPaaMuseum(String tmp) {

    }

    public void beregnAntalLaesteSider() {

    }
}
