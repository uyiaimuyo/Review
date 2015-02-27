// different access types and how they worked with inheritance - particularly 'protected' inheritance.
// also why interfaces have fields that are always public static final?

// public and protected Shape members are all accessible
// public and protected are all inherited from superclass
// private members are not accessible but can get accessed via public getter

/*
Modifier    | Class | Package | Subclass | World
————————————+———————+—————————+——————————+———————
public      |  y    |    y    |    y     |   y
————————————+———————+—————————+——————————+———————
protected   |  y    |    y    |    y     |   n
————————————+———————+—————————+——————————+———————
no modifier |  y    |    y    |    n     |   n    **also known as package-private**
————————————+———————+—————————+——————————+———————
private     |  y    |    n    |    n     |   n

y: accessible
n: not accessible
*/

public abstract class ShapeAccess {
	
	private int x;
	private int y;
	private int w;
	private int h;
	public int p;
	protected int q;

	public Shape(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	// what would happen if method is protected? private?
	public abstract double calculateArea();

	public int getX() {
		return x;
	}

	public void test() {
	}

}

public class Circle extends Shape {

	private int p; // hides the superclass var p

	// public and protected Shape members are all accessible
	public double CalculateArea() {
		return Math.PI * Math.pow((this.w/2.0), 2);
	}

	// private members are not accessible but can get accessed via public getter

	//overriding test method
	public void test(int x) {

	}

	
}