package jeudelavie1d.vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import jeudelavie1d.controleur.EcouteurBoutonLabyrinthe;
import jeudelavie1d.modele.Carte.TypeMap;
import jeudelavie1d.modele.Modele;

@SuppressWarnings("serial")
public class VueLabyrinthe extends JPanel implements Observer{

	protected Modele m;
	protected JButton jButtonMort;
	protected JButton jButtonVivant;
	
	protected ImageIcon iconMort = new ImageIcon(VueLabyrinthe.class.getResource("/jeudelavie1d/folder/mort.png"));
	protected ImageIcon iconVivant = new ImageIcon(VueLabyrinthe.class.getResource("/jeudelavie1d/folder/vivant.png"));
	
	protected JButton[][] tabButton;
	
	public VueLabyrinthe(Modele m) {
		super();
		this.m = m;
		m.addObserver(this);
		this.setPreferredSize(new Dimension(1000,300));
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if(!m.isInitialise()){
			System.out.println("Première init");
			this.removeAll();
			//System.out.println(m.getLargeur()+"ddd");
            this.setLayout(new GridLayout(20, m.getLargeur()));
            tabButton = new JButton[20][m.getLargeur()];
          //  System.out.println(tabButton[0].length);
            for (int j = 0; j < 20; j++) {
            	for (int i = 0; i < tabButton[0].length; i++) {
					JButton jb = new JButton("");
            		tabButton[j][i] = jb;
					tabButton[j][i].setPreferredSize(new Dimension(10,10));
					//System.out.println(tabButton[0][i].getPreferredSize());
					this.add(jb);
					tabButton[j][i].addActionListener(new EcouteurBoutonLabyrinthe(m, i));
					tabButton[j][i].setContentAreaFilled(false);
            		tabButton[j][i].setFocusPainted(false);
			
			}
            }
            m.setInitialise(true);
        }
	/*	int cpt = 0;
		while(m.getGrille().getJeux()[i][j].getTypeMap() != null){
			cpt++;
		}*/
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < m.getLargeur(); j++) {
				if(m.getGrille().getJeux()[i][j].getTypeMap() == TypeMap.MORT){
        			tabButton[i][j].setIcon(iconMort);
            	}else if(m.getGrille().getJeux()[i][j].getTypeMap() == TypeMap.VIVANT){
            		tabButton[i][j].setIcon(iconVivant);
            	}
			}
		}
			
        
	}

}
