import java.awt.*;

public interface Figure 
{
	abstract void setColor(Color color);
	abstract double countPenimeter();
	abstract double countArea();
	abstract void drawFigure(Graphics graphics);
}
