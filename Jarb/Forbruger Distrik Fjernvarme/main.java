public class main {

    public static void main(String[] args) {
        Forbruger forbruger1 = new Forbruger("Bens", 1, 1000);
        Forbruger forbruger2 = new Forbruger("Bandedreas", 2, 1000);

        forbruger1.aflæsMaaler(100);
        forbruger1.aflæsMaaler(200);
        forbruger2.aflæsMaaler(50);
        forbruger2.aflæsMaaler(100);

        Distrikt distrikt1 = new Distrikt("Bens-distrikt", 5);
        distrikt1.setForbruger(forbruger1);
        distrikt1.setForbruger(forbruger2);

        for (int i = 0; i < distrikt1.length; i++) {
            System.out.println(distrikt1);
        }

        distrikt1.afregnForbruger(1);
        distrikt1.afregnForbruger(2);
    }
}