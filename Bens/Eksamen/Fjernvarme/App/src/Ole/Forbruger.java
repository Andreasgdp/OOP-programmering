package Ole;

class Forbruger
{
    private     String      navn;
    private     int         maalerNr;
    private     int         nyAflaesning;
    private     int         forrigeAflaesning;
    private     int         maalerMax;
    
    public Forbruger()
    {
    }
    
    public Forbruger(String etNavn, int etMaalerNr, int maximum)
    {
        navn     = etNavn;  
        maalerNr  = etMaalerNr;
        maalerMax = maximum;
    }
    
    public int getMaalerNr()
    {
        return maalerNr;
    }
    
    public void setNavn(String etNavn)
    {
        navn = etNavn;
    }
    
    public String getNavn()
    {
        return navn;
    }
    
    public void aflaesMaaler(int aflaesning)
    {
        forrigeAflaesning = nyAflaesning;
        nyAflaesning = aflaesning;
    }
    
    public int beregnForbrug()
    {
        if (nyAflaesning < forrigeAflaesning)
            return nyAflaesning + maalerMax - forrigeAflaesning;
        else
            return nyAflaesning - forrigeAflaesning;
    }
}