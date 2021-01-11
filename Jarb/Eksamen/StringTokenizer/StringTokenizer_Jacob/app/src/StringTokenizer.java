// Teoretiske emner: metoder i Java, call by value, call by reference

public class StringTokenizer {

    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer("Gid du var i Skanderborg og blev der, kaere Peter.", " ,.");

        System.out.println("Opg.2 -----------------------------------------------");
        System.out.println("'.' er delimiter: " + tokenizer.isDelimiter('.'));
        System.out.println("'a' er delimiter: " + tokenizer.isDelimiter('a'));

        System.out.println("\nOpg.3 -----------------------------------------------");
        tokenizer.setIndex(6);
        System.out.println("Der er flere tokens: " + tokenizer.hasMoreTokens());
        tokenizer.setIndex(49);
        System.out.println("Der er flere tokens: " + tokenizer.hasMoreTokens());

        System.out.println("\nOpg.4 -----------------------------------------------");
        tokenizer.setIndex(6);
        System.out.println("Næste token: " + tokenizer.nextToken());
        System.out.println("Indexet er nu: " + tokenizer.getIndex());
        tokenizer.setIndex(36);
        System.out.println("Næste token: " + tokenizer.nextToken(" ,.?!#/%"));
        System.out.println("Indexet er nu: " + tokenizer.getIndex());
        tokenizer.setIndex(49);
        System.out.println("Næste token: " + tokenizer.nextToken());
        System.out.println("Indexet er nu: " + tokenizer.getIndex());

        System.out.println("\nOpg.5 -----------------------------------------------");
        tokenizer.setIndex(6);
        System.out.println("Antal tokens tilbage efter index 6: " + tokenizer.countTokens());
        tokenizer.setIndex(49);
        System.out.println("Antal tokens tilbage efter index 49: " + tokenizer.countTokens());
    }

    // Attributter
    private String text;
    private String delim;
    private int index;

    // Constructors (Opgave 1)
    public StringTokenizer(String source) {
        this.text = source;
        this.delim = "\n ";
        this.index = 0;
    }

    public StringTokenizer(String source, String delimiters) {
        this.text = source;
        this.delim = delimiters;
        this.index = 0;
    }

    // Metoder
    public boolean isDelimiter(char character) {
        if (this.delim.indexOf(character) == -1)
            return false;
        else
            return true;
    }

    public boolean hasMoreTokens() {
        boolean returnValue = false;
        for (int i = this.index; i < this.text.length(); i++) {
            if (!this.isDelimiter(this.text.charAt(i))) {
                returnValue = true;
                break;
            } else {
                returnValue = false;
            }
        }
        return returnValue;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String nextToken() {
        String returnValue = "";
        if (!this.hasMoreTokens()) {
            returnValue = "";
            if (this.index < this.text.length()) {
                this.index++;
            }
        } else {
            for (int i = this.index; i < this.text.length(); i++) {
                if (!this.isDelimiter(this.text.charAt(i))) {
                    returnValue += this.text.charAt(i);
                } else if (this.isDelimiter(this.text.charAt(i)) && returnValue.length() > 0) {
                    this.index = i;
                    break;
                }
            }
        }
        return returnValue;
    }

    public String nextToken(String delimiters) {
        this.delim = delimiters;
        return this.nextToken();
    }

    public int getIndex() {
        return index;
    }

    public int countTokens() {
        int counter = 0;
        while (this.hasMoreTokens()) {
            this.nextToken();
            counter++;
        }
        return counter;
    }
}