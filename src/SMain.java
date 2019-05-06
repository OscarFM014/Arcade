
import java.awt.Color;

import javax.swing.JFrame;

public class SMain extends JFrame {
	
	public SMain() {
		super("Our Snake");
		SGameplay gameplay = new SGameplay();
		this.setBounds(10, 10, 905, 700);
		this.setBackground(Color.DARK_GRAY);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(gameplay);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	public static void main(String[] args) {
		SMain m = new SMain();
	}
	
}