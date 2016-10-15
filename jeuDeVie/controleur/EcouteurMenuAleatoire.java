package jeuDeVie.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jeuDeVie.modele.Modele;

public class EcouteurMenuAleatoire implements ActionListener {
	
	protected Modele m;

	public EcouteurMenuAleatoire(Modele m) {
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.reinitModele();
		m.getLabyrinthe().genereLabyAleatoire();
		m.majMortVivant();
		m.miseAJour();
	}

}
