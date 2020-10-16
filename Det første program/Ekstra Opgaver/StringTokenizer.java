public class StringTokenizer {

    public static void main(String[] args) {
        // StringTokenizer tokenizer = new StringTokenizer("Gid du var i Skanderborg og blev der, kære Peter.", " ,.");
        StringTokenizer tokenizer = new StringTokenizer("Gid du var i Skanderborg og blev der, kaere Peter.", " ,.");
        tokenizer.setIndex(6);
        System.out.println("num tokens left: " + tokenizer.countTokens());
        tokenizer.setIndex(36);
        System.out.println("num tokens left: " + tokenizer.countTokens());
        tokenizer.setIndex(49);
        System.out.println("num tokens left: " + tokenizer.countTokens());
    }

    private String text;
    private String delim;
    private int index;

    public StringTokenizer(String source) {
        this.text = source;
        this.delim = "\n";
        this.index = 0;
    }

    public StringTokenizer(String source, String delimiters) {
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
            if (this.index < this.text.length()){
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
    
    public int countTokens() {
        int counter = 0;
        while (this.hasMoreTokens()) {
            this.nextToken();
            counter++;
        }
        return counter;
    }
}