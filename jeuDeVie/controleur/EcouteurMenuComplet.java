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
		int nbCoup = 0;
		Thread t = new Thread((Runnable)m, "Traitement-grille");
		t.start() ;
		m.jeuDeLaVie();
		nbCoup++;
		while(!m.isFin()){
			//System.out.println("ok");
			m.jeuDeLaVie();
			nbCoup++;
		}
		System.out.println(nbCoup-1);
		t.stop();
	}

}
