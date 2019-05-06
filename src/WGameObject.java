import java.awt.Graphics;
import java.awt.Rectangle;

import javax.sound.midi.Receiver;

public abstract class WGameObject {
	// KIND OF OBJECT
	//EXAMPLE: PLAYER or ENEMY or COINS
	protected float x,
				  y;
	
	protected float velX, 
				  velY;
	protected ID id;
	
	
	//CONSTRUCTOR WITH PARAMETER
	public WGameObject(float x, float y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	
	//ABSTRACT 
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds(); //HANDLES IF TWO RECTANGLES ARE IN THE SAME POSITION 
	
	
//SETTERS 
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setVelX(int velX){
		this.velX = velX;
	}
	
	public void setVelY(int velY){
		this.velY = velY;
	}
	
	public void setId(ID id){
		this.id = id;
	}
	
	
//GETTERS 
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public float getVelX(){
		return velX;
	}
	
	public float getVelY(){
		return velY;
	}
	
	public ID getId(){
		return id;
	}
	
	
}
