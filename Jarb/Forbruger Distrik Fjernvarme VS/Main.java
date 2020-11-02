public class Main {
    public static void main(String[] args) {
        Distrikt distrikt = new Distrikt("Distriktet", 9.98);
        System.out.printf("I distriktet '%s' er følgende forbrugere:", distrikt.getDistriktNavn());

        Forbruger forbruger1 = new Forbruger("Jens", 1, 1000);
        Forbruger forbruger2 = new Forbruger("Peter", 2, 1000);

        distrikt.setForbruger(forbruger1);
        distrikt.setForbruger(forbruger2);

        forbruger1.aflæsMaaler(100);
        forbruger1.aflæsMaaler(200);
        forbruger2.aflæsMaaler(50);
        forbruger2.aflæsMaaler(100);

        distrikt.afregnForbruger(1);
        distrikt.afregnForbruger(2);
    }
}