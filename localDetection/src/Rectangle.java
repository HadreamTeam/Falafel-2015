
import java.util.ArrayList;
import java.util.Arrays;

public class Rectangle {
	
	private Point topRight, topLeft, bottomRight, bottomLeft;
	
	public Rectangle(Point p[])
	{
		assert p.length < 4;
		
		topLeft = p[0];
		topRight = p[1];
		
		topLeft = Point.leftestPoint(p);
		ArrayList<Point> tempoints = new ArrayList<Point>(Arrays.asList(p));
		tempoints.remove(topLeft);
		
		bottomLeft = Point.leftestPoint(Arrays.copyOf(tempoints.toArray(), tempoints.toArray().length, Point[].class));
		
		tempoints.remove(bottomLeft);
		topRight = tempoints.get(0);
		bottomRight = tempoints.get(1);
		
		sortTopAndBottom(topLeft, bottomLeft);
		sortTopAndBottom(topRight, bottomRight);
		
		
	}
	
	// doesn't matter if really top and bottom, name of the original variable's
	// name is important.
	public void sortTopAndBottom(Point top, Point bottom)
	{
		if(top.getY() > bottom.getY())
		{
			Point temp = top;
			top = bottom;
			bottom = temp;
		}
	}
	
	public String toString()
	{
		return topLeft + "_____" + topRight + "\n|\n|\n|\n" + bottomLeft + "_____" + bottomRight;
	}
}