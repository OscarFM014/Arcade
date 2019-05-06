
import java.awt.*;
import javax.swing.*;


public class WWindow extends JFrame{
	//JUST CREATE OUR WINDOW
	private static final long serialVersionUID = -7495712960838659487L; 
	//SERIALIZAR:
	//http://java-white-box.blogspot.com/2013/12/serializar-en-java-serialVersionUID.html
	
	//CONSTRUCTOR WITH PARAMETERS
	public WWindow(int weigth, int height, String title, WGame game){
		//JFrame frame = new JFrame(title);
		/*frame.setPreferredSize(new Dimension(weigth, height));
		frame.setMaximumSize(new Dimension(weigth, height));
		frame.setMinimumSize(new Dimension(weigth, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); 			//THE USER CAN'T CHANGE THE WINDOW SIZE :O
		frame.setLocationRelativeTo(null);	//MIDDLE OF OUR SCREEN
		frame.add(game);					
		frame.setVisible(true);
		game.start();*/
		
		this.setPreferredSize(new Dimension(weigth, height));
		this.setMaximumSize(new Dimension(weigth, height));
		this.setMinimumSize(new Dimension(weigth, height));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 			//THE USER CAN'T CHANGE THE WINDOW SIZE :O
		this.setLocationRelativeTo(null);	//MIDDLE OF OUR SCREEN
		this.add(game);					
		this.setVisible(true);
		game.start();
		
		
	}
	

}
