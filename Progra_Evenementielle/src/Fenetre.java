import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Fenetre extends JFrame{
	private Panneau pan = new Panneau();
	private JButton but = new JButton("mon boutton!");
	
	public Fenetre() {
		this.setTitle("My First Animation in Java!");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 


	//Définition de sa couleur de fond
//		pan.setBackground(Color.ORANGE);
//	    this.setLayout(new GridLayout(3, 2));
//	    //On ajoute le bouton au content pane de la JFrame
//	    this.getContentPane().add(new JButton("1"));
//	    this.getContentPane().add(new JButton("2"));
//	    this.getContentPane().add(new JButton("3"));
//	    this.getContentPane().add(new JButton("4"));
//	    this.getContentPane().add(new JButton("5"));
//	  
		this.getContentPane().add(new JButton("NORTH"),BorderLayout.NORTH);
  
		this.getContentPane().add(new JButton("West"),BorderLayout.WEST);
		this.getContentPane().add(new JButton("East"),BorderLayout.EAST);
		this.getContentPane().add(new JButton("South"),BorderLayout.SOUTH);
		this.getContentPane().add(new JButton("Center"),BorderLayout.CENTER);
	//Instanciation d'un objet JPanel!
//		this.setContentPane(pan);
		this.setVisible(true);

	}
}

	

