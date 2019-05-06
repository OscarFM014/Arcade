import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BMain extends JFrame {
	public BMain (){
		super("Our Brick Braker");
		BGamePlay gamePlay = new BGamePlay();
		this.setBounds(10, 10, 700, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(gamePlay);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		BMain amp = new BMain();
		
	}

}
