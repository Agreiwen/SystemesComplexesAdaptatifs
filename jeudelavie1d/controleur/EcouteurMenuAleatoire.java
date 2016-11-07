package jeudelavie1d.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jeudelavie1d.modele.Modele;

public class EcouteurMenuAleatoire implements ActionListener {
	
	protected Modele m;

	public EcouteurMenuAleatoire(Modele m) {
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//m.reinitModele();
		m.getGrille().genereGrilleAleatoire();
		m.majMortVivant();
		m.miseAJour();
	}

}
