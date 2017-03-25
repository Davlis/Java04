import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class FirstJFrame extends JFrame{

	public FirstJFrame(){
		super("Hello World");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int)screenSize.getWidth()/2, (int)screenSize.getHeight()/2);
		setLocationRelativeTo(null);
		
		add(new FigureComponent());

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FirstJFrame();
			}
		});
	}

}
