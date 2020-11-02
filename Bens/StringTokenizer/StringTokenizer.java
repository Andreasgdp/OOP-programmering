public class StringTokenizer {

    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer("abc def ghi", " ,.");
        tokenizer.setIndex(0);
        System.out.println("Next tokens: " + tokenizer.nextToken());
        System.out.println("Next tokens: " + tokenizer.nextToken());
        System.out.println("Next tokens: " + tokenizer.nextToken());
        System.out.println("Next tokens: " + tokenizer.nextToken());
        System.out.println("Next tokens: " + tokenizer.nextToken());
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
                    this.index = (i == this.text.length() - 1) ? this.index = i + 1 : this.index;
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