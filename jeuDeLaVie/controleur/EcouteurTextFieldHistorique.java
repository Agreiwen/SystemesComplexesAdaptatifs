package jeuDeLaVie.controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import jeuDeLaVie.modele.Modele;

public class EcouteurTextFieldHistorique implements KeyListener {
	
	protected Modele m;
	protected JTextField jTextFieldHistorique;

	public EcouteurTextFieldHistorique(Modele m, JTextField jTextFieldHistorique) {
		this.m = m;
		this.jTextFieldHistorique = jTextFieldHistorique;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			try {
				m.setTailleHistorique(Integer.parseInt(jTextFieldHistorique.getText()));
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
