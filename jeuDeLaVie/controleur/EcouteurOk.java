package jeuDeLaVie.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import jeuDeLaVie.modele.Grille;
import jeuDeLaVie.modele.Modele;
import jeuDeLaVie.vue.VueGraphique;

public class EcouteurOk implements ActionListener {
	
	protected Modele m;
	protected JTextField jTextFieldLargeur, jTextFieldLongueur;

	public EcouteurOk(Modele m, JTextField jTextFieldLargeur, JTextField jTextFieldLongueur) {
		this.m = m;
		this.jTextFieldLargeur = jTextFieldLargeur;
		this.jTextFieldLongueur = jTextFieldLongueur;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(m.getDimension() != 0 && jTextFieldLargeur.getText() != null && jTextFieldLongueur.getText() != null && m.getVoisinage() != 0){
			try {
				m.setLargeur(Integer.parseInt(jTextFieldLargeur.getText()));
				m.setLongueur(Integer.parseInt(jTextFieldLongueur.getText()));
				m.creationGrille();
				//VueGraphique vg = new VueGraphique(m);
				Thread t = new Thread(new VueGraphique(m));
				t.start();
				m.miseAJour();
				System.out.println("LA");
			} catch (NumberFormatException e) {
				System.out.println("caca");
			}
		}
	}

}
