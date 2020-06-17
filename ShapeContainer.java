/**
 * This class contains Drawable objects (Point, Triangle, Rectangle
 * Supports several operations on Drawable objects
 * @author Daniel and Olga.
 */
public class ShapeContainer {

	public static final int INIT_SIZE = 10;
	public static final int RESIZE = 10;
	private int current_count = 0;
	private Drawable[] arr;

	/**
	 *ShapeContainer
	 *constructor
	 *create new array of Drawable
	 */
	public ShapeContainer() {

		arr = new Drawable[INIT_SIZE];
	}

	/**
	 * ShapeContainer
	 * Copy constructor
	 * @param other - the object that we copy
	 */
	public ShapeContainer(ShapeContainer other) {

		copy_shape_container_by_size(other.arr, other.arr.length, other.current_count);
		current_count = other.current_count;

	}

	/**
	 * Size
	 * Return how many shapes there are in the array now
	 * @return - how many objects there are in the array
	 */
	public int size() {

		return current_count;
	}

	/**
	 * T_size
	 * Calculate and return how many triangles there are in the array
	 * @return - how many triangles there are in the array
	 */
	public int T_size() {
		int countTriangle = 0;
		// go through the ShapeContainer and each time we encounter a triangle we count it
		for (int i = 0; i < current_count; i++) {
			if (arr[i] instanceof Triangle)
				countTriangle++;
		}
		return countTriangle;
	}

	/**
	 * R_size
	 * Calculate and return how many rectangles there are in the array
	 * @return - how many rectangles there are in the array
	 */
	public int R_size() {
		int countRectangle = 0;
		// go through the ShapeContainer and each time we encounter a rectangle we count it
		for (int i = 0; i < current_count; i++) {
			if (arr[i] instanceof Rectangle)
				countRectangle++;
		}
		return countRectangle;
	}

	/**
	 * Add
	 * Add new shape to the array
	 * @param d - new shape to add to the array
	 */
	public void add(Drawable d) {
		// if there are no place in the array - increase it
		if (arr.length == current_count) {
			copy_shape_container_by_size(arr, arr.length + RESIZE, current_count);
		}

		// add the new Drawable object to the array
		arr[current_count] = d;
		current_count++;
	}

	/**
	 * Remove
	 * Remove from the array all the shapes that contains the point p
	 * and blinking array spaces after the remove
	 * @param p - all shapes containing this point will be deleted
	 */
	public void remove(Point p) {
		int count_after_remove = current_count;
		//go through all the array elements
		for (int i = 0; i < current_count; i++) {
			//check if it triangle that contains the point
			if (arr[i] instanceof Triangle) {
				//if it contains the point "remove" it
				if (((Triangle) arr[i]).contains(p)) {
					count_after_remove--;
					arr[i] = null;
				}
			}
			//check if it rectangle that contains the point
			else if (arr[i] instanceof Rectangle) {
				//if it contains the point "remove" it
				if (((Rectangle) arr[i]).contains(p)) {
					count_after_remove--;
					arr[i] = null;
				}
			}
		}	
		//calculate the new size of the array
		int size = current_count + (10 - (current_count%10));
		//reduced profits in the array
		copy_shape_container_by_size(arr, size, current_count);	
		current_count = count_after_remove;
		
	}
	
	/**
	 * T_at
	 * Return the i triangle
	 * @param i - serial number of triangle that we looking for
	 * @return - the i triangle
	 */
	public Triangle T_at(int i) {
		int count = 0;
		//go through all the array elements
		for(int j=0; j<current_count; j++) {
			//check if it Triangle
			if (arr[j] instanceof Triangle) {
				//if it the i triangle create a copy of it and return it
				if(i == count) {
				return new Triangle(((Triangle)arr[j]).p1(), ((Triangle)arr[j]).p2(), ((Triangle)arr[j]).p3());
				}
				count++;
			}
		}
		return null;
	}
	
	/**
	 * R_at
	 * Return the i rectangle
	 * @param i - serial number of rectangle that we looking for
	 * @return - the i rectangle
	 */
	public Rectangle R_at(int i) {
		int count = 0;
		//go through all the array elements
		for(int j=0; j<current_count; j++) {
			//check if it Rectangle
			if (arr[j] instanceof Rectangle) {	
				//if it the i Rectangle create a copy of it and return it
				if(i == count) {
				return new Rectangle(((Rectangle)arr[j]).p1(), ((Rectangle)arr[j]).p2());
				}
				count++;
			}
		}
		return null;		
	}
	
