import java.awt.Color;

import javax.swing.JFrame;

public class SMain {

	public static void main(String[] args) {
		JFrame obj = new JFrame();
		SGameplay gameplay = new SGameplay();
		
		obj.setBounds(10, 10, 905, 700);
		obj.setBackground(Color.DARK_GRAY);
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gameplay);
		
	}
	
}
