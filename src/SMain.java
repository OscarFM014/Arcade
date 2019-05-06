import java.awt.Color;

import javax.swing.JFrame;

public class SMain extends JFrame {
	public SMain (){
		super("Our Snake");
		this.setBounds(10, 10, 905, 700);
		this.setBackground(Color.DARK_GRAY);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SGameplay gameplay = new SGameplay();
		this.add(gameplay);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		SMain  amp = new SMain();
		
	}

	
}
