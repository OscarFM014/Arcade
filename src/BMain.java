import javax.swing.*;

public class BMain extends JFrame {
	public BMain (){
		super("Our Brick Braker");
		BGamePlay gamePlay = new BGamePlay();
		this.setBounds(10, 10, 700, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(gamePlay);
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		BMain  amp = new BMain();
		
	}

}
