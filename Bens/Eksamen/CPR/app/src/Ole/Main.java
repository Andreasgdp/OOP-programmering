//  Teoretiske emner: simple datatyper og Strings i Java (Appendix B, 5 og især 5.3).

package Ole;

public class Main
{
    public static void main(String[] args)
    {
        CprNr mor = new CprNr("0502201972");
        String ugedag = mor.getDato().ugeDagTekst();
        System.out.println("Mor er født på en "+ugedag);
        CprNr ole = new CprNr("1407532127");
        ugedag = ole.getDato().ugeDagTekst();
        System.out.println("Ole er født på en "+ugedag);
    }
    
}
