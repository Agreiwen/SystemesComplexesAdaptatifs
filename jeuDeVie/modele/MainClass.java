package jeuDeVie.modele;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainClass extends JFrame{

	public MainClass(){
	    Modele m = new Modele();
	    AlgoGenetique ag = new AlgoGenetique(m);
	    //m.affichageGrille();
	    ag.algo(3);
	}
	
	public static void main(String[] args) {
		new MainClass();
	}
}
