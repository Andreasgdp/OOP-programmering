// Teoretiske emner: access modifiers, arv og andre relationer mellem klasser og objekter

public class Person {
    protected String navn;
    protected String land;
    protected int foedt;
    protected int doed;

    public Person(String etNavn, String etLand, int enFoedt, int enDoed) {
        navn = etNavn;
        land = etLand;
        foedt = enFoedt;
        doed = enDoed;
    }

}
