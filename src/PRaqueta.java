import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class PRaqueta {

	private int x, y;
	static final int ANCHO=10, ALTO=40; // static =  para poder invocar estas variables desde otras clases
	
	public PRaqueta(int x, int y) {
		this.x = x;
		this.y =y;
		 	
	}
	
	public Rectangle2D getRaqueta() {
		return new Rectangle2D.Double(x, y, ANCHO, ALTO);
	}
	
	public void moverR1(Rectangle limites) {
		if(PEventoTeclado.a && y>limites.getMinY()) {
			y =  y - 3;
		}
		if(PEventoTeclado.z && y<limites.getMaxY()-ALTO) {
			y = y + 3;
		}
	}
	
	public void moverR2(Rectangle limites) {
		if(PEventoTeclado.k && y>limites.getMinY()) {
			y = y - 3;
		}
		if(PEventoTeclado.m && y<limites.getMaxY()-ALTO) {
			y = y + 3;
		}
	}
	
}
