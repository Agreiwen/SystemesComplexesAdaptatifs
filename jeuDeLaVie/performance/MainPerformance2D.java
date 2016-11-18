package jeuDeLaVie.performance;

public class MainPerformance2D {

	public MainPerformance2D(){
	    Modele m = new Modele();
	    AlgoGenetique ag = new AlgoGenetique(m);
	    ag.algo(30000);
	}
	
	public static void main(String[] args) {
		new MainPerformance2D();
	}
}
