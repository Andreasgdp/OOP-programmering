//  Teoretiske emner: access modifiers, arv og andre relationer mellem klasser og objekter (5,8,9).

package Andreas;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class KunstvaerkSamling {
    protected ArrayList<Kunstvaerk> kunstvaeker = new ArrayList<>();

    public void add(Kunstvaerk kunstvaerk) {
        this.kunstvaeker.add(kunstvaerk);
    }

    public void findSangeMedFlereKomponister() {
        for (Kunstvaerk kunstvaerk : this.kunstvaeker) {
            if (kunstvaerk instanceof Komposition) {
                if (kunstvaerk.getNumOphavsmænd() > 1) {
                    System.out.println("Der flere komponister i denne sang");
                    System.out.println("Sangen er: " + kunstvaerk.getTitel());
                }
            }
        }
    }

    public void findMalerierPaaMuseum(String museumsNavn) {
        ArrayList<String> titler = new ArrayList<>();
        for (Kunstvaerk kunstvaerk : this.kunstvaeker) {
            if (kunstvaerk instanceof Maleri) {
                if (museumsNavn.equals(((Maleri) kunstvaerk).getMuseum().getMuseumNavn())) {
                    titler.add(kunstvaerk.getTitel());
                }
            }
        }
        System.out.println("Museumet: '" + museumsNavn + "' har følgende titler:");
        for (String titel : titler) {
            System.out.println("Titel: " + titel);
        }
    }

    public void beregnAntalLaesteSider() {
        int sider = 0;
        for (Kunstvaerk kunstvaerk : this.kunstvaeker) {
            if (kunstvaerk instanceof Bog) {
                sider += ((Bog) kunstvaerk).getAntalSider();
            }
        }
        System.out.println(sider);
    }
}
