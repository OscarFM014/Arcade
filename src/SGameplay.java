import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

//import java.util.Timer;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SGameplay extends JPanel implements KeyListener, ActionListener{
	
	private int[] snakeXlength = new int[750];
	private int[] snakeYlength = new int[750];
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon rightmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private ImageIcon leftmouth;
	
	private int lengthOfSnake = 3;
	
	private Timer timer;
	private int delay = 100;
	
	private ImageIcon snakeimage;
	
	
	private int[] enemyXpos = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250,275, 300, 325, 350, 375, 400, 425, 450,
								475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850}	;
	
	private int[] enemyYpos = {75, 100, 125, 150, 175, 200, 225, 250,275, 300, 325, 350, 375, 400, 425, 450,
			475, 500, 525, 550, 575, 600, 625};
	
	private ImageIcon enemyimage;
	private Random random = new Random();
	private int xPos = random.nextInt(34);
	private int yPos = random.nextInt(23);
	
	private int score = 0;
	
	
	private int moves = 0;
	
	
	private ImageIcon titleImage;
	  
	
	
	public SGameplay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
	    timer.start();
		
	}
	
	public void paint(Graphics g) { 
		if(moves == 0) {
			snakeXlength[2] = 50;
			snakeXlength[1] = 75;
			snakeXlength[0] = 100;
			
			snakeYlength[2] = 100;
			snakeYlength[1] = 100;
			snakeYlength[0] = 100;
			
		}
		
		//Dibujar el borde del titulo
		g.setColor(Color.WHITE);
		g.drawRect(24, 10, 851, 55);
		
		//Dibujar el titulo
		titleImage = new ImageIcon("/res/snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		//Dibujar borde de jugabilidad
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		//Dibujar fondo para la jugabilidad
		g.setColor(Color.BLACK);
		g.fillRect(25, 75, 850, 575);
		
		//Dibujar puntuacion
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Puntuaci�n: " + score, 780, 30);
		
		//Dibujar longitud
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Longitud: " + lengthOfSnake, 780, 50);
				
		
		rightmouth = new ImageIcon("/res/rightmouth.png");
		rightmouth.paintIcon(this,  g, snakeXlength[0], snakeYlength[0]);
		
		for(int a=0; a < lengthOfSnake; a++) {
			
			if(a==0 && right) {
				rightmouth = new ImageIcon("/res/rightmouth.png");
				rightmouth.paintIcon(this,  g, snakeXlength[a], snakeYlength[a]);
			}
			
			if(a==0 && left) {
				leftmouth = new ImageIcon("/res/leftmouth.png");
				leftmouth.paintIcon(this,  g, snakeXlength[a], snakeYlength[a]);
			}
			
			if(a==0 && down) {
				downmouth = new ImageIcon("/res/downmouth.png");
				downmouth.paintIcon(this,  g, snakeXlength[a], snakeYlength[a]);
			}
			
			if(a==0 && up) {
				upmouth = new ImageIcon("/res/upmouth.png");
				upmouth.paintIcon(this,  g, snakeXlength[a], snakeYlength[a]);
			}
			
			if(a != 0) {
				snakeimage = new ImageIcon("/res/snakeimage.png");
				snakeimage.paintIcon(this,  g, snakeXlength[a], snakeYlength[a]);
			}
		}
		
		enemyimage =  new ImageIcon("/res/enemy.png");
		
		if((enemyXpos[xPos] == snakeXlength[0]) && enemyYpos[yPos] == snakeYlength[0]) { 
			score++;
			lengthOfSnake++;
			xPos = random.nextInt(34);
			yPos = random.nextInt(23);
		}
		
		enemyimage.paintIcon(this, g, enemyXpos[xPos], enemyYpos[yPos]);
		  	
		for(int b=1; b<lengthOfSnake; b++) {
			
			if(snakeXlength[b] == snakeXlength[0] && snakeYlength[b] == snakeYlength[0]) {
				right = false;
				left = false;
				up = false;
				down = false;
				
				g.setColor(Color.WHITE);
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("Game Over", 300, 300);
				
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("Space to RESTART", 350, 340);
			}
			
			
		}
		
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(right) {
			for(int r = lengthOfSnake-1; r>=0; r--) {
				snakeYlength[r+1] = snakeYlength[r];
			}
			for(int r = lengthOfSnake; r>=0; r--) {
				if(r==0) {
					snakeXlength[r] = snakeXlength[r] + 25;
				}else {
					snakeXlength[r] = snakeXlength[r-1];
				}
				if(snakeXlength[r] > 850) {
					snakeXlength[r] = 25;
				}
			}
			repaint();
		}
		if(left) {
			for(int r = lengthOfSnake-1; r>=0; r--) {
				snakeYlength[r+1] = snakeYlength[r];
			}
			for(int r = lengthOfSnake; r>=0; r--) {
				if(r==0) {
					snakeXlength[r] = snakeXlength[r] - 25;
				}else {
					snakeXlength[r] = snakeXlength[r-1];
				}
				if(snakeXlength[r] < 25) {
					snakeXlength[r] = 850;
				}
			}
			repaint();
		}		
				
		if(up) {
			for(int r = lengthOfSnake-1; r>=0; r--) {
				snakeXlength[r+1] = snakeXlength[r];
			}
			for(int r = lengthOfSnake; r>=0; r--) {
				if(r==0) {
					snakeYlength[r] = snakeYlength[r] - 25;
				}else {
					snakeYlength[r] = snakeYlength[r-1];
				}
				if(snakeYlength[r] < 75) {
					snakeYlength[r] = 625;
				}
			}
			repaint();
		}
		if(down) { 
			for(int r = lengthOfSnake-1; r>=0; r--) {
				snakeXlength[r+1] = snakeXlength[r];
			}
			for(int r = lengthOfSnake; r>=0; r--) {
				if(r==0) {
					snakeYlength[r] = snakeYlength[r] + 25;
				}else {
					snakeYlength[r] = snakeYlength[r-1];
				}
				if(snakeYlength[r] > 625) {
					snakeYlength[r] = 75;
				}
			}
			repaint();
		}
				
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			moves = 0;
			score = 0;
			lengthOfSnake = 3;
			repaint();
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moves++;
			right = true;
			if(!left) {
				right = true;
			}else {
				right = false;
				left = true;
			}
			up = false;
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			moves++;
			left = true;
			if(!right) {
				left = true;
			}else {
				left = false;
				right = true;
			}
			up = false;
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			moves++;
			up = true;
			if(!down) {
				up = true;
			}else {
				up = false;
				down = true;
			}
			right = false;
			left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			moves++;
			down = true;
			if(!up) {
				down = true;
			}else {
				down = false;
				up = true;
			}
			right = false;
			left = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}
	
}
