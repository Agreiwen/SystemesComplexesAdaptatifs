package jeuDeLaVie.controleur;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import jeuDeLaVie.modele.Modele;

public class EcouteurTorique implements ItemListener {
	
	protected Modele m;

	public EcouteurTorique(Modele m) {
		this.m = m;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){
			m.setTorique(true);
		}else if(e.getStateChange() == ItemEvent.DESELECTED){
			m.setTorique(false);
		}
		m.miseAJour();
	}

}
