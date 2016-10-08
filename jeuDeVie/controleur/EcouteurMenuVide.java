package jeuDeVie.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jeuDeVie.modele.Modele;

public class EcouteurMenuVide implements ActionListener {
	
	protected Modele m;

	public EcouteurMenuVide(Modele m) {
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.getLabyrinthe().creationLaby();
		m.miseAJour();
	}

}
