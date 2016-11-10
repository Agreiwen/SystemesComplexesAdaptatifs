package jeuDeLaVie.vue;

import jeuDeLaVie.modele.Modele;

public class MainGraphique {

	public MainGraphique(){
		
	    Modele m = new Modele();
	    VueParametrage vg = new VueParametrage(m);

	}
	
	public static void main(String[] args) {
		new MainGraphique();
	}
}
