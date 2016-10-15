package jeuDeVie.vue;

import javax.swing.JFrame;

import jeuDeVie.modele.AlgoGenetique;
import jeuDeVie.modele.Modele;

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
