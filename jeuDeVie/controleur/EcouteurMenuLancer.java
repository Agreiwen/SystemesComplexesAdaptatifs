package jeuDeVie.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jeuDeVie.modele.Modele;

public class EcouteurMenuLancer implements ActionListener {
	
	protected Modele m;

	public EcouteurMenuLancer(Modele m) {
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread((Runnable)m, "Traitement-grille");
		t.start();
		m.miseAJour();
	}

}
