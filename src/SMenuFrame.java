import javax.swing.JFrame;

public class SMenuFrame extends JFrame {
	public SMenuFrame() {
		super("Our Snake");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,500);
		
		SMenuPanel p=new SMenuPanel();
		this.add(p);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public static void main(String [] args) {
		SMenuFrame  menu1 =new SMenuFrame();
	}
}