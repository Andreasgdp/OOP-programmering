// Teoretiske emner: simple datatyper og Strings i Java

package Andreas.util;

public class Identifier {
	public int id;
	public int first;
	public int second;
	public int third;
	public int fourth;

	public Identifier(int cprNr) {
		this.id = cprNr % 10000;
		this.first = (cprNr % 10000) / 1000;
		this.second = (cprNr % 1000) / 100;
		this.third = (cprNr % 100) / 10;
		this.fourth = cprNr % 10;
	}
}