import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import sun.audio.*;


public class BGamePlay extends JPanel implements KeyListener, ActionListener {
	
	private boolean play = false; 
	private int score = 0;
	private int totalBricks = 21;
	
	private Timer timer;
	private int delay = 8;
	
	private int playerX = 310;
	
	
	private int ballPosX = 120;
	private int ballPosY = 350;
	
	private int ballXDir = -1;
	private int ballYDir = -2;
	
	private BMapGenerator map;
	
	BAudio audio = new BAudio();
    AudioClip fondo = audio.getAudio("/res/AudioBrick.wav");
	
    private JButton btnexit;
    
	public BGamePlay(){
		map = new BMapGenerator (3,7);
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		fondo.loop();
	}
	
	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0,0,700, 600);
		
		map.draw((Graphics2D)g);
		
		g.setColor(Color.cyan);
		g.fillRect(0,0,3, 600);
		g.fillRect(0,0,700, 3);
		g.fillRect(697,0,3, 600);
		
		
		
		
		//SCORE
		g.setColor(Color.WHITE);
		g.setFont(new Font("IMPACT", Font.BOLD, 25));
		g.drawString(""+ score + " points!" , 590, 30);
		
		g.setColor(Color.GREEN);
		g.fillRect(playerX, 550, 100,8);
		
		g.setColor(Color.YELLOW);
		g.fillOval(ballPosX, ballPosY, 20, 20);
		
		
		
		if(totalBricks <= 0){
			play = false;
			ballXDir = 0;
			ballYDir = 0;
			g.setColor(Color.WHITE);
			g.setFont(new Font("IMPACT", Font.BOLD, 30));
			g.drawString("You Won!!!!!", 230, 300);
			g.drawString("Total Points "+ score , 230, 350);
			
			g.setFont(new Font("IMPACT", Font.BOLD, 20));
			g.drawString("Press Enter To Play Again!!" , 230, 400);
		}
		
		
		if(ballPosY > 570){
			play = false;
			ballXDir = 0;
			ballYDir = 0;
			g.setColor(Color.WHITE);
			g.setFont(new Font("IMPACT", Font.BOLD, 30));
			g.drawString("Game Over!", 230, 300);
			g.drawString("Total Points "+ score , 230, 350);
			
			g.setFont(new Font("IMPACT", Font.BOLD, 20));
			g.drawString("Press Enter To Play Again!!" , 230, 400);
		}
		
		
		
		g.dispose();
		
	}
	
	
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(playerX > 587){
				playerX = 587;
			} else{
				moveRight();
			}
		}
		
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if(playerX <= 10){
				playerX = 10;
			} else{
				moveLeft();
			}
		}
		
	
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			if(!play){
				ballPosX = 120;
				ballPosY = 350;
				
				ballXDir = -1;
				ballYDir = -2;
				
				playerX = 310;
				score = 0;
				
				totalBricks = 21;
				map = new BMapGenerator(3,7);
			
				BMenuFrame a = new BMenuFrame();
				fondo.stop();
				a.setVisible(true);
				this.setVisible(false); 
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
			fondo.stop();
			System.exit(1);
		}
}

		public void moveRight(){
			play = true;
			playerX +=20;
		}
		
		public void moveLeft(){
			play = true;
			playerX -=20;
		}
		



	public void actionPerformed(ActionEvent e) {
		timer.start();
		
	
		
		if(new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))){
			ballYDir = -ballYDir;
		}
		
		A: for(int i = 0; i < map.map.length; i++){
			for(int j = 0; j < map.map[0].length; j++){
				if(map.map[i][j] > 0){
					int brickX = j * map.brickWidth + 80;
					int brickY = i * map.brickHeight + 50;
					int brickWidth = map.brickWidth;
					int brickHeight = map.brickHeight;
					
					Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
					Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20, 20);
					Rectangle brickRect = rect;
					
					if(ballRect.intersects(brickRect)){
						map.setBrickValue(0, i, j);
						totalBricks --;
						score += 5;
						
						
						if(ballPosX + 19 <= brickRect.x || ballPosX+1 >= brickRect.x +  brickWidth){
							ballXDir = -ballXDir;
						}else{
							ballYDir = -ballYDir;
						
						}
						
						break A;
					}
				}
			}
		}
		
		if(play){
			ballPosX += ballXDir;
			ballPosY += ballYDir;
			
			if(ballPosX < 0){
				ballXDir = -ballXDir;
			}
			if(ballPosY < 0){
				ballYDir = -ballYDir;
			}
			
			if(ballPosX > 670){
				ballXDir = -ballXDir;
			}
		
		}
		
		repaint();
	
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

}
