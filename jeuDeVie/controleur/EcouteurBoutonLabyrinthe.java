package jeuDeVie.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jeuDeVie.modele.Carte.TypeMap;
import jeuDeVie.modele.Modele.TypeSelection;
import jeuDeVie.modele.Modele;

public class EcouteurBoutonLabyrinthe implements ActionListener {
	
	protected Modele m;
	protected int positionX;
	protected int positionY;

	public EcouteurBoutonLabyrinthe(Modele m, int x, int y) {
		this.m = m;
		this.positionX = x;
		this.positionY = y;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(m.getTypeSelection() == TypeSelection.MORT){
			m.getGrille().getMap(positionX, positionY).setTypeMap(TypeMap.MORT);
		//	m.miseAJour();
		}else if(m.getTypeSelection() == TypeSelection.VIVANT){
			m.getGrille().getMap(positionX, positionY).setTypeMap(TypeMap.VIVANT);
		}
		m.miseAJour();
		//System.out.println(m.getLabyrinthe().getMap(positionX, positionY).toString()+"\n");
		//System.out.println(m.getLabyrinthe().nbVoisin(positionX, positionY));
		//System.out.println(m.getLabyrinthe().getMap(positionX, positionY).valeur());
		//m.affichageLabyrinthe();
	}

}
