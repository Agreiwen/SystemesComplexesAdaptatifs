package jeudelavie1d.vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import jeudelavie1d.controleur.EcouteurMenuAleatoire;
import jeudelavie1d.controleur.EcouteurMenuComplet;
import jeudelavie1d.controleur.EcouteurMenuLancer;
import jeudelavie1d.controleur.EcouteurMenuMort;
import jeudelavie1d.controleur.EcouteurMenuVide;
import jeudelavie1d.controleur.EcouteurMenuVivant;
import jeudelavie1d.controleur.EcouteurNouveau;
import jeudelavie1d.controleur.EcouteurQuitter;
import jeudelavie1d.modele.Modele;

@SuppressWarnings("serial")
public class VueMenu extends JMenuBar implements Observer{
	
protected Modele m;
	
	protected JMenu jMenuFichier;
	protected JMenu jMenuConstruire;
	protected JMenu jMenuALaMain;
	protected JMenuItem jMenuAleatoire;
	protected JMenuItem jMenuItemNouveau;
	protected JMenuItem jMenuItemQuitter;
	protected JMenuItem jMenuItemMort;
	protected JMenuItem jMenuItemVivant;
	protected JMenu jMenuChoixGrille;
	protected JMenuItem jMenuVide;
	protected JMenuItem jMenuPasDeTemps;
	protected JMenuItem jMenuComplet;

	public VueMenu(Modele m) {
		super();
		this.m = m;
		m.addObserver(this);
		
		jMenuFichier = new JMenu("Fichier");
		jMenuItemNouveau = new JMenuItem("Nouveau");
		jMenuItemNouveau.addActionListener(new EcouteurNouveau(m));
		jMenuItemQuitter = new JMenuItem("Quitter");
		jMenuItemQuitter.addActionListener(new EcouteurQuitter(m));
		jMenuFichier.add(jMenuItemNouveau);
		jMenuFichier.add(jMenuItemQuitter);
		this.add(jMenuFichier);
		
		jMenuChoixGrille = new JMenu("Choix grille");
		jMenuAleatoire = new JMenuItem("Aleatoire");
		jMenuAleatoire.addActionListener(new EcouteurMenuAleatoire(m));
		jMenuVide = new JMenuItem("Grille Vide");
		jMenuVide.addActionListener(new EcouteurMenuVide(m));
		jMenuChoixGrille.add(jMenuVide);
		jMenuChoixGrille.add(jMenuAleatoire);
		this.add(jMenuChoixGrille);
		
		jMenuConstruire = new JMenu("Construire");
		jMenuItemMort = new JMenuItem("Mort");
		jMenuItemMort.addActionListener(new EcouteurMenuMort(m));
		jMenuItemVivant = new JMenuItem("Vivant");
		jMenuItemVivant.addActionListener(new EcouteurMenuVivant(m));
		jMenuConstruire.add(jMenuItemMort);
		jMenuConstruire.add(jMenuItemVivant);
		this.add(jMenuConstruire);
		
		jMenuPasDeTemps = new JMenuItem("Pas de temps");
		jMenuPasDeTemps.addActionListener(new EcouteurMenuLancer(m));
		this.add(jMenuPasDeTemps);
		
		jMenuComplet = new JMenuItem("Complet");
		jMenuComplet.addActionListener(new EcouteurMenuComplet(m));
		this.add(jMenuComplet);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void update(Observable o, Object arg) {
		jMenuConstruire.show(!m.isRun());
	}

}
