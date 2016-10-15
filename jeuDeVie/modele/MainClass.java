package jeuDeVie.modele;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainClass extends JFrame{

	public MainClass(){
	    Modele m = new Modele();
	    AlgoGenetique ag = new AlgoGenetique(m);
	    m.affichageLabyrinthe();
	}
	
	public static void main(String[] args) {
		new MainClass();
	}

}
