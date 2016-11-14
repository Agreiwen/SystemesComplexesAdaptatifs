package jeuDeLaVie.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jeuDeLaVie.modele.Modele;

public class EcouteurGo implements ActionListener {
	
	protected Modele m;

	public EcouteurGo(Modele m) {
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		m.setEtapeParametrage(3);
		Thread t = new Thread(m);
		t.start();
		m.miseAJour();
	}

}
