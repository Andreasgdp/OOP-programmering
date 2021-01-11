//  Teoretiske emner: access modifiers, arv og andre relationer mellem klasser og objekter (5,8,9).

package Andreas;

public class Person {
    protected String navn;
    protected String sprog;
    protected int foedt;
    protected int doed;

    public Person(String navn, String sprog, int foedt, int doed) {
        this.navn = navn;
        this.sprog = sprog;
        this.foedt = foedt;
        this.doed = doed;
    }
}