	/**
	 * SumArea
	 * Calculate and return the sum of all area's of the rectangles and triangles in the array
	 * @return - the sum of all rectangles and triangles in the array
	 */
	public double sumArea() {
		
		double sum = 0.0;
		//go through all the array elements
		for(int i=0; i<current_count; i++) {
			//if it triangle calculate it's sum and sum it
			if (arr[i] instanceof Triangle)
				sum = sum + ((Triangle)arr[i]).area();
			
			//if it rectangle calculate it's sum and sum it
			else if (arr[i] instanceof Rectangle)
				sum = sum +((Rectangle)arr[i]).area();
		}
		return sum;
	}
	
	/**
	 * Translate
	 * Change the coordinates of X and Y of each point of the shapes by adding the 
	 * value of the input point
	 * @param p - the input point
	 */
	public void translate(Point p) {
		//go through all the array elements and do the translate function for each
		for(int i=0; i<current_count; i++) {
			if (arr[i] instanceof Point)
				((Point)arr[i]).translate(p);
			
			else if (arr[i] instanceof Triangle)
				((Triangle)arr[i]).translate(p);
			
			else if (arr[i] instanceof Rectangle)
				((Rectangle)arr[i]).translate(p);		
		}	
	}
	
	/**
	 * MinMaxPerimeter
	 * Print the perimeter that is largest and smallest of a triangle and a rectangle
	 * @param num
	 */
	public void minMaxPerimeter(int num) {
		
		double min_T = 0;
		double max_T = 0;
		double min_R = 0;
		double max_R = 0;
		
		//go through the all array
		for (int i=0; i<current_count; i++) {
			//if it triangle check if it scope bigger than the max or smaller than the min
		    if (arr[i] instanceof Triangle) {
		    	if(((Triangle)arr[i]).perimeter()> max_T)
		    		max_T = ((Triangle)arr[i]).perimeter();
		    	else if (((Triangle)arr[i]).perimeter()< min_T)
		    		min_T = ((Triangle)arr[i]).perimeter();
		    }
		  //if it rectangle check if it scope bigger than the max or smaller than the min
		    else if (arr[i] instanceof Rectangle) {	
		    	if(((Rectangle)arr[i]).perimeter()> max_R)
		    		max_R = ((Rectangle)arr[i]).perimeter();
		    	else if (((Rectangle)arr[i]).perimeter()< min_R)
		    		min_R = ((Rectangle)arr[i]).perimeter();
		    }	
		}
		
		//print the results
		System.out.println("The min triangle perimeter is: " + min_T);
		System.out.println("The max triangle perimeter is: " + max_T);
		System.out.println("The min rectangle perimeter is: " + min_R);
		System.out.println("The max rectangle perimeter is: " + max_R);
	}

	/**
	 * Copy_shape_container_by_size
	 * Copy all the shapes to this array - by creating new objects
	 * @param other - the array that we copy
	 * @param size - the size of the new array 
	 * @param current_count - how many shapes there are in the copied array
	 */
	private void copy_shape_container_by_size(Drawable [] other, int size, int current_count) {

		arr = new Drawable[size];
		//index in the new array
		int l = 0;

		for (int i = 0; i < current_count; i++) {

			// if it a Point object, create a new same point and put it in this array
			if (other[i] instanceof Point) {

				arr[l] = new Point(((Point)other[i]).x(), ((Point) other[i]).y());
				l++;
			}
			// if it a Triangle object, create a new same triangle and put it in this array
			else if (other[i] instanceof Triangle) {

				arr[l] = new Triangle(((Triangle) other[i]).p1(), ((Triangle) other[i]).p2(),
						((Triangle) other[i]).p3());
				l++;
			}
			// if it a Rectangle object, create a new same Rectangle and put it in this array
			else if (other[i] instanceof Rectangle) {

				arr[l] = new Rectangle(((Rectangle) other[i]).p1(), ((Rectangle) other[i]).p2());
				l++;
			}
		}
	}

}
