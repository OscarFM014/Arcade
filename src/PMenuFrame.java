
import javax.swing.JFrame;

public class PMenuFrame extends JFrame {
	public PMenuFrame() {
		super("PONG");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,500);
		
		PMenuPanel p = new PMenuPanel();
		this.add(p);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public static void main(String [] args) {
		PMenuFrame  menu1 =new PMenuFrame();
	}
}