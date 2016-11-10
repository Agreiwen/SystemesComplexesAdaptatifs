package jeuDeLaVie.controleur;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import jeuDeLaVie.modele.Modele;

public class EcouteurMoore9 implements ItemListener {
	
	protected Modele m;

	public EcouteurMoore9(Modele m) {
		this.m = m;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){
			m.setVoisinage(2);
			m.miseAJour();
		}
	}

}
