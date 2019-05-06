
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

public class PTableroJuego extends JPanel {
	
	PPelota pelota = new PPelota(0,0);
	PRaqueta r1 = new PRaqueta(10,200);
	PRaqueta r2 = new PRaqueta(794-10-PRaqueta.ANCHO, 200);
	
	public PTableroJuego() {
		setBackground(Color.BLACK);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.WHITE);
		dibujar(g2);
		dibujarPuntaje(g2);
		actualizar();
	}
	
	public void dibujar(Graphics2D g) {
		
		 Line2D.Double linea = new Line2D.Double(getBounds().getCenterX(), 0, getBounds().getCenterX(), getBounds().getMaxY());

	     g.draw(linea);
	        
		g.fill(pelota.getPelota());
		//System.out.println("x: " + getBounds().getMaxX());
		//System.out.println("y: " + getBounds().getMaxY());
		
		g.fill(r1.getRaqueta());
		g.fill(r2.getRaqueta());
	}
	
	public void actualizar() {
		pelota.mover(getBounds(), colision(r1.getRaqueta()), colision(r2.getRaqueta()));
		r1.moverR1(getBounds());
		r2.moverR2(getBounds());
		
	}
	
	
	private boolean colision(Rectangle2D r) {
		return pelota.getPelota().intersects(r);		
		
	}
	
	
	  private void dibujarPuntaje(Graphics2D g) {
	        Graphics2D g1 = g, g2 = g;
	        Font marcador = new Font("Arial", Font.BOLD, 30);
	        g.setFont(marcador);

	        g1.drawString(Integer.toString(pelota.getMarcador1()), (float) getBounds().getCenterX() - 50, 30);
	        g2.drawString(Integer.toString(pelota.getMarcador2()), (float) getBounds().getCenterX() + 25, 30);
	        if (pelota.getMarcador1() == 5) {
	            g.drawString("HA GANADO El JUGADOR 1", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 100);
	            PPelota.finJuego = true;
	            this.pelota = new PPelota(0,0);
	        	this.r1 = new PRaqueta(10,200);
	        	this.r2 = new PRaqueta(794-10-PRaqueta.ANCHO, 200);
	            
	        }
	        if (pelota.getMarcador2() == 5) {
	            g.drawString("HA GANADO EL JUGADOR 2", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 100);
	            PPelota.finJuego = true;
	            this.pelota = new PPelota(0,0);
	        	this.r1 = new PRaqueta(10,200);
	        	this.r2 = new PRaqueta(794-10-PRaqueta.ANCHO, 200);
	        	
	        }
	    }


}
