package qrporject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


 
	 
	public class frame extends JFrame implements ActionListener {
		
	
		private panneau pan = new panneau();
		private panneau pan1 = new panneau();
		private panneau pan2 = new panneau();
		
		CardLayout cl = new CardLayout();//panneaau

		private JButton bouton = new JButton("Scan a QR code");
		private JButton bouton1 = new JButton("QR code 1");
		private JButton bouton2 = new JButton("QR code 2");
		private JButton bouton3 = new JButton("QR code 3");
		private JButton bouton4 = new JButton("QR code error case 1");
		private JButton bouton5 = new JButton("QR code error case 2");
		private JButton bouton6 = new JButton("Scan another QR code");
		private JButton bouton7 = new JButton("Play sound");
		
		private JPanel contentscreen = new JPanel();
		private JPanel contentbouton = new JPanel();
		private JPanel container = new JPanel();
		private JPanel south = new JPanel();
		private JPanel south2 = new JPanel();
		private JLabel label = new JLabel("Le JLabel");
		
		String[] listscreen= {"card1","card2","card3"};
		String[] listBouton= {"set1","set2","set3"};
		
		
		
	  public frame(){
		
		  this.setTitle("QR code Scanner");
		    this.setSize(1250, 800);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    container.setBackground(Color.white);
		    contentbouton.setLayout(cl);
		    contentscreen.setLayout(cl);
		    container.setLayout(new BorderLayout());
		    pan.state=0;
		    pan1.state=1;
		    pan2.state=2;
		    contentscreen.add(pan,listscreen[0]);
		    contentscreen.add(pan1,listscreen[1]);
		    contentscreen.add(pan2,listscreen[2]);
		    
		    
		    south.add(bouton1);
		    south.add(bouton2);
		    south.add(bouton3);
		    south.add(bouton4);
		    south.add(bouton5);
		    
		    south2.add(bouton6);
		    south2.add(bouton7);
		    
		    contentbouton.add(bouton,listBouton[0]);
		    contentbouton.add(south,listBouton[1]);
		    contentbouton.add(south2,listBouton[2]);

		  //Définition d'une police d'écriture
		    Font police = new Font("Tahoma", Font.BOLD, 16);
		    //On l'applique au JLabel
		    label.setFont(police);
		    //Changement de la couleur du texte
		    label.setForeground(Color.blue);
		    //On modifie l'alignement du texte grâce aux attributs statiques
		    //de la classe JLabel
		    label.setHorizontalAlignment(JLabel.CENTER);
		    
		    bouton.addActionListener(this);
		    bouton1.addActionListener(this);
		    bouton2.addActionListener(this);
		    bouton3.addActionListener(this);
		    bouton4.addActionListener(this);
		    bouton5.addActionListener(this);
		    bouton6.addActionListener(this);
		    bouton7.addActionListener(this);
		    
		    container.add(contentscreen,BorderLayout.CENTER);
		    container.add(contentbouton,BorderLayout.SOUTH);
		    container.add(label, BorderLayout.NORTH);

		    this.setContentPane(container);
		    this.setVisible(true); 
	  }
	  public void actionPerformed(ActionEvent arg0) {
		    //Lorsque l'on clique sur le bouton, on met à jour le JLabel
		   
		    
		    if(arg0.getSource() == bouton)
		    	label.setText("Choose a QR code");
		    cl.show(contentscreen,listscreen[1]);
	    	cl.show(contentbouton,listBouton[1]);
	    	
		    	

		      if(arg0.getSource() == bouton1) {
		        label.setText("Scanning QR code 1");
		        cl.show(contentscreen,listscreen[2]);
		    	cl.show(contentbouton,listBouton[2]);
		    	pan2.select=1;
		       
		      }
		      if(arg0.getSource() == bouton2) {
			        label.setText("Scanning QR code 2");
			        cl.show(contentscreen,listscreen[2]);
			    	cl.show(contentbouton,listBouton[2]);
			    	pan2.select=2;
			      }
		      if(arg0.getSource() == bouton3) {
			        label.setText("Scanning QR code 3");
			        cl.show(contentscreen,listscreen[2]);
			    	cl.show(contentbouton,listBouton[2]);
			    	pan2.select=3;
			      }
		      if(arg0.getSource() == bouton4) {
			        label.setText("Scanning QR code error case 1");
			        cl.show(contentscreen,listscreen[2]);
			    	cl.show(contentbouton,listBouton[2]);
			    	pan2.select=4;
			      }
		      if(arg0.getSource() == bouton5) {
			        label.setText("Scanning QR code error case 2");
			        cl.show(contentscreen,listscreen[2]);
			    	cl.show(contentbouton,listBouton[2]);
			    	pan2.select=5;
			      }
		      if(arg0.getSource() == bouton6) {
			        label.setText("Choose a QR code");
			        cl.show(contentscreen,listscreen[1]);
			    	cl.show(contentbouton,listBouton[1]);
			      }
		      if(arg0.getSource() == bouton7) {
			        label.setText("playing sound");
			        cl.show(contentscreen,listscreen[2]);
			    	cl.show(contentbouton,listBouton[2]);
			
			      }
		  }
	}


