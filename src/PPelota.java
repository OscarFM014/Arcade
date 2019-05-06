
import java.applet.AudioClip;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class PPelota {


	private double x;
	private double y;
	private int dx=1, dy=1;
	
	public Integer score1 = 0, score2 = 0;
    public static boolean finJuego = false;
    
    PAudio audio = new PAudio();
    AudioClip rebote_1 = audio.getAudio("/res/rebote_pelota1.wav");
    AudioClip rebote_2 = audio.getAudio("/res/rebote_pelota2.wav");
    AudioClip falta=audio.getAudio("/res/falta.wav");
	
	private int ANCHO=15, ALTO=15;
	
	public PPelota(int x, int y){
		this.x = x;
		this.y = y;
		
	}
	
	public Rectangle2D getPelota() {
		return new Rectangle2D.Double(x, y,ANCHO , ALTO);
	}
	
	public void mover(Rectangle limites, boolean colisionR1, boolean colisionR2){
		x += dx *1.5;
		y += dy *1.5;
		
		if(colisionR1) {
			dx = -dx;
			x = 25;
			rebote_1.play();
		}
		
		if(colisionR2) {
			dx = -dx;
			x = 755;
			rebote_1.play();
		}
		
		 if (x < limites.getMinX()) {
	            score2++; //el puntaje del jugador2 aumenta en uno
	           
	            x = limites.getCenterX();
	            y = limites.getCenterY();
	            dx = -dx;
	            falta.play();
	        }

	        if (x + ANCHO >= limites.getMaxX()) {
	            score1++; //el puntaje del jugador1 aumenta en uno
	            
	            x = limites.getCenterX();
	            y = limites.getCenterY();
	            dx = -dx;
	            falta.play();
	        }

	        if (y < limites.getMinY()) {

	            y = limites.getMinY();

	            dy = -dy;
	            rebote_2.play();
	        }

	        if (y + ALTO >= limites.getMaxY()) {

	            y = limites.getMaxY() - ALTO;

	            dy = -dy;
	            rebote_2.play();
	        }
	}
	
	 public int getMarcador1() {
	        return score1;
	    }

	    public int getMarcador2() {
	        return score2;
	    }
	    
	 public void setMarcador1(int score1) {
		 score1 = score1;
	 }
	
}

