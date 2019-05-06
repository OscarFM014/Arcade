import javax.swing.*;

public class BMain {

	public static void main(String[] args) {
		JFrame obj = new JFrame();
		BGamePlay gamePlay = new BGamePlay();
		obj.setBounds(10, 10, 700, 600);
		obj.setTitle("Our Brick Braker");
		obj.setResizable(false);
		obj.add(gamePlay);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}
