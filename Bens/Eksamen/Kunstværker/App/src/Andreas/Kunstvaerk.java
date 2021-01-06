//  Teoretiske emner: access modifiers, arv og andre relationer mellem klasser og objekter (5,8,9).

package Andreas;

public abstract class Kunstvaerk {
    protected String titel;
    protected int aar;
    protected Person[] ophavsmænd = new Person[5];
    protected int numOphavsmænd;

    public Kunstvaerk(String titel, int aar) {
        this.titel = titel;
        this.aar = aar;
        this.numOphavsmænd = 0;
    }

    public Person[] getOphavsmænd() {
        return ophavsmænd;
    }

    public int getNumOphavsmænd() {
        return numOphavsmænd;
    }

    public String getTitel() {
        return titel;
    }

    public void addOphavsmand(Person person) {
        if (this.numOphavsmænd < 5) {
            this.ophavsmænd[numOphavsmænd] = person;
            numOphavsmænd++;
        } else {
            System.out.println("Der er for mange ophavsmænd");
        }
    }

}
