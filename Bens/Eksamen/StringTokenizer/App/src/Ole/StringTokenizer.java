package Ole;

public class StringTokenizer
{
    private String  tekst;
    private String  delim;
    private int     indeks;
    
    public StringTokenizer()
    {
        tekst = "N/A";
        delim = "\n ";
        indeks = 0;
    }

    public StringTokenizer(String source)
    {
        tekst = source;
        delim = "\n ";
        indeks = 0;
    }
    
    public StringTokenizer(String source, String del)
    {
        tekst = source;
        delim = del;
        indeks = 0;
    }
    
    public String getTekst()
    {
        return tekst;
    }
    
    public boolean isDelimiter(char etTegn)
    {
        for (int i = 0; i < delim.length(); i++)
        {
             if (etTegn == delim.charAt(i))
                return true;
        }
        return false;       
    }
    
    public boolean hasMoreTokens()
    {
        for (int i = indeks; i < tekst.length(); i++)
            if (!isDelimiter(tekst.charAt(i)))
                return true;
        return false;       
    }
    
    public String nextToken()
    {
        String token = "";
    
        while (indeks < tekst.length() && isDelimiter(tekst.charAt(indeks)))
            indeks++;
        
        while (indeks < tekst.length() && !isDelimiter(tekst.charAt(indeks)))
        {
            token += tekst.charAt(indeks);
            indeks++;
        }
        
        return token;
    }
    
    public String nextToken(String del)
    {
        delim = del;
        return nextToken();
    }
    
    public int countTokens()
    {
        int antal = 0;
        int idx = indeks;
        
        while (hasMoreTokens())
        {
            nextToken();
            antal++;
        }
        
        indeks = idx;
        return antal;
    }
    
    public boolean superfluousDel()
    {
        if (isDelimiter(tekst.charAt(0)) || 
                isDelimiter(tekst.charAt(tekst.length()-1)))
            return true;
                    
        char prev = tekst.charAt(0);
        
        for (int i = 1; i < tekst.length(); i++)
        {
            if (isDelimiter(prev) && isDelimiter(tekst.charAt(i)))
                return true;
            prev = tekst.charAt(i);
        }
        return false;
    }       
    
    public void removeSuperfDel()
    //Pre:  Bør kun kaldes, hvis et forudgående kald til
    //          superfluousDel() returnerer true
    //Post: Overflødige delimiters før første, efter sidste og mellem
    //      tokens er fjernede og indeks nulstillet
    {
        String newTekst = "";
        indeks = 0;
            
        while (indeks < tekst.length() && isDelimiter(tekst.charAt(indeks)))
            indeks++;
            
        while (hasMoreTokens())
        {
            newTekst += nextToken();
            if (hasMoreTokens())
            {
                newTekst += tekst.charAt(indeks);
                indeks++;
                while (indeks < tekst.length() && isDelimiter(tekst.charAt(indeks)))
                    indeks++;
            }
        }   
        tekst = newTekst;   
        indeks = 0;
    }   
        

}