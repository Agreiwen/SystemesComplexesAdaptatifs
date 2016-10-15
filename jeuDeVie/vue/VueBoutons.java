package jeuDeVie.vue;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import jeuDeVie.modele.Modele;

@SuppressWarnings("serial")
public class VueBoutons extends JPanel implements Observer{
	
	protected Modele m;
	protected JLabel JLabelNbMort;
	protected JLabel JLabelNbVivant;
	protected JLabel JLabelTemps;
	protected JLabel JLabelEspace;
	protected JLabel JLabelNbCoup;

	public VueBoutons(Modele mod) {
		// TODO Auto-generated constructor stub
		super();
		this.m = mod;
		m.addObserver(this);
		
		GridLayout grille = new GridLayout(2, 5);
		this.setLayout(grille);
		
		//Ligne 1
		JLabelEspace = new JLabel();
		this.add(JLabelEspace);
		
		JLabelNbVivant = new JLabel();
		this.add(JLabelNbVivant);
		
		JLabelEspace = new JLabel();
		this.add(JLabelEspace);
		
		JLabelTemps = new JLabel();
		this.add(JLabelTemps);
		
		JLabelEspace = new JLabel();
		this.add(JLabelEspace);
		
		//Ligne 2
		
		JLabelEspace = new JLabel();
		this.add(JLabelEspace);
		
		JLabelNbMort = new JLabel();
		this.add(JLabelNbMort);
		
		JLabelEspace = new JLabel();
		this.add(JLabelEspace);
		
		JLabelNbCoup = new JLabel();
		this.add(JLabelNbCoup);
		
		JLabelEspace = new JLabel();
		this.add(JLabelEspace);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		JLabelNbMort.setText("Nb mort : "+m.getMort());
		JLabelNbVivant.setText("Nb vivant : "+m.getVivant());
		//JLabelTemps.setText("Temps : "+m.getTemps());
		JLabelNbCoup.setText("Nb coups : "+m.getCoup());
	}

}