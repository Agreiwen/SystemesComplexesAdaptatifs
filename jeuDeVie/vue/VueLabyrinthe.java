package jeuDeVie.vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import jeuDeVie.modele.Modele;
import jeuDeVie.modele.Carte.TypeMap;
import jeuDeVie.controleur.EcouteurBoutonLabyrinthe;

@SuppressWarnings("serial")
public class VueLabyrinthe extends JPanel implements Observer{

	protected Modele m;
	protected JButton jButtonMort;
	protected JButton jButtonVivant;
	
	protected ImageIcon iconMort = new ImageIcon(VueLabyrinthe.class.getResource("/jeuDevie/folder/mort.png"));
	protected ImageIcon iconVivant = new ImageIcon(VueLabyrinthe.class.getResource("/jeuDeVie/folder/vivant.png"));
	
	protected JButton[][] tabButton;
	
	public VueLabyrinthe(Modele m) {
		super();
		this.m = m;
		m.addObserver(this);
		this.setPreferredSize(new Dimension(600,600));
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if(!m.isInitialise()){
			this.removeAll();
            this.setLayout(new GridLayout(m.getHauteur(), m.getLargeur(), 0, 0));
            tabButton = new JButton[m.getHauteur()][m.getLargeur()];
            for (int i = 0; i < tabButton.length; i++) {
				for (int j = 0; j < tabButton[0].length; j++) {
					tabButton[i][j] = new JButton();
					this.add(tabButton[i][j]);
					tabButton[i][j].addActionListener(new EcouteurBoutonLabyrinthe(m, i, j));
					tabButton[i][j].setContentAreaFilled(false);
            		tabButton[i][j].setFocusPainted(false);
				}
			}
            m.setInitialise(true);
        }
		
		for (int i = 0; i < m.getHauteur(); i++) {
			for (int j = 0; j < m.getLargeur(); j++) {
				if(m.getLabyrinthe().getJeu()[i][j].getTypeMap() == TypeMap.MORT){
        			tabButton[i][j].setIcon(iconMort);
            	}else if(m.getLabyrinthe().getJeu()[i][j].getTypeMap() == TypeMap.VIVANT){
            		tabButton[i][j].setIcon(iconVivant);
            	}
			}
		}
	}

}
