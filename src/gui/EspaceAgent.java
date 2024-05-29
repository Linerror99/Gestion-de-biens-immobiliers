package gui;

import java.awt.EventQueue;
import model.Agent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EspaceAgent {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Agent agent = new Agent("p", "p", "p");
				try {
					EspaceAgent window = new EspaceAgent(agent);
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
	public EspaceAgent(Agent agent) {
		initialize(agent);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Agent agent) {
		frame = new JFrame();
		frame.setTitle("Espace Agent");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(BailAgent.class.getResource("/model/IDAELicone.jpg")));
		frame.getContentPane().setBackground(new Color(245, 222, 179));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1290, 630);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null); // Centre le JFrame sur l'écran
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 11, 1264, 204);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IDAEL");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 89, 44);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(agent.getAgt_nom());
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(1165, 66, 89, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(agent.getAgt_prenom());
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(1165, 79, 89, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblEspaceLocataire = new JLabel("ESPACE AGENT");
		lblEspaceLocataire.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspaceLocataire.setForeground(new Color(138, 43, 226));
		lblEspaceLocataire.setFont(new Font("Times New Roman", Font.BOLD, 43));
		lblEspaceLocataire.setBounds(321, 90, 593, 90);
		panel.add(lblEspaceLocataire);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(agent.getAgt_id());
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(1165, 94, 89, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(244, 164, 96));
		panel_1.setBounds(0, 226, 1264, 354);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Consulter Bails");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BailAgent window = new BailAgent(agent);
					window.frmTousLesBails.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(68, 22, 283, 106);
		panel_1.add(btnNewButton);
		
		JButton btnRechercherLocation = new JButton("Valider bien immobilier");
		btnRechercherLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ValidationDepotBien window = new ValidationDepotBien(agent);
					window.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnRechercherLocation.setForeground(Color.BLACK);
		btnRechercherLocation.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnRechercherLocation.setBounds(887, 22, 283, 106);
		panel_1.add(btnRechercherLocation);
		
		JButton btnNewButton_1_1 = new JButton("DECONNEXION");
		btnNewButton_1_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {
					ChoixConnexion window = new ChoixConnexion();
					window.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_1_1.setBounds(1111, 294, 143, 49);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnValiderDemandeLocation = new JButton("Valider demande location");
		btnValiderDemandeLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ValiderDemandeLocation window = new ValiderDemandeLocation(agent);
					window.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnValiderDemandeLocation.setForeground(Color.BLACK);
		btnValiderDemandeLocation.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnValiderDemandeLocation.setBounds(489, 22, 283, 106);
		panel_1.add(btnValiderDemandeLocation);
		
		JButton btnCrerBails = new JButton("Créer Bails");
		btnCrerBails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BailCree window = new BailCree(agent);
					window.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnCrerBails.setForeground(Color.BLACK);
		btnCrerBails.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCrerBails.setBounds(489, 159, 283, 106);
		panel_1.add(btnCrerBails);
	}
}
