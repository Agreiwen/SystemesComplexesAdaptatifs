package jeuDeLaVie.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import jeuDeLaVie.modele.Modele;
import jeuDeLaVie.vue.VueGraphique;
import jeuDeLaVie.vue.VueMethode;

public class EcouteurOk implements ActionListener {
	
	protected Modele m;
	protected JTextField jTextFieldLargeur, jTextFieldLongueur;
	protected VueGraphique vg;
	protected VueMethode vm;

	public EcouteurOk(Modele m, JTextField jTextFieldLargeur, JTextField jTextFieldLongueur) {
		this.m = m;
		this.jTextFieldLargeur = jTextFieldLargeur;
		this.jTextFieldLongueur = jTextFieldLongueur;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(m.getDimension()){
		case 1 :
			if(m.getDimension() != 0 && jTextFieldLongueur.getText() != null && m.getVoisinage() != 0){
				try {
					m.setLargeur(10);
					m.setLongueur(Integer.parseInt(jTextFieldLongueur.getText()));
					m.creationGrille();
					vg = new VueGraphique(m);
					vm = new VueMethode(m);
					m.miseAJour();
				} catch (NumberFormatException e) {
					System.out.println("caca");
				}
			}
		case 2 :
			if(m.getDimension() != 0 && jTextFieldLargeur.getText() != null && jTextFieldLongueur.getText() != null && m.getVoisinage() != 0){
				try {
					m.setLargeur(Integer.parseInt(jTextFieldLargeur.getText()));
					m.setLongueur(Integer.parseInt(jTextFieldLongueur.getText()));
					m.creationGrille();
					vg = new VueGraphique(m);
					vm = new VueMethode(m);
					m.miseAJour();
					System.out.println("LA");
				} catch (NumberFormatException e) {
					System.out.println("caca");
				}
			}
		}
	}

}
