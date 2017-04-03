/*
 * Created by Dawid Liszka
 */

import java.awt.*;
class Quadrangle extends Polygon implements Comparable<Quadrangle>
{
	private Point a;
	private Point b;
	private Point c;
	private Point d;
	private Color figureColor;

/*
	Runtime exception serve a specific purpose - 
	they signal programming problems that can be fixed only by changing code, 
	as opposed to changing the environment in which the program runs.

	WHEN RE-THROWING : RuntimeException(originalException)
*/

	public Quadrangle() throws Exception
	{
		this.a = new Point(0,0);
		this.b = new Point(2,0);
		this.c = new Point(2,2);
		this.d = new Point(0,2);
		this.figureColor = Color.BLACK;
		this.checkIfValid();
	}

	public Quadrangle(Point a, Point b, Point c, Point d) throws Exception
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.figureColor = Color.BLACK;
		this.checkIfValid();
	}

	public Quadrangle(Quadrangle quadrangle) throws Exception
	{
		this.a = new Point(quadrangle.a);
		this.b = new Point(quadrangle.b);
		this.c = new Point(quadrangle.c);
		this.d = new Point(quadrangle.d);
		this.figureColor = Color.BLACK;
		this.checkIfValid();
	}
	
	public Quadrangle(Point a, Point b, Point c, Point d, Color color) throws Exception
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.figureColor = color;
		this.checkIfValid();
	}

	public Quadrangle(Quadrangle quadrangle, Color color) throws Exception
	{
		this.a = new Point(quadrangle.a);
		this.b = new Point(quadrangle.b);
		this.c = new Point(quadrangle.c);
		this.d = new Point(quadrangle.d);
		this.figureColor = color;
		this.checkIfValid();
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

	public void setPointD(Point d) throws Exception
	{
		this.d = d;
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

	public Point getPointD()
	{
		return this.d;
	}

	public boolean checkIfValid() throws Exception
	{
		double a = this.a.getLength(this.b);
		double b = this.b.getLength(this.d);
		double c = this.c.getLength(this.a);
		double d = this.a.getLength(this.d);

		double _MAX = this.max(a,b,c,d);
		if(2*_MAX < a+b+c+d) {
			this.checkIfLinear();
			return true;
		}
		throw new Exception("Quadrangle is not valid");

	}

	public void checkIfLinear() throws Exception
	{
		if( ((this.a.getX() == this.b.getX()) && (this.a.getX() == this.c.getX()) && (this.a.getX() == this.d.getX())) 
			|| (( this.a.getY() == this.b.getY()) && (this.a.getY() == this.c.getY()) && (this.a.getY() == this.d.getY())))
			throw new Exception("Quadrangle is not valid");
	}

	public double max(double a, double b, double c, double d)
	{
		return Math.max(Math.max(a,b), Math.max(c, d));
	}

	public double countPenimeter()
	{
		double a = this.a.getLength(this.b);
		double b = this.b.getLength(this.d);
		double c = this.c.getLength(this.a);
		double d = this.a.getLength(this.d);
		return a + b + c + d;
	}

	public double countArea()
	{
		return Math.abs((a.getX()*b.getY() - a.getY()*b.getX()) + (b.getX()*c.getY() - b.getY()*c.getX()) + (c.getX()*d.getY() - c.getY()*d.getX()) + (d.getX()*a.getY() - d.getY()*a.getX()))/2.0; 
	}

    public double diagonal(Point point) throws IllegalArgumentException
    {
        if(this.a.equals(point) || this.c.equals(point))
        {
            return this.a.getLength(this.c);
        }
        else if(this.b.equals(point) || this.d.equals(point))
        {
            return this.b.getLength(this.d);
        }
        else
        {
            throw new IllegalArgumentException("Param is not valid");
        }
    }

	@Override
	public int compareTo(Quadrangle quadrangle)
	{
		double comparedQuadrangleArea = quadrangle.countArea();
		double thisArea = this.countArea();

		if(comparedQuadrangleArea > thisArea)
			return -1;
		else if(comparedQuadrangleArea < thisArea)
			return 1;
		else return 0;
	}
	
	@Override
	public String toString()
	{
		String str = "";
		str += "Quadrangle : "+this.a+", "+this.b+", "+this.c+", "+this.d;
		return str;
	}
	
	public void drawFigure(Graphics g) {
		g.setColor(figureColor);
		int xPoints[] = {(int)a.getX(), (int)b.getX(), (int)c.getX(), (int)d.getX()};
		int yPoints[] = {(int)a.getY(), (int)b.getY(), (int)c.getY(), (int)d.getY()};
		int nPoints = 4;
		g.drawPolygon(xPoints, yPoints, nPoints);
		g.fillPolygon(xPoints, yPoints, nPoints);
	}
	
}