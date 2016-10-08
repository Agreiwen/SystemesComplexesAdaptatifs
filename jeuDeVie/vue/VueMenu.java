package jeuDeVie.vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import jeuDeVie.controleur.EcouteurMenuMort;
import jeuDeVie.controleur.EcouteurMenuVivant;
import jeuDeVie.controleur.EcouteurNouveau;
import jeuDeVie.controleur.EcouteurQuitter;
import jeuDeVie.modele.Modele;

@SuppressWarnings("serial")
public class VueMenu extends JMenuBar implements Observer{
	
protected Modele m;
	
	protected JMenu jMenuFichier;
	protected JMenu jMenuConstruire;
	protected JMenuItem jMenuItemNouveau;
	protected JMenuItem jMenuItemQuitter;
	protected JMenuItem jMenuItemMort;
	protected JMenuItem jMenuItemVivant;

	public VueMenu(Modele m) {
		super();
		this.m = m;
		m.addObserver(this);
		
		jMenuFichier = new JMenu("Fichier");
		jMenuConstruire = new JMenu("Construire");
		
		jMenuItemNouveau = new JMenuItem("Nouveau");
		jMenuItemNouveau.addActionListener(new EcouteurNouveau(m));
		
		jMenuItemQuitter = new JMenuItem("Quitter");
		jMenuItemQuitter.addActionListener(new EcouteurQuitter(m));
		
		jMenuItemMort = new JMenuItem("Mur");
		jMenuItemMort.addActionListener(new EcouteurMenuMort(m));
		
		jMenuItemVivant = new JMenuItem("Passage");
		jMenuItemVivant.addActionListener(new EcouteurMenuVivant(m));
		
		this.add(jMenuFichier);
		this.add(jMenuConstruire);
		
		jMenuFichier.add(jMenuItemNouveau);
		jMenuFichier.add(jMenuItemQuitter);
		jMenuConstruire.add(jMenuItemMort);
		jMenuConstruire.add(jMenuItemVivant);
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
