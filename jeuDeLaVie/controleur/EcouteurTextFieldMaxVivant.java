package jeuDeLaVie.controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import jeuDeLaVie.modele.Modele;

public class EcouteurTextFieldMaxVivant implements KeyListener {
	
	protected Modele m;
	protected JTextField jTextFieldMaxVivant;

	public EcouteurTextFieldMaxVivant(Modele m, JTextField jTextFieldMaxVivant) {
		this.m = m;
		this.jTextFieldMaxVivant = jTextFieldMaxVivant;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			try {
				m.setLongueur(Integer.parseInt(jTextFieldMaxVivant.getText()));
				m.miseAJour();
			} catch (NumberFormatException e1) {
				System.out.println("caca");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
