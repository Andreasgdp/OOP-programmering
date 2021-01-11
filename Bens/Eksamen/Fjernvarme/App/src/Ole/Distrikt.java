package Ole;

class Distrikt
{
    private String          navn;
    private float           prisPrM3;
    private Forbruger[]     forbrugere;
    private int             antalForbrugere;
        
    public Distrikt()
    {
    }

    public Distrikt(String etNavn, float enPris)
    {
        navn                = etNavn;
        prisPrM3            = enPris;
        forbrugere          = new Forbruger[200]; 
        antalForbrugere     = 0;
    }

    public float afregnForbruger(int etMaalerNr)
    {
        for (int i=0; i < antalForbrugere; i++)
            if (etMaalerNr == forbrugere[i].getMaalerNr())
                return prisPrM3*(forbrugere[i].beregnForbrug());
   
        return -1;
    }
    
    public boolean setForbruger(Forbruger enForbruger)
    {
        if (antalForbrugere < 200)
        {
            forbrugere[antalForbrugere] = (Forbruger) enForbruger;  
            antalForbrugere++;
            return true;
        }
        return false;
    }   
        
}
