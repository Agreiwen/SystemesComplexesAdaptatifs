package jeudelavie1d.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jeudelavie1d.modele.Modele;

public class EcouteurMenuVide implements ActionListener {
	
	protected Modele m;

	public EcouteurMenuVide(Modele m) {
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.getGrille().creationGrille();
		m.miseAJour();
	}

}
