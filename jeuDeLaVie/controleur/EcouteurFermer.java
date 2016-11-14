package jeuDeLaVie.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jeuDeLaVie.modele.Modele;

public class EcouteurFermer implements ActionListener {
	
	protected Modele m;

	public EcouteurFermer(Modele m) {
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
