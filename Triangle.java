/**
 * This class represents triangle by three points
 * supports several operations on triangle
 * @author Olga Mazo and Daniel Zilpa
 */
public class Triangle implements Drawable {

	private Point _p1;
	private Point _p2;
	private Point _p3;

	/**
	 * Constructor
	 * @param p1 - first point of the triangle
	 * @param p2 - second point of the triangle
	 * @param p3 - third point of the triangle
	 */
	public Triangle(Point p1, Point p2, Point p3) {
		//check if the points we got represent triangle
		if (is_valid_triangle(p1, p2, p3)) {
			_p1 = new Point (p1.x(), p1.y());
			_p2 = new Point (p2.x(), p2.y());
			_p3 = new Point (p3.x(), p3.y());
		} 
		else
			//if the points are not represent triangle
			throw new RuntimeException("Error: invalid triangle");
	}

	/**
	 * @return - the first point
	 */
	public Point p1() {

		return _p1;
	}

	/**
	 * @return - the second point
	 */
	public Point p2() {

		return _p2;
	}

	/**
	 * @return - the third point
	 */
	public Point p3() {

		return _p3;
	}

	/**
	 * equals - check if two triangles are equal
	 *@param d - object instance of Drawable
	 * @return - true if d equel to this triangle , otherwise - false 
	 */
	public boolean equals(Drawable d) {
		//check if d is triangle
		if (d instanceof Triangle) {
			// casting to triangle object
			Triangle input = (Triangle) d;

			// if the first point don't equal to any point - return false
			if (!input._p1.equals(_p1) && !input._p1.equals(_p2) && !input._p1.equals(_p3)) {
				return false;
			}
			// if the second point don't equal to any point - return false
			if (!input._p2.equals(_p1) && !input._p2.equals(_p2) && !input._p2.equals(_p3)) {
				return false;
			}
			// if the third point don't equal to any point - return false
			if (!input._p3.equals(_p1) && !input._p3.equals(_p2) && !input._p3.equals(_p3)) {
				return false;
			}

			return true;
		}
	    return false;
	}

	/**
	 *@param p - check whether the point p is contained in the triangle
	 *@return true if p contained in the triangle , otherwise - false 
	 */
	public boolean contains(Point p) {
		
		//calculating the area of the three triangles that are created with the point we received
		double area1 = sub_area(_p1, _p2, p);
		double area2 = sub_area(_p3, _p2, p);
		double area3 = sub_area(_p3, _p1, p);
		
		//return if the sum of the three sub triangles is equal to the area of this triangle
		return ((area1 + area2 + area3) - area()  <= 0.001);		
	}
	
	/**
	 * perimeter - calculate the distance between each two points and sum it
	 *@return the scope of the triangle 
	 */
	public double perimeter() {

		return _p1.distance(_p2) + _p1.distance(_p3) + _p2.distance(_p3);
	}

	/**
	 *area - calculate the area of the triangle by Heron's formula 
	 *https://en.wikipedia.org/wiki/Heron%27s_formula
	 * @return the area of the triangle
	 */
	public double area() {
		double a = _p1.distance(_p2);
		double b = _p1.distance(_p3);
		double c = _p2.distance(_p3);
		double s = perimeter()/2;

		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}

	/**
	 * Translate - Change the coordinates of X and Y of each point of the 
	 * triangle by adding the value of another point
	 *@param p - the point that we add to each point of the triangle
	 */
	public void translate(Point p) {
		_p1.translate(p);
		_p2.translate(p);
		_p3.translate(p);
	}

	/**
	 * is_valid_triangle - this function check if 3 points can represent triangle
	 * @param p1 - first point
	 * @param p2 - second point
	 * @param p3 - third point
	 * @return - true if if triangle, otherwise - false
	 */
	private boolean is_valid_triangle(Point p1, Point p2, Point p3) {
		
		if(p1 !=null && p2 != null && p3!= null)
			return true;
		
		return false;	
	}

	/**
	 * sub_area - calculate the area of the triangle by Heron's formula 
	 *https://en.wikipedia.org/wiki/Heron%27s_formula
	 * @param p1 - the first point
	 * @param p2 - the second point
	 * @param p3 - the third point
	 * @return - the area between the three point
	 */
	private double sub_area(Point p1, Point p2, Point p3) {
		double a = p1.distance(p2);
		double b = p1.distance(p3);
		double c = p2.distance(p3);
		double s = (sub_perimeter(p1,p2,p3))/2;

		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	/**
	 * sub_perimeter - calculate the distance between each two points and sum it
	 * @param p1 - the first point
	 * @param p2 - the second point
	 * @param p3 - the third point
	 * @return - the scope of the triangle 
	 */
	private double sub_perimeter(Point p1, Point p2, Point p3) {

		return p1.distance(p2) + p1.distance(p3) + p2.distance(p3);
	}

}
