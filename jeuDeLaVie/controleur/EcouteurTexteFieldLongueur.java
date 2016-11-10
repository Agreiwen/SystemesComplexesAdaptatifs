package jeuDeLaVie.controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import jeuDeLaVie.modele.Modele;

public class EcouteurTexteFieldLongueur implements KeyListener {
	
	protected Modele m;
	protected JTextField jTextFieldLongueur;

	public EcouteurTexteFieldLongueur(Modele m, JTextField jTextFieldX) {
		this.m = m;
		this.jTextFieldLongueur = jTextFieldX;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			try {
				m.setLongueur(Integer.parseInt(jTextFieldLongueur.getText()));
			} catch (NumberFormatException e1) {
				System.out.println("caca");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
