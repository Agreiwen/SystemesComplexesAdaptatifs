package jeuDeLaVie.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;

import jeuDeLaVie.modele.Modele;
import jeuDeLaVie.vue.VueGrille;

@SuppressWarnings("serial")
public class VueGraphique extends JFrame {
	
	protected Modele m;
	protected VueGrille vg;
	
	private static int LONGUEUR_GRILLE = 600;
	private static int LARGEUR_GRILLE = 600;
	
	public VueGraphique(Modele m){
		super("Systemes Complexes Adaptatifs - Automate Cellulaire");
		this.m = m;
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    vg = new VueGrille(m);
		this.add(vg, BorderLayout.CENTER);
		
		this.setPreferredSize(new Dimension(LONGUEUR_GRILLE,LARGEUR_GRILLE));
		Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	    System.out.println(bounds.getMinY()+" "+bounds.getMinX());
	    this.setLocation((int)(bounds.getMaxX()/2+((bounds.getMaxY()*5)/100)),(int)(bounds.getMaxY()/2-LARGEUR_GRILLE/2));
		
		this.setVisible(true);
		pack();
	}

}