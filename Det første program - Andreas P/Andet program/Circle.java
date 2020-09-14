public class Circle {
	public static void main(String[] args) {
		Circle circle = new Circle("test");
		System.out.println("name: " + circle.name);
	}

	public String name;

	// Constructor
	public Circle(String name) {
		this.name = name;
	}

	public void send(String name) {

	}

	public int average(int param1, int param2) {
		return (param1 + param2)/2;
	}
}
