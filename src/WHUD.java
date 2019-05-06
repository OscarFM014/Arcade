
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class WHUD {

	public static float HEALTH = 100;
	
	private float greenValue = 255;
	
	private int score = 0;
	private int level = 1;
	
	public void tick(){
		
		HEALTH = (int) WGame.clamp(HEALTH, 0, 100);
		greenValue = (int) WGame.clamp(greenValue, 0, 255); 
		greenValue = HEALTH * 2;
		
		score ++;
		
	}
	
	public void render(Graphics g){
		//HEALTH BAR
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		
		g.setColor(new Color(75, (int) greenValue, 0));
		g.fillRect(15, 15, (int)HEALTH*2, 32);
		
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		//SCORE
		Font fnt3 = new Font("IMPACT", 1, 15);
		g.setFont(fnt3);
		g.drawString("Score: " + score, 10, 70);
		g.drawString("Level: " + level, 10, 85);
	}
	
	//SETTERS
	public void setScore(int score){
		this.score = score;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	
	
	
	//GETTER LEVEL
	public int getLevel(){
		return level;
	}
	
	public int getScore(){
		return score;
	}
	

}
