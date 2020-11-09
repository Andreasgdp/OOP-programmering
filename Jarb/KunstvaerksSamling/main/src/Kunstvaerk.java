public abstract class Kunstvaerk {
    private String titel;
    private int aar;
    private Person[] ophavsmaend = new Person[5];
    private int antalOphavsmaend;

    public Kunstvaerk(String enTitel, int etAar) {
        titel = enTitel;
        aar = etAar;
        antalOphavsmaend = 0;
    }

    public String getTitel() {
        return titel;
    }

    public int getAntalOphavsmaend() {
        return antalOphavsmaend;
    }

    public void addOphavsmand(Person enPerson){
        if (antalOphavsmaend < 5) {
            ophavsmaend[antalOphavsmaend] = enPerson;
            antalOphavsmaend++;
        } else {
            System.out.println("Det maksimale antal ophavsmænd er nået!");
        }
    }
}
