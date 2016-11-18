package jeuDeLaVie.vue;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import jeuDeLaVie.controleur.EcouteurBoutonGrille;
import jeuDeLaVie.modele.Modele;

@SuppressWarnings("serial")
public class VueGrille extends JPanel implements Observer{
	
	protected Modele m;
	protected JButton jButtonMort;
	protected JButton jButtonVivant;
	
	protected ImageIcon iconMort = new ImageIcon(VueGrille.class.getResource("/jeuDeLaVie/folder/mort.png"));
	protected ImageIcon iconVivant = new ImageIcon(VueGrille.class.getResource("/jeuDeLaVie/folder/vivant.png"));
	
	protected JButton[][] tabButton;
	
	public VueGrille(Modele m){
		super();
		this.m = m;
		m.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(!m.isInitialise()){
			this.removeAll();
            this.setLayout(new GridLayout(m.getLargeur(), m.getLongueur(), 0, 0));
            tabButton = new JButton[m.getLargeur()][m.getLongueur()];
            for (int i = 0; i < tabButton.length; i++) {
				for (int j = 0; j < tabButton[0].length; j++) {
					tabButton[i][j] = new JButton();
					this.add(tabButton[i][j]);
					tabButton[i][j].addActionListener(new EcouteurBoutonGrille(m, i, j));
					tabButton[i][j].setContentAreaFilled(false);
            		tabButton[i][j].setFocusPainted(false);
            		if(m.getDimension() == 1 && m.getEtapeParametrage() == 2 && i > 0){
						 tabButton[i][j].setEnabled(false); 
					}
				}
			}
            m.setInitialise(true);
        }
		
		for (int i = 0; i < m.getLargeur(); i++) {
			for (int j = 0; j < m.getLongueur(); j++) {
				if(m.getDimension() == 1 && m.getEtapeParametrage() != 2){
					tabButton[i][j].setEnabled(true);
				}
				if(m.getCelluleGrille(i, j) == 0){
        			tabButton[i][j].setIcon(iconMort);
            	}else if(m.getCelluleGrille(i, j) == 1){
            		tabButton[i][j].setIcon(iconVivant);
            	}
			}
		}
	}

}
