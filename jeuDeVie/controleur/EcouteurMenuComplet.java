package jeuDeVie.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jeuDeVie.modele.Modele;

public class EcouteurMenuComplet implements ActionListener {
	
	protected Modele m;

	public EcouteurMenuComplet(Modele m) {
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.jeuDeLaVie();
		while(!m.isFin()){
			m.jeuDeLaVie();
		}
	}

}
