package jeudelavie1d.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jeudelavie1d.modele.Modele;
import jeudelavie1d.modele.Modele.TypeSelection;

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
