package jeuDeLaVie.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import jeuDeLaVie.modele.Modele;
import jeuDeLaVie.vue.VueGraphique;

public class EcouteurOk implements ActionListener {
	
	protected Modele m;
	protected JTextField jTextFieldLargeur, jTextFieldLongueur, jTexteFieldMaxVivant, jTexteFieldRegle, jTextFieldHistorique;
	protected VueGraphique vg;

	public EcouteurOk(Modele m, JTextField jTextFieldLargeur, JTextField jTextFieldLongueur, JTextField jTexteFieldMaxVivant, JTextField jTexteFieldRegle, JTextField jTextFieldHistorique) {
		this.m = m;
		this.jTextFieldLargeur = jTextFieldLargeur;
		this.jTextFieldLongueur = jTextFieldLongueur;
		this.jTexteFieldMaxVivant = jTexteFieldMaxVivant;
		this.jTexteFieldRegle = jTexteFieldRegle;
		this.jTextFieldHistorique = jTextFieldHistorique;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(m.getDimension()){
		case 1 :
			if(m.getDimension() != 0 && jTextFieldLongueur.getText() != null && jTexteFieldRegle.getText() != null && jTextFieldHistorique.getText() != null){
				try {
					m.setLargeur(Integer.parseInt(jTextFieldHistorique.getText()));
					m.setLongueur(Integer.parseInt(jTextFieldLongueur.getText()));
					m.setRegle(Integer.parseInt(jTexteFieldRegle.getText()));
					m.creationGrille();
					vg = new VueGraphique(m);
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
				} catch (NumberFormatException e) {
					System.out.println("caca");
				}
			}
		}
		m.setEtapeParametrage(2);
		if(jTexteFieldMaxVivant.getText() != null){
			try {
				m.setMaxVivant(Integer.parseInt(jTexteFieldMaxVivant.getText()));
				m.genereAleatoire();
			} catch (NumberFormatException e) {
				System.out.println("caca");
			}
		}
		m.miseAJour();
	}

}
