package jeuDeVie.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jeuDeVie.modele.Modele;
import jeuDeVie.modele.Modele.TypeSelection;

public class EcouteurMenuVivant implements ActionListener {
	
	protected Modele m;

	public EcouteurMenuVivant(Modele m) {
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.setTypeSelection(TypeSelection.VIVANT);
	}

}
