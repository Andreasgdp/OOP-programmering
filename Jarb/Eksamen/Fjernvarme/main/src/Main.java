// Teoretiske emner: arrays – anvendelse, fordele og ulemper

// Opg.3
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Opretter distriktet
        Distrikt distrikt = new Distrikt("Distriktet", 9.98);
        System.out.printf("I distriktet '%s' er følgende forbrugere:", distrikt.getDistriktNavn());

        // Opretter forbrugere og tilføjer til distriktet
        ArrayList<String> navne = new ArrayList<String>();
        navne.addAll(Arrays.asList("Flemming", "Jens", "Gunner", "Bens", "Gert", "Tobias", "Frans", "Emil", "Josefine",
                "Signe", "Maria", "Anna", "Emilie", "Preben"));

        Random random = new Random();
        String navn;
        int maalerNr;

        Forbruger forbruger = new Forbruger("test", 1203, 20000);
        for (int i = 0; i < 200; i++) {
            navn = navne.get(random.nextInt(navne.size()));
            maalerNr = random.nextInt(10000);
            forbruger = new Forbruger(navn, maalerNr, 20000);
            forbruger.aflæsMaaler(random.nextInt(1000));
            forbruger.aflæsMaaler(random.nextInt(1000));
            distrikt.setForbruger(forbruger);
        }

        // Afregner forbrugere
        for (int i = 0; i < distrikt.getForbrugerArray().size(); i++) {
            System.out.println("\nForbrugeren " + distrikt.getForbrugerArray().get(i).getNavn()
                    + " med målernummeret " + distrikt.getForbrugerArray().get(i).getMaalerNr()
                    + " skal betale " + distrikt.afregnForbruger(distrikt.getForbrugerArray().get(i).getMaalerNr())
                    + " kr.");
        }
    }
}