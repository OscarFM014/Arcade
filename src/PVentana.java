
import javax.swing.JFrame;

public class PVentana extends JFrame {
	
	private final int ANCHO = 800, ALTO= 500; // final = porque son constantes
	
	private PTableroJuego lamina;

	private PHilo hilo;
	
	public PVentana() {
		setTitle("Our Pong");
		setSize(ANCHO, ALTO);
		setLocationRelativeTo(null);
		setResizable(false);
		lamina = new PTableroJuego();
		add(lamina);
		addKeyListener(new PEventoTeclado());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hilo = new PHilo(lamina); 
		hilo.start();
		
	
		
	}
}
