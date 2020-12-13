public class Main {
    public static void main(String[] args) {
        Husdyr[] husdyr = new Husdyr[3];

        Kat miver = new Kat("Miver", "Mus");
        Date msk = new Date(20201022);
        Hund mimse = new Hund("Mimi", "Kødben", msk);
        Gris offe = new Gris("Øffe", "Gulerod");

        husdyr[0] = miver;
        husdyr[1] = mimse;
        husdyr[2] = offe;

        for (int i = 0; i < husdyr.length; i++) {
            System.out.println(husdyr[i].getNavn() + " " + husdyr[i].givLyd());
        }
    }
}
