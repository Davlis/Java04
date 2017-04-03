/*
 * Created by Dawid Liszka
 */
import java.awt.*;

class Triangle extends Polygon implements Comparable<Triangle>
{
	private Point a;
	private Point b;
	private Point c;
	private Color figureColor;
	
	/*
		 Default constructor Triangle():
		 Pytagoras triangle |A| = 3, |B| = 4, |C| = 5
	*/
	public Triangle() throws Exception
	{
		this.a = new Point(0,0);
		this.b = new Point(3,0);
		this.c = new Point(0,4);
		this.figureColor = Color.RED;
		this.checkIfValid();
	}

	public Triangle(Point a, Point b, Point c) throws Exception
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.figureColor = Color.RED;
		this.checkIfValid();
	}

	public Triangle(Point a, Point b, Point c, Color color) throws Exception
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.figureColor = color;
		this.checkIfValid();
	}

	Triangle(Triangle triangle) throws Exception
	{
		this.a = new Point(triangle.a);
		this.b = new Point(triangle.b);
		this.c = new Point(triangle.c);
		this.figureColor = Color.RED;
		this.checkIfValid();
	}

	Triangle(Triangle triangle, Color color) throws Exception
	{
		this.a = new Point(triangle.a);
		this.b = new Point(triangle.b);
		this.c = new Point(triangle.c);
		this.figureColor = color;
		this.checkIfValid();
	}

	public boolean checkIfValid() throws Exception
	{
		double _a = this.a.getLength(this.b);
		double _b = this.b.getLength(this.c);
		double _c = this.c.getLength(this.a);
		double max = Math.max(_a, Math.max(_b, _c));
		if(2*max < _a+_b+_c) {
			this.checkIfLinear();
			return true;
		}
		throw new Exception("Triangle is not valid");
	}

	public void checkIfLinear() throws Exception
	{
		if( ((this.a.getX() == this.b.getX()) && (this.a.getX() == this.c.getX())) 
			|| (( this.a.getY() == this.b.getY()) && (this.a.getY() == this.c.getY())))
			throw new Exception("Triangle is not valid");
	}

	public void setPointA(Point a) throws Exception
	{
		this.a = a;
		this.checkIfValid();
	}

	public void setPointB(Point b) throws Exception
	{
		this.b = b;
		this.checkIfValid();
	}

	public void setPointC(Point c) throws Exception
	{
		this.c = c;
		this.checkIfValid();
	}

	public Point getPointA()
	{
		return this.a;
	}

	public Point getPointB()
	{
		return this.b;
	}

	public Point getPointC()
	{
		return this.c;
	}

	public double countPenimeter()
	{
		return Point.NORMA(this.a, this.b) + Point.NORMA(this.b, this.c) + Point.NORMA(this.c, this.a);
	}

	public double countArea()
	{
		double p = (0.5)*this.countPenimeter(); 	// half of penimeter
		double a = this.a.getLength(this.b);
		double b = this.b.getLength(this.c);
		double c = this.c.getLength(this.a);
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}

	public double getHeight(int whichVertic) throws IllegalArgumentException
	{
		/*
			 whichVertic :=1 - BC
			 whichVertic :=2 - AC
			 whichVertic :=3 - AB
			 Perfect for enumerable type :)
		*/
		double floor = 0;
		double area = this.countArea();
		boolean status = true;
		switch(whichVertic) {
			case 1 :
				floor = this.b.getLength(this.c);
				break;
			case 2 : 
				floor = this.a.getLength(this.c);
				break;
			case 3 : 
				floor = this.a.getLength(this.b);
				break;
			default: 
				// error? WRONG PARAM
				status = false;
				break;
		}
		if(status == false)
			throw new IllegalArgumentException("Param is not valid");
		return Math.abs( (2*area)/floor );
	}

	@Override
	public String toString()
	{
		String str = "";
		str += "Triangle : "+this.a+", "+this.b+", "+this.c;
		return str;
	}

	@Override
	public int compareTo(Triangle triangle)
	{

		double comparedTriangleArea = triangle.countArea();
		double thisArea = this.countArea();

		if(comparedTriangleArea > thisArea)
			return -1;
		else if(comparedTriangleArea < thisArea)
			return 1;
		else return 0;
	}
	
	public void drawFigure(Graphics g) {
		g.setColor(figureColor);
		int xPoints[] = {(int)a.getX(), (int)b.getX(), (int)c.getX()};
		int yPoints[] = {(int)a.getY(), (int)b.getY(), (int)c.getY()};
		int nPoints = 3;
		g.drawPolygon(xPoints, yPoints, nPoints);
		g.fillPolygon(xPoints, yPoints, nPoints);
	}
	
}
