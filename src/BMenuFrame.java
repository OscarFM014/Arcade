import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BMenuFrame extends JFrame {
	
	public BMenuFrame(){
		super("Our Brick Braker");
		this.setBounds(10, 10, 700, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		BPanelPrincipal p=new BPanelPrincipal();
		this.add(p);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String [] args) {
		BMenuFrame  amp = new BMenuFrame();
	}
}

//Class Panel
class BPanelPrincipal extends JPanel implements ActionListener  {
	private JButton btnplay,
					btnhelp,
					btnexit;
	
	
	private Image fondo;
	
	
	
	public BPanelPrincipal(){
		super();
		//NEW
		this.setPreferredSize(new Dimension (700,  600));
		this.fondo = new ImageIcon("imagenes/menubreaker.jpg").getImage();
		
		this.setLayout(null);
		this.btnplay = new JButton("Play");
		this.btnplay.setBounds(270, 190, 200,  64);
		this.btnplay.addActionListener(this);
		
		this.btnhelp = new JButton("Help");
		this.btnhelp.setBounds(270, 290, 200,  64);
		this.btnhelp.addActionListener(this);
		
		this.btnexit = new JButton("Quit");
		this.btnexit.setBounds(270, 390, 200,  64);
		this.btnexit.addActionListener(this);
	
		//ADD
		this.add(this.btnplay);
	    this.add(this.btnhelp);
	    this.add(this.btnexit);
		
	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(), this);		
		Font fnt = new Font("Impact", 1, 50);
		Font fnt2 = new Font("Impact", 1, 30);
		
		g.setColor(Color.WHITE);
		g.setFont(fnt);
		g.drawString("Brick Breaker", 230, 70);
	}
	
	public void actionPerformed (ActionEvent e) {
		if (e.getSource()==this.btnplay) {
			BMain a = new BMain();
			a.setVisible(true);
			this.setVisible(false);
		} else if(e.getSource()==this.btnexit){
			AMenuPrincipal b = new AMenuPrincipal();
			b.setVisible(true);
			this.setVisible(false);
		} else if (e.getSource() == this.btnhelp){
			BHelp c = new BHelp();
			c.setVisible(true);
			this.setVisible(false);
		}
	  }
	
}

class BHelp extends JFrame{
	public BHelp (){
		super("Our Brick Braker");
		BHelpPanel help = new BHelpPanel();
		this.setBounds(10, 10, 700, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(help);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		BHelp amp = new BHelp();
	}
}

class BHelpPanel extends JPanel implements ActionListener{
	
	private JButton btnexit;
	private Image fondo;
	
	public BHelpPanel(){
		this.fondo = new ImageIcon("imagenes/menubreaker.jpg").getImage();
		this.setLayout(null);
		this.btnexit = new JButton("Return");
		this.btnexit.setBounds(270, 390, 200,  64);
		this.btnexit.addActionListener(this);
		this.add(this.btnexit);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(), this);
		Font fnt = new Font("Impact", 1, 50);
		Font fnt2 = new Font("Impact", 1, 30);
		
		g.setColor(Color.WHITE);
		g.setFont(fnt);
		g.drawString("Help", 250, 70);
		
		g.setFont(fnt2);
		g.drawString("Controls: Left Arrow, Rigth Arrow", 180, 140);
		g.drawString("Enter: Menu", 180,  240);
		g.drawString("ESC: Exit", 180,  340);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnexit){
			BMenuFrame a = new BMenuFrame();
			a.setVisible(true);
			this.setVisible(false); 
		}
		
	}
}



