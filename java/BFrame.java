import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class BFrame extends JFrame{

	public BFrame() {
		this.setSize(300,200);
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dim2 = this.getSize();
		int x,y;
		x=(int)(dim.getWidth()/2 - dim2.getWidth());
		y=(int)(dim.getHeight()/2 - dim2.getHeight());
		this.setLocation(x, y);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
