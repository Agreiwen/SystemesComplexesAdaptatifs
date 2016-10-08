package jeuDeVie.vue;

import javax.swing.JPanel;

import jeuDeVie.modele.Modele;

@SuppressWarnings("serial")
public class VueGraphique extends JPanel{
	
	protected Modele m;
	
	protected VueLabyrinthe vl;

	public VueGraphique(Modele mod) {
		// TODO Auto-generated constructor stub
		this.m=mod;
		vl = new VueLabyrinthe(m);
		this.add(vl);
	}

}
