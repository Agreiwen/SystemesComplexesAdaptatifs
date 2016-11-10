package jeuDeLaVie.vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import jeuDeLaVie.modele.Modele;
import jeuDeLaVie.vue.VueGrille;

@SuppressWarnings("serial")
public class VueGraphique extends JFrame implements Runnable{
	
	protected Modele m;
	protected VueGrille vg;
	
	public VueGraphique(Modele m){
		super("Systemes Complexes Adaptatifs - Automate Cellulaire");
		this.m = m;
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    
		run();
		
		this.setVisible(true);
		pack();
	}

	@Override
	public void run() {
		vg = new VueGrille(m);
		this.add(vg, BorderLayout.CENTER);
	}
	
}