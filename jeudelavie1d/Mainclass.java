package jeudelavie1d;

import javax.swing.JFrame;

import jeudelavie1d.modele.AlgoGenetique;
import jeudelavie1d.modele.Modele;

public class Mainclass extends JFrame{

	public Mainclass(){
		
		super("Systemes Complexes Adaptatifs - Jeu de vie");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    Modele m = new Modele(30, 24);
	   // Modele m = new Modele();
	    AlgoGenetique ag = new AlgoGenetique(m);
	    //m.affichageGrille();
	    ag.algo(1000);
	   // AlgoGenetique ag = new AlgoGenetique(m);
	  //  m.affichageLabyrinthe();
	    
	/*    VueGraphique vg = new VueGraphique(m);
	    this.add(vg, BorderLayout.NORTH);
	    
	    VueBoutons vb = new VueBoutons(m);
	    
	   
        this.add(vb, BorderLayout.CENTER);
        this.setJMenuBar(new VueMenu(m));


		
        m.miseAJour();*/
        
   //     pack() ;
  //      setVisible(true);
	}
	
	public static void main(String[] args) {
		new Mainclass();
	}

}
