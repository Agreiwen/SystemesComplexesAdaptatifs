package jeuDeLaVie.vue;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jeuDeLaVie.controleur.EcouteurCheckBoxJeuDeLaVie;
import jeuDeLaVie.controleur.EcouteurCheckBoxParite;
import jeuDeLaVie.controleur.EcouteurDeuxDimension;
import jeuDeLaVie.controleur.EcouteurFermer;
import jeuDeLaVie.controleur.EcouteurGo;
import jeuDeLaVie.controleur.EcouteurMoore8;
import jeuDeLaVie.controleur.EcouteurMoore9;
import jeuDeLaVie.controleur.EcouteurOk;
import jeuDeLaVie.controleur.EcouteurTextFieldMaxVivant;
import jeuDeLaVie.controleur.EcouteurTextFieldRegle;
import jeuDeLaVie.controleur.EcouteurTexteFieldLargeur;
import jeuDeLaVie.controleur.EcouteurTexteFieldLongueur;
import jeuDeLaVie.controleur.EcouteurTorique;
import jeuDeLaVie.controleur.EcouteurUneDimension;
import jeuDeLaVie.modele.Modele;

@SuppressWarnings("serial")
public class VueParametrage extends JFrame implements Observer{
	
	protected Modele m;
	protected JPanel jPanelDimension;
	protected JPanel jPanelTaille;
	protected JPanel jPanelVoisinage;
	protected JPanel jPanelOk;
	protected JLabel jLabelTexteDimension;
	protected JLabel jLabelTaille;
	protected JLabel jLabelX;
	protected JLabel jLabelY;
	protected JLabel jLabelTexteVoisinage;
	protected JTextField jTextFieldLongueur;
	protected JTextField jTextFieldLargeur;
	protected JCheckBox jCheckBoxUneDimension;
	protected JCheckBox jCheckBoxDeuxDimensions;
	protected JCheckBox jCheckBoxMoore8;
	protected JCheckBox jCheckBoxMoore9;
	protected JCheckBox jCheckBoxTorique;
	protected JButton jBouttonOk;
	protected JButton jBouttonGo;
	protected JButton jBouttonFermer;
	protected JPanel jPanelMethode;
	protected JPanel jPanelMaxVivant;
	protected JPanel jPanelGo;
	protected JLabel jLabelTexteMethode;
	protected JLabel jLabelMaxVivant;
	protected JLabel jLabelRegle;
	protected JTextField jTextFieldMaxVivant;
	protected JTextField jTextFieldRegle;
	protected JCheckBox jCheckBoxJeuDeLaVie;
	protected JCheckBox jCheckBoxParite;

	private static final int LONGUEUR_PARAMETRAGE = 350;
	private static final int LARGEUR_PARAMETRAGE = 250;
	
