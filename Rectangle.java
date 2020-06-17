/**
 * This class represents a rectangle by four points. 
 * Supports several operations on rectangle.
 * @author Daniel and Olga.
 */
public class Rectangle implements Drawable {

	private Point _p1, _p2, _p3, _p4;

	/**
	 * Rectangle
	 * Rectangle constractor.
	 * @param p1 - the first point
	 * @param p2 - the second point
	 */
	public Rectangle(Point p1, Point p2) {

		if (is_valid_rectangle(p1, p2)) {
			_p1 = new Point(p1.x(), p1.y());
			_p2 = new Point(p2.x(), p2.y());

			// rectangle features
			_p3 = new Point(_p2.x(), _p1.y());
			_p4 = new Point(_p1.x(), _p2.y());
		
		} 
		else 
			throw new RuntimeException("Error - invalid rectangle");	
	}

	/**
	 * get_p1
	 * @return - the first point of the rectangle
	 */
	public Point p1() {
		return _p1;
	}

	/**
	 * get_p2
	 * @return - the second point of the rectangle
	 */
	public Point p2() {
		return _p2;
	}

	/**
	 * get_p3
	 * @return - the third point of the rectangle
	 */
	public Point p3() {
		return _p3;
	}

	/**
	 * get_p4
	 * @return - the fourth point of the rectangle
	 */
	public Point p4() {
		return _p4;
	}

	/**
	 * equals
	 * Check whether the objects are two equals rectangles.
	 * @param d - Drawable object
	 * @return - true if they are equals, otherwise false
	 */
	public boolean equals(Drawable d) {

		//check whether the object is a rectangle type.
		if (d instanceof Rectangle) {

			//casting to Rectangle object
			Rectangle input = ((Rectangle) d);

			//if the first point don't equals to any point return false
			if (!input._p1.equals(_p1) && !input._p1.equals(_p2) && !input._p1.equals(_p3) && !input._p1.equals(_p4)) {
				return false;
			}

			//if the second point don't equals to any point return false
			if (!input._p2.equals(_p1) && !input._p2.equals(_p2) && !input._p2.equals(_p3) && !input._p2.equals(_p4)) {
				return false;
			}

			//if the third point don't equals to any point return false
			if (!input._p3.equals(_p1) && !input._p3.equals(_p2) && !input._p3.equals(_p3) && !input._p3.equals(_p4)) {
				return false;
			}

			//if the fourth point don't equals to any point return false
			if (!input._p4.equals(_p1) && !input._p4.equals(_p2) && !input._p4.equals(_p3) && !input._p4.equals(_p4)) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * contains
	 * Check whether the point is inside the rectangle.
	 * @param p - the point
	 * @return - true if he is inside, otherwise false
	 */
	public boolean contains(Point p) {

		//find the maximum and minimum value for x and y
		double max_x = Math.max(_p1.x(), _p2.x());
		double min_x = Math.min(_p1.x(), _p2.x());
		double max_y = Math.max(_p1.y(), _p2.y());
		double min_y = Math.min(_p1.y(), _p2.y());

		//check whether the point in the rectangle range
		if (p.x() <= max_x && p.x() >= min_x && p.y() <= max_y && p.y() >= min_y) {
			return true;
		}
		return false;
	}

	/**
	 * perimeter 
	 * Calculate the rectangle perimeter.
	 * @return - the rectangle perimeter
	 */
	public double perimeter() {

		//rectangular perimeter is the sum of the lengths of its four sides
		double d1 = _p1.distance(_p3);
		double d2 = _p2.distance(_p3);

		return (d1 + d2) * 2;
	}

	/**
	 * area 
	 * Calculate the rectangle area.
	 * @return - the rectangle area
	 */
	public double area() {

		//rectangle area is the product of the two ribs perpendicular to each other
		double d1 = _p1.distance(_p3);
		double d2 = _p2.distance(_p3);

		return d1 * d2;
	}

	/**
	 * translate 
	 * Change the coordinates of X and Y of each point of the rectangle by adding the value of the input point.
	 * @param p - the input point
	 */
	public void translate(Point p) {

		_p1.translate(p);
		_p2.translate(p);
		_p3.translate(p);
		_p4.translate(p);
	}


	public void minMaxPerimeter(int num) {

	}

	/**
	 * dx
	 * This function calculates the side of the rectangle parallel to the X axis.
	 * @return - distance between 2 sides on the X axis
	 */
	public double dx() {
		return _p1.distance(_p3);
	}

	/**
	 * dy
	 * This function calculates the side of the rectangle parallel to the Y axis.
	 * @return - distance between 2 sides on the Y axis
	 */
	public double dy() {
		return _p2.distance(_p3);
	}

	/**
	 * Is_valid_rectangle
	 * This function check it two points can represent rectangle.
	 * @param p1 - first point
	 * @param p2 - second point
	 * @return - true if it can be rectangle, otherwise - false
	 */
	private boolean is_valid_rectangle(Point p1, Point p2) {

		if(p1 != null && p2 != null)
			return true;

		return false;
	}
}