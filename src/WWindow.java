
import java.awt.*;
import javax.swing.*;


public class WWindow extends Canvas{
	//JUST CREATE OUR WINDOW
	private static final long serialVersionUID = -7495712960838659487L; 
	//SERIALIZAR:
	//http://java-white-box.blogspot.com/2013/12/serializar-en-java-serialVersionUID.html
	
	//CONSTRUCTOR WITH PARAMETERS
	public WWindow(int weigth, int height, String title, WGame game){
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(weigth, height));
		frame.setMaximumSize(new Dimension(weigth, height));
		frame.setMinimumSize(new Dimension(weigth, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); 			//THE USER CAN'T CHANGE THE WINDOW SIZE :O
		frame.setLocationRelativeTo(null);	//MIDDLE OF OUR SCREEN
		frame.add(game);					
		frame.setVisible(true);
		game.start();
		
		
		
	}
	

}
