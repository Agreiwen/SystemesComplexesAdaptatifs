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
import jeuDeLaVie.controleur.EcouteurGo;
import jeuDeLaVie.controleur.EcouteurOk;
import jeuDeLaVie.controleur.EcouteurTextFieldMaxViavnt;
import jeuDeLaVie.controleur.EcouteurTextFieldRegle;
import jeuDeLaVie.controleur.EcouteurUneDimension;
import jeuDeLaVie.modele.Modele;

public class VueMethode extends JFrame implements Observer{
	
	protected Modele m;
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
	protected JButton jBouttonGo;
	
	private static final int LONGUEUR_METHODE = 350;
	private static final int LARGEUR_METHODE = 170;
	
	public VueMethode(Modele m){
		super("Parametre automate cellulaire");
		this.m = m;
		m.addObserver(this);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setPreferredSize(new Dimension(LONGUEUR_METHODE, LARGEUR_METHODE));
	    Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	    System.out.println(bounds.getMinY()+" "+bounds.getMinX());
	    this.setLocation((int)(bounds.getMaxX()/2-LONGUEUR_METHODE-((bounds.getMaxY()*5)/100)),(int)(bounds.getMaxY()/2-LARGEUR_METHODE/2+((bounds.getMaxY()*5)/100)));
	    GridLayout ensemble = new GridLayout(3, 1);
	    this.setLayout(ensemble);
	    
	    jPanelMethode = new JPanel();
	    jLabelTexteMethode = new JLabel("Methode :");
	    jPanelMethode.add(jLabelTexteMethode);
	    jCheckBoxJeuDeLaVie = new JCheckBox("Jeu de la vie");
	    jCheckBoxJeuDeLaVie.addItemListener(new EcouteurCheckBoxJeuDeLaVie(m));
	    jCheckBoxParite = new JCheckBox("Parite");
	    jCheckBoxParite.addItemListener(new EcouteurCheckBoxParite(m));
	    jLabelRegle = new JLabel("Regle :");
	    jTextFieldRegle = new JTextField(3);
	    jTextFieldRegle.addKeyListener(new EcouteurTextFieldRegle(m));
	    jPanelMethode.add(jCheckBoxJeuDeLaVie);
	    jPanelMethode.add(jCheckBoxParite);
	    jPanelMethode.add(jLabelRegle);
	    jPanelMethode.add(jTextFieldRegle);
	    this.add(jPanelMethode);
	    
	    jPanelMaxVivant = new JPanel();
	    jLabelMaxVivant = new JLabel("Max Vivant");
	    jTextFieldMaxVivant = new JTextField(3);
	    jTextFieldMaxVivant.addKeyListener(new EcouteurTextFieldMaxViavnt(m));
	    jPanelMaxVivant.add(jLabelMaxVivant);
	    jPanelMaxVivant.add(jTextFieldMaxVivant);
	    this.add(jPanelMaxVivant);
	    
	    jPanelGo = new JPanel();
	    jBouttonGo = new JButton("Ok");
	    jBouttonGo.addActionListener(new EcouteurGo(m));
	    jPanelGo.add(jBouttonGo);
	    this.add(jPanelGo);
	    
	    pack() ;
        setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
	
	

}
