// Teoretiske emner: access modifiers, arv og andre relationer mellem klasser og objekter

public abstract class Kunstvaerk {
    protected String titel;
    protected int aar;
    protected Person[] ophavsmaend = new Person[5];
    protected int antalOphavsmaend;

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
