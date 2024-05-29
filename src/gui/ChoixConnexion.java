package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChoixConnexion {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoixConnexion window = new ChoixConnexion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChoixConnexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Choix Utilisateur");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(BailAgent.class.getResource("/model/IDAELicone.jpg")));
		frame.getContentPane().setBackground(new Color(245, 222, 179));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1290, 630);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null); // Centre le JFrame sur l'écran
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 164, 96));
		panel.setBounds(10, 158, 1266, 425);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("Locataire");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ouverture de la fenêtre de connexion du locataire
				try {
					IdentificationLocataire window = new IdentificationLocataire();
					window.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnNewButton.setBounds(443, 59, 318, 66);
		panel.add(btnNewButton);
		
		JButton btnBailleur = new JButton("Bailleur");
		btnBailleur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ouverture de la fenêtre de connexion du bailleur
				try {
					IdentificationBailleur window = new IdentificationBailleur();
					window.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnBailleur.setForeground(Color.BLUE);
		btnBailleur.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnBailleur.setBounds(443, 152, 318, 66);
		panel.add(btnBailleur);
		
		JButton btnAgent = new JButton("Agent");
		btnAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ouverture de la fenêtre de connexion de l'Agent
				try {
					IdentificationAgent window = new IdentificationAgent();
					window.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnAgent.setForeground(Color.BLUE);
		btnAgent.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnAgent.setBounds(443, 244, 318, 66);
		panel.add(btnAgent);
		
		JLabel lblNewLabel = new JLabel("AUTHENTIFICATION");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(138, 43, 226));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(392, 32, 424, 80);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("IDAEL");
		lblNewLabel_1.setForeground(new Color(255, 165, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(24, 11, 85, 36);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