	public VueParametrage(Modele m) {
		super("Parametres automate cellulaire");
		this.m = m;
		m.addObserver(this);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setPreferredSize(new Dimension(LONGUEUR_PARAMETRAGE, LARGEUR_PARAMETRAGE));
	    Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	    this.setLocation((int)(bounds.getMaxX()/2-LONGUEUR_PARAMETRAGE-((bounds.getMaxY()*5)/100)),(int)(bounds.getMaxY()/2-LARGEUR_PARAMETRAGE/2));
	    GridLayout ensemble = new GridLayout(6, 1);
	    this.setLayout(ensemble);
	    
	    jPanelDimension = new JPanel();
	    jLabelTexteDimension = new JLabel("Dimension :");
	    jPanelDimension.add(jLabelTexteDimension);
	    jCheckBoxUneDimension = new JCheckBox("1D");
	    jCheckBoxUneDimension.addItemListener(new EcouteurUneDimension(m));
	    jCheckBoxDeuxDimensions = new JCheckBox("2D");
	    jCheckBoxDeuxDimensions.addItemListener(new EcouteurDeuxDimension(m));
	    jPanelDimension.add(jCheckBoxUneDimension);
	    jPanelDimension.add(jCheckBoxDeuxDimensions);
	    this.add(jPanelDimension);
	    
	    jPanelTaille = new JPanel();
	    jLabelTaille = new JLabel("Taille :");
	    jLabelX = new JLabel("X :");
	    jTextFieldLongueur = new JTextField(3);
	    jTextFieldLongueur.addKeyListener(new EcouteurTexteFieldLongueur(m,jTextFieldLongueur));
	    jLabelY = new JLabel("Y :");
	    jTextFieldLargeur = new JTextField(3);
	    jTextFieldLargeur.addKeyListener(new EcouteurTexteFieldLargeur(m,jTextFieldLargeur));
	    jPanelTaille.add(jLabelTaille);
	    jPanelTaille.add(jLabelX);
	    jPanelTaille.add(jTextFieldLongueur);
	    jPanelTaille.add(jLabelY);
	    jPanelTaille.add(jTextFieldLargeur);
	    this.add(jPanelTaille);

	    jPanelVoisinage = new JPanel();
	    jLabelTexteVoisinage = new JLabel("Voisinage :");
	    jCheckBoxMoore8 = new JCheckBox("Moore 8");
	    jCheckBoxMoore8.addItemListener(new EcouteurMoore8(m));
	    jCheckBoxMoore9 = new JCheckBox("Moore 9");
	    jCheckBoxMoore9.addItemListener(new EcouteurMoore9(m));
	    jCheckBoxTorique = new JCheckBox("Torique");
	    jCheckBoxTorique.addItemListener(new EcouteurTorique(m));
	    jPanelVoisinage.add(jLabelTexteVoisinage);
	    jPanelVoisinage.add(jCheckBoxMoore8);
	    jPanelVoisinage.add(jCheckBoxMoore9);
	    jPanelVoisinage.add(jCheckBoxTorique);
	    this.add(jPanelVoisinage);
	    
	    jPanelMethode = new JPanel();
	    jLabelTexteMethode = new JLabel("Methode :");
	    jPanelMethode.add(jLabelTexteMethode);
	    jCheckBoxJeuDeLaVie = new JCheckBox("Jeu de la vie");
	    jCheckBoxJeuDeLaVie.addItemListener(new EcouteurCheckBoxJeuDeLaVie(m));
	    jCheckBoxParite = new JCheckBox("Parite");
	    jCheckBoxParite.addItemListener(new EcouteurCheckBoxParite(m));
	    jLabelRegle = new JLabel("Regle :");
	    jTextFieldRegle = new JTextField(3);
	    jTextFieldRegle.addKeyListener(new EcouteurTextFieldRegle(m, jTextFieldRegle));
	    jPanelMethode.add(jCheckBoxJeuDeLaVie);
	    jPanelMethode.add(jCheckBoxParite);
	    jPanelMethode.add(jLabelRegle);
	    jPanelMethode.add(jTextFieldRegle);
	    this.add(jPanelMethode);
	    
	    jPanelMaxVivant = new JPanel();
	    jLabelMaxVivant = new JLabel("Max Vivant");
	    jTextFieldMaxVivant = new JTextField(3);
	    jTextFieldMaxVivant.addKeyListener(new EcouteurTextFieldMaxVivant(m, jTextFieldMaxVivant));
	    jPanelMaxVivant.add(jLabelMaxVivant);
	    jPanelMaxVivant.add(jTextFieldMaxVivant);
	    this.add(jPanelMaxVivant);
	    
	    jPanelOk = new JPanel();
	    jBouttonOk = new JButton("Ok");
	    jBouttonOk.addActionListener(new EcouteurOk(m,jTextFieldLargeur,jTextFieldLongueur,jTextFieldMaxVivant));
	    jPanelOk.add(jBouttonOk);
	    jBouttonGo = new JButton("Go !");
	    jBouttonGo.addActionListener(new EcouteurGo(m));
	    jPanelOk.add(jBouttonGo);
	    jBouttonGo.setVisible(false);
	    jBouttonFermer = new JButton("Fermer");
	    jBouttonFermer.addActionListener(new EcouteurFermer(m));
	    jPanelOk.add(jBouttonFermer);
	    jBouttonFermer.setVisible(false);
	    this.add(jPanelOk);
	    
	    pack() ;
        setVisible(true);
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append("Dimension : "+m.getDimension()+"\n");
		s.append("Largeur : "+m.getLargeur()+"\n");
		s.append("Longueur : "+m.getLongueur()+"\n");
		if(m.getDimension() == 2 && m.getVoisinage() == 1){
			s.append("Voisinage : Moore 8\n");
		}else if(m.getDimension() == 2 && m.getVoisinage() == 2){
			s.append("Voisinage : Moore 9\n");
		}
		if(m.getDimension() == 2 && m.getMethode() == 1){
			s.append("Methode : Regle du jeu de la vie\n");
		}else if(m.getDimension() == 2 && m.getMethode() == 2){
			s.append("Methode : Parite\n");
		}
		if(m.getDimension() == 1){
			s.append("Regle : "+m.getRegle()+"\n");
		}
		s.append("Etape Parametrage : "+m.getEtapeParametrage()+"\n");
		s.append("Torique : "+m.isTorique()+"\n");
		return s.toString();
	}

	@Override
	public void update(Observable o, Object arg) {
		if(m.getDimension() == 1){
			jCheckBoxDeuxDimensions.setSelected(false);
			jTextFieldLargeur.setEnabled(false);
			jLabelY.setEnabled(false);
			
			jCheckBoxParite.setEnabled(false);
			jCheckBoxParite.setSelected(false);
			jCheckBoxJeuDeLaVie.setEnabled(false);
			jCheckBoxJeuDeLaVie.setSelected(false);
			
			jLabelTexteVoisinage.setEnabled(false);
			jCheckBoxMoore8.setEnabled(false);
			jCheckBoxMoore9.setEnabled(false);
			jCheckBoxMoore8.setSelected(false);
			jCheckBoxMoore9.setSelected(false);
			jLabelRegle.setEnabled(true);
			jTextFieldRegle.setEnabled(true);
		}else{
			jCheckBoxUneDimension.setSelected(false);
			jTextFieldLargeur.setEnabled(true);
			jLabelY.setEnabled(true);
			jCheckBoxParite.setEnabled(true);
			jCheckBoxJeuDeLaVie.setEnabled(true);
			jLabelTexteVoisinage.setEnabled(true);
			jCheckBoxMoore8.setEnabled(true);
			jCheckBoxMoore9.setEnabled(true);
			jLabelRegle.setEnabled(false);
			jTextFieldRegle.setEnabled(false);
			if(m.getMethode() == 1){
				jCheckBoxParite.setSelected(false);
			}else{
				jCheckBoxJeuDeLaVie.setSelected(false);
			}
			if(m.getVoisinage() == 1){
				jCheckBoxMoore9.setSelected(false);
			}else{
				jCheckBoxMoore8.setSelected(false);
			}
		}
		switch(m.getEtapeParametrage()){
		case 1 :
			jBouttonOk.setVisible(true);
			jBouttonGo.setVisible(false);
			jBouttonFermer.setVisible(false);
			break;
		case 2 :
			jBouttonOk.setVisible(false);
			jBouttonGo.setVisible(true);
			jBouttonFermer.setVisible(false);
			break;
		case 3 :
			jBouttonOk.setVisible(false);
			jBouttonGo.setVisible(false);
			jBouttonFermer.setVisible(true);
			break;
		}
		
		//System.out.println(toString()+"\n");
	}

}
