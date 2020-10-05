public class StringTokenizer {
    private String text;
    private String delim;
    private int index;

    public void StringTokenizer(String source) {
        this.text = source;
        this.delim = "\n";
        this.index = 0;
    }

    public void StringTokenizer(String source, String delimiters) {
        this.text = source;
        this.delim = delimiters;
        this.index = 0;
    }

    public boolean isDelimiter(char character) {
        // If -1: char not in delim
        if (this.delim.indexOf(character) == -1)
            return false;
        else
            return true;
    }

    public boolean hasMoreTokens() {
        // Hej med dig, jeg er mig.
        boolean returnValue = false;
        for (int i = this.index; i < this.text.length(); i++) {
            if (!this.isDelimiter(this.text.charAt(i))) {
                returnValue = true;
            } else {
                returnValue = false;
            }
        }
        return returnValue;
    }
}

// Der er flere ord i teksten, hvis indekset ikke er over det sidste tegn i
// teksten og, der er mindst et tegn efter indekset, som ikke er en delimiter