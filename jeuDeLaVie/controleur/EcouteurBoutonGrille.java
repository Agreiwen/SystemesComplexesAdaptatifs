package jeuDeLaVie.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jeuDeLaVie.modele.Modele;

public class EcouteurBoutonGrille implements ActionListener {
	
	protected Modele m;
	protected int positionI, positionJ;

	public EcouteurBoutonGrille(Modele m, int i, int j) {
		this.m = m;
		this.positionI = i;
		this.positionJ = j;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(m.getCellule(positionI, positionJ) == 0){
			m.setCellule(positionI, positionJ, 1);
		}else if(m.getCellule(positionI, positionJ) == 1){
			m.setCellule(positionI, positionJ, 1);
		}
	}

}
