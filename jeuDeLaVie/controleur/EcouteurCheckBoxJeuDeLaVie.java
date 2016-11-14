package jeuDeLaVie.controleur;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import jeuDeLaVie.modele.Modele;

public class EcouteurCheckBoxJeuDeLaVie implements ItemListener {
	
	protected Modele m;

	public EcouteurCheckBoxJeuDeLaVie(Modele m) {
		this.m = m;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){
			m.setMethode(1);
			m.miseAJour();
		}
	}

}
