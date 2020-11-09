public abstract class Kunstvaerk {
    private String titel;
    private int aar;
    private Person[] ophavsmænd = new Person[5];
    private int numOphavsmænd;

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
        if(this.numOphavsmænd < 5) {
            this.ophavsmænd[numOphavsmænd] = person;
            numOphavsmænd++;
        } else {
            System.out.println("Der er for mange ophavsmænd");
        }
    }
}
