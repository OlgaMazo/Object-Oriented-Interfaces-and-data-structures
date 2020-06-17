/**
 * This class represents a 2d point in the plane.
 * supports several operations on points in the plane.
 * @author Daniel and Olga
 */
public class Point implements Drawable {

	private double _x, _y;

	/**
	 * Point
	 * Point constractor.
	 * @param x1 - x value
	 * @param y1 - y value
	 */
	public Point(double x1, double y1) {
		_x = x1;
		_y = y1;
	}
	
	/**
	 * Point
	 * Copy constructor.
	 * 1)here a direct access to a class memeber is performed,
	 * this will be done only in a constractor to achieve an identical copy 
	 * 2) using a call to another constractor code is not written twice
	 * @param p - the copied point
	 */
	public Point(Point p) {
		this(p._x, p._y);
	}

	/**
	 * x
	 * @return - x value
	 */
	public double x() {
		return _x;
	}

	/**
	 * y
	 * @return - y value
	 */
	public double y() {
		return _y;
	}
	
	/**
	 * toString
	 * @return - a String contains the Point data
	 */
	public String toString() {
		return "name: " + this.getClass() + "[" + _x + "," + _y + "]";
	}

	/**
	 * equals
	 * @param p - other Object (Point)
	 * @return - true iff p instance of Point && logicly the same
	 */
	public boolean equals(Point p) {
		return p != null && p._x == _x && p._y == _y;
	}

	/**
	 * equals
	 * @param d - Drawable object
	 * @return - true if they are equals, otherwise false
	 */
	public boolean equals(Drawable d) {

		//check whether the object is a point type.
		if (d instanceof Point) {
			return equals((Point) d);
		}
		return false;
	}

	/**
	 * contains
	 * @param p - the checked point
	 * @return - true if they are equals, otherwise false
	 */
	public boolean contains(Point p) {
		return equals(p);
	}

	/**
	 * perimeter
	 * @return - 0 (point perimeter is 0)
	 */
	public double perimeter() {
		return 0;
	}

	/**
	 * area
	 * @return - 0 (point area is 0)
	 */
	public double area() {
		return 0;
	}

	/**
	 * translate
	 * Change coordinates of X and Y by adding another point value.
	 * @param p - the added point
	 */
	public void translate(Point p) {
		
		_x = _x + p.x();
		_y = _y + p.y();
	}
	
	/**
	 * distance
	 * Calculate the distance between this point to the input point
	 * @param p1 - the input point
	 * @return - the distance
	 */
	public double distance(Point p1) {

		double x1 = p1.x();
		double y1 = p1.y();
		double x2 = _x;
		double y2 = _y;

		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
}