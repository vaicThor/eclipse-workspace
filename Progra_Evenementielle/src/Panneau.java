import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panneau extends JPanel implements Observable{
	
	private int posX = -50;
	private int posY = -50;
	private String forme = "ROND";
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	
	
	public void paintComponent(Graphics g) {
		//On verra cette phrase à chaque foique la méthode est invoquée
		// System.out.println("Je suis éxécutée !");
		
		//On choisit une couleur de fond pour le rectangle*
		
		g.setColor(Color.white);
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		
		
		g.setColor(Color.red);
		draw(g);
		

	}
	private void draw(Graphics g) {
		if(this.forme.contentEquals("ROND")) {
			g.fillOval(posX,posY,50,50);
		}
		if(this.forme.equals("CARRE")) {
			g.fillRect(posX, posY, 50, 50);
		}
		if(this.forme.equals("TRIANGLE")) {
			//Le sommet 1 se situe à la moitié du côté supérieur du carré
			int s1X = posX + 25;
			int s1Y = posY;
			// Le sommet 3 se situe en bas à droite
			int s2X = posX + 50;
			int s2Y = posY + 50;
			// Le sommet 3 se situe en bas à gauche
			int s3X = posX;
			int s3Y = posY + 50;
			//Création des tableau de point X et Y
			int[] tabX = {s1X,s2X,s3X};
			int[] tabY = {s1Y,s2Y,s3Y};
			// Enfin le tracer de polygone
			g.fillPolygon(tabX, tabY, 3);
		}
		if(this.forme.contentEquals("ETOILE")) {
		      int s1X = posX + 25;
		      int s1Y = posY;
		      int s2X = posX + 50;
		      int s2Y = posY + 50;        
		      g.drawLine(s1X, s1Y, s2X, s2Y);      
		      int s3X = posX;
		      int s3Y = posY + 17;
		      g.drawLine(s2X, s2Y, s3X, s3Y);      
		      int s4X = posX + 50;
		      int s4Y = posY + 17;
		      g.drawLine(s3X, s3Y, s4X, s4Y);            
		      int s5X = posX;
		      int s5Y = posY + 50;
		      g.drawLine(s4X, s4Y, s5X, s5Y);       
		      g.drawLine(s5X, s5Y, s1X, s1Y);  
		    }
	}

	public void setForme(String form) {
		this.forme = form;
	}
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	@Override
	public void addObservater(Observer obs) {
		this.listObserver.add(obs);
		
	}

	@Override
	public void updateObservater() {
		for (Observer obs : this.listObserver)
			obs.update(posX, posY);
		
	}

	@Override
	public void delObservater() {
		this.listObserver = new ArrayList<Observer>();
		
	}


}
