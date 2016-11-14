package jeuDeLaVie.controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import jeuDeLaVie.modele.Modele;

public class EcouteurTextFieldRegle implements KeyListener {
	
	protected Modele m;
	protected JTextField jTextFieldRegle;

	public EcouteurTextFieldRegle(Modele m, JTextField jTextFieldRegle) {
		this.m = m;
		this.jTextFieldRegle = jTextFieldRegle;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			try {
				m.setRegle(Integer.parseInt(jTextFieldRegle.getText()));
				m.miseAJour();
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
