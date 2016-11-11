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

import jeuDeLaVie.controleur.EcouteurDeuxDimension;
import jeuDeLaVie.controleur.EcouteurMoore8;
import jeuDeLaVie.controleur.EcouteurMoore9;
import jeuDeLaVie.controleur.EcouteurOk;
import jeuDeLaVie.controleur.EcouteurTexteFieldLargeur;
import jeuDeLaVie.controleur.EcouteurTexteFieldLongueur;
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
	protected JButton jBouttonOk;

	private static final int LONGUEUR_PARAMETRAGE = 350;
	private static final int LARGEUR_PARAMETRAGE = 170;
	
	public VueParametrage(Modele m) {
		super("Parametre automate cellulaire");
		this.m = m;
		m.addObserver(this);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setPreferredSize(new Dimension(LONGUEUR_PARAMETRAGE, LARGEUR_PARAMETRAGE));
	    Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	    System.out.println(bounds.getMinY()+" "+bounds.getMinX());
	    this.setLocation((int)(bounds.getMaxX()/2-LONGUEUR_PARAMETRAGE-((bounds.getMaxY()*5)/100)),(int)(bounds.getMaxY()/2-LARGEUR_PARAMETRAGE-((bounds.getMaxY()*5)/100)));
	    GridLayout ensemble = new GridLayout(4, 1);
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
	    jPanelVoisinage.add(jLabelTexteVoisinage);
	    jPanelVoisinage.add(jCheckBoxMoore8);
	    jPanelVoisinage.add(jCheckBoxMoore9);
	    this.add(jPanelVoisinage);
	    
	    jPanelOk = new JPanel();
	    jBouttonOk = new JButton("Ok");
	    jBouttonOk.addActionListener(new EcouteurOk(m,jTextFieldLargeur,jTextFieldLongueur));
	    jPanelOk.add(jBouttonOk);
	    this.add(jPanelOk);
	    
	    pack() ;
        setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(m.getDimension() == 1){
			jCheckBoxDeuxDimensions.setSelected(false);
			jTextFieldLargeur.setEnabled(false);
		}else{
			jCheckBoxUneDimension.setSelected(false);
			jTextFieldLargeur.setEnabled(true);
		}
		if(m.getVoisinage() == 1){
			jCheckBoxMoore9.setSelected(false);
		}else{
			jCheckBoxMoore8.setSelected(false);
		}
		System.out.println("Dimension : "+m.getDimension()+" Voisinage : "+m.getVoisinage()+"Taille X :"+m.getLargeur()+"Taille Y : "+m.getLongueur());
	}

}
