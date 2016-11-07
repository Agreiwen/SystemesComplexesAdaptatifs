package jeudelavie1d.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jeudelavie1d.modele.Modele;

public class EcouteurQuitter implements ActionListener {
	
	protected Modele m;

	public EcouteurQuitter(Modele m) {
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
