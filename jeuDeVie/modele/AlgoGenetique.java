package jeuDeVie.modele;

public class AlgoGenetique {
	
	protected Modele m;

	public AlgoGenetique(Modele m) {
		this.m = m;
	}
	
	public void algo(int nbIteration){
		for (int i = 0; i < 50; i++) {
			//System.out.println(i);
			m = new Modele();
			m.getGrille().genereGrilleAleatoire();
			m.affichageGrille();
			while(!m.isFin()){
				m.jeuDeLaVie();
			}
			System.out.println(m.getCoup());
			m.setCoup(0);
		}
	}

}
