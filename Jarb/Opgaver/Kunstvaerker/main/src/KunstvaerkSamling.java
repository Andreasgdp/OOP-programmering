import java.util.ArrayList;

public class KunstvaerkSamling {
    private ArrayList<Kunstvaerk> kunstvaerker = new ArrayList<>();

    public void add(Kunstvaerk etKunstvaerk) {
        kunstvaerker.add(etKunstvaerk);
    }

    public void findSangeMedFlereKomponister() {
        for (int i = 0;  i < kunstvaerker.size();  i++) {
            if (kunstvaerker.get(i) instanceof Komposition && kunstvaerker.get(i).getAntalOphavsmaend() > 1) {
                System.out.println("- " + kunstvaerker.get(i).getTitel());
            }
        }
    }

    public void findMalerierPaaMuseum(String etMuseum) {
        for (int i = 0;  i < kunstvaerker.size();  i++) {
            if (kunstvaerker.get(i) instanceof Maleri && ((Maleri) kunstvaerker.get(i)).getMuseum().getMuseumNavn().equals(etMuseum)) {
                System.out.println("- " + kunstvaerker.get(i).getTitel());
            }
        }
    }

    public void beregnAntalLaesteSider() {
        int totalAntalSider = 0;
        for (int i = 0;  i < kunstvaerker.size();  i++) {
            if (kunstvaerker.get(i) instanceof Bog) {
                totalAntalSider += ((Bog) kunstvaerker.get(i)).getAntalSider();
            }
        }
        System.out.println("- " + totalAntalSider + " sider");
    }
}
