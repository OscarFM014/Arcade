import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AMenuPrincipal extends JFrame {
	public AMenuPrincipal() {
		super("L & O ARCADE");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1280,  850);
		
		PanelPrincipal p=new PanelPrincipal();
		this.add(p);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public static void main(String [] args) {
		AMenuPrincipal  amp =new AMenuPrincipal();
	}
}



////CLASS PANEL
class PanelPrincipal extends JPanel implements ActionListener  {
	private JButton btnbr,
					btnsna,
					btnpon,
					btnwav;
	
	private JRadioButton rbtn;
	
	private Image fondo,
				breaker,
				pong,
				snake,
				wave,
				title,
				select;
	
	
	
	public PanelPrincipal(){
		super();
		//NEW
		this.setPreferredSize(new Dimension (1280,  850));
		this.fondo = new ImageIcon("imagenes/FondoPrincipal.jpg").getImage();
		this.breaker = new ImageIcon("imagenes/Breaker.jpg").getImage();
		this.pong = new ImageIcon("imagenes/Pong.jpg").getImage();
		this.snake = new ImageIcon("imagenes/Snake.jpg").getImage();
		this.wave = new ImageIcon("imagenes/Waves.jpg").getImage();
		this.title = new ImageIcon("imagenes/title.png").getImage();
		this.select = new ImageIcon("imagenes/select.png").getImage();
		
		this.setLayout(null);
		this.btnbr = new JButton("Play");
		this.btnbr.setBounds(280,420,190,40);
		this.btnbr.addActionListener(this);
		
		this.btnsna = new JButton("Play");
		this.btnsna.setBounds(280,720, 190, 40);
		this.btnsna.addActionListener(this);
		
		this.btnpon = new JButton("Play");
		this.btnpon.setBounds(820,420, 190, 40);
		this.btnpon.addActionListener(this);
		
		this.btnwav = new JButton("Play");
		this.btnwav.setBounds(820,720, 190, 40);
		this.btnwav.addActionListener(this);
	
		//ADD
		this.add(this.btnbr);
	    this.add(this.btnsna);
	    this.add(this.btnpon);
	    this.add(this.btnwav);
		
		

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(), this);	
		g.drawImage(this.title, 420, 10, 450, 90, this);
		g.drawImage(this.select, 545, 150, 200, 40, this);
		
		g.drawImage(this.breaker, 200, 200, 350, 200, this);
		
		g.drawImage(this.pong, 750, 200, 350, 200, this);
		g.drawImage(this.snake, 200, 500, 350, 200, this);
		g.drawImage(this.wave, 750, 500, 350, 200, this);
		
		
		
	}
	
	public void actionPerformed (ActionEvent e) {
		if (e.getSource()==this.btnbr) {
			BMain a = new BMain();
		    a.setVisible(true);
		} else if (e.getSource()==this.btnsna){
			SMain b = new SMain();
		    b.setVisible(true);
		} else if (e.getSource()==this.btnpon){
			PVentana c = new PVentana();
		    c.setVisible(true);
		} else if (e.getSource()==this.btnwav){
			WGame game = new WGame();
			WWindow d = new WWindow(640, 640/12 * 9, "Our Waves", game);
		    d.setVisible(true);
		}
	}
}

