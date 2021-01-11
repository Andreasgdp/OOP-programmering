// Teoretiske emner: metoder i Java, call by value, call by reference (1.3-4, 1.13-14)

package Andreas;

public class StringTokenizer {

    private final String text;
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

    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer("abc def ghi", " ,.");
        tokenizer.setIndex(0);
        System.out.println("Next tokens: " + tokenizer.nextToken());
        System.out.println("Next tokens: " + tokenizer.nextToken());
        System.out.println("Next tokens: " + tokenizer.nextToken());
        System.out.println("Next tokens: " + tokenizer.nextToken());
        System.out.println("Next tokens: " + tokenizer.nextToken());
    }

    public boolean isDelimiter(char character) {
        return this.delim.indexOf(character) != -1;
    }

    public boolean hasMoreTokens() {
        for (int i = this.index; i < this.text.length(); i++) {
            if (!this.isDelimiter(this.text.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String nextToken() {
        StringBuilder returnValue = new StringBuilder();
        if (!this.hasMoreTokens()) {
            returnValue = new StringBuilder();
            if (this.index < this.text.length()) {
                this.index++;
            }
        } else {
            for (int i = this.index; i < this.text.length(); i++) {
                if (!this.isDelimiter(this.text.charAt(i))) {
                    returnValue.append(this.text.charAt(i));
                    this.index = (i == this.text.length() - 1) ? this.index = i + 1 : this.index;
                } else if (this.isDelimiter(this.text.charAt(i)) && returnValue.length() > 0) {
                    this.index = i;
                    break;
                }
            }
        }
        return returnValue.toString();
    }

    public String nextToken2() {
        StringBuilder token = new StringBuilder();

        while (index < text.length() && isDelimiter(text.charAt(index)))
            index++;

        while (index < text.length() && !isDelimiter(text.charAt(index))) {
            token.append(text.charAt(index));
            index++;
        }

        return token.toString();
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