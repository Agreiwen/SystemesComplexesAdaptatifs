package jeuDeLaVie.controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import jeuDeLaVie.modele.Modele;

public class EcouteurTexteFieldLargeur implements KeyListener {
	
	protected Modele m;
	protected JTextField jTextFieldLargeur;

	public EcouteurTexteFieldLargeur(Modele m, JTextField jTextFieldY) {
		this.m = m;
		this.jTextFieldLargeur = jTextFieldY;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			try {
				m.setLargeur(Integer.parseInt(jTextFieldLargeur.getText()));
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
