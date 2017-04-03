import java.awt.Color;
import java.awt.Graphics;

abstract class Polygon implements Figure {
	private Color color;
	private static int polygonCount;
	private int polygonNumber;
	
	public Polygon()
	{
		this.polygonCount += 1;
		this.polygonNumber = this.polygonCount;
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public abstract double countPenimeter();
	public abstract double countArea();
	public abstract void drawFigure(Graphics graphics);
	
	public int getPolygonNumber()
	{
		return polygonNumber;
	}
	
	public int getPolygonCount()
	{
		return polygonCount;
	}
}
