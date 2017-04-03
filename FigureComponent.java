import java.util.ArrayList;
import java.util.List;
import java.util.*;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class FigureComponent extends JPanel {
	// has method paintComponent
	// should extends JPanel or JComponent(it's abstract - so implements)
	
	public FigureComponent() {
		super();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		try{
			Triangle T1 = new Triangle(new Point(12,38), new Point(40, 12), new Point(78,30), Color.YELLOW);
			Triangle T2 = new Triangle(new Point(0,0), new Point(100,100), new Point(200,100), Color.CYAN);
			Quadrangle Q1 = new Quadrangle(new Point(100,200), new Point(100,400), new Point(312,345), new Point(400,100), Color.RED);
			Quadrangle Q2 = new Quadrangle(new Point(200,200), new Point(300,400), new Point(412,345), new Point(500,100), Color.GREEN);
			List<Polygon> listOfPolygons = new ArrayList<Polygon>();
			listOfPolygons.add(T1);
			listOfPolygons.add(T2);
			listOfPolygons.add(Q1);
			listOfPolygons.add(Q2);
            ListIterator<Polygon> ListIteratorForPolygons = listOfPolygons.listIterator();
            while(ListIteratorForPolygons.hasNext())
            {
            	ListIteratorForPolygons.next().drawFigure(g);
            }
            Figure[] array;
            array = new Figure[]{new Triangle(new Point(0,0), new Point(100, 200), new Point(400,400), Color.YELLOW)};
    		for(Figure p: array)
    			p.drawFigure(g);
            
		} catch(Exception e){
			System.out.println(e);
		}
		

	}
}
