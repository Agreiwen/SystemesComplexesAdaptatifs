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
		switch(m.getEtapeParametrage()){
		case 1 :
			//Jamais la
			break;
		case 2 :
			if(m.getCelluleGrille(positionI, positionJ) == 0){
				m.setCelluleGrille(positionI, positionJ, 1);
			}else if(m.getCelluleGrille(positionI, positionJ) == 1){
				m.setCelluleGrille(positionI, positionJ, 0);
			}
			break;
		case 3 :
			//System.out.println(m.nbVoisin(m.getVoisinage(), positionI, positionJ));
			break;
		}
		m.miseAJour();
	}

}
