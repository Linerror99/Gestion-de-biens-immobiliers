package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import dao.LocataireDAO;
import model.Locataire;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class IdentificationLocataire {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IdentificationLocataire window = new IdentificationLocataire();
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
	public IdentificationLocataire() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setTitle("Connexion Locataire");
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

		JButton btnNewButton = new JButton("QUITTER");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnNewButton.setBounds(889, 296, 318, 66);
		panel.add(btnNewButton);

		JButton btnBailleur = new JButton("S'INSCRIRE");
		btnBailleur.setBackground(new Color(154, 205, 50));
		btnBailleur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InscriptionLocataire window = new InscriptionLocataire();
					window.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnBailleur.setForeground(Color.BLUE);
		btnBailleur.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnBailleur.setBounds(88, 296, 318, 66);
		panel.add(btnBailleur);

		JButton btnAgent = new JButton("SE CONNECTER");
		btnAgent.setBackground(new Color(154, 205, 50));
		btnAgent.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Locataire lct = new Locataire(textField.getText(), passwordField.getText());
				LocataireDAO lctDao = new LocataireDAO();
				Locataire lctx = LocataireDAO.get(lct.getLct_id());
				if (lctDao.connexion(lct)) {
					try {
						EspaceLocataire window = new EspaceLocataire(lctx);
						window.frame.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					frame.dispose();
				}
			}
		});
		btnAgent.setForeground(Color.BLUE);
		btnAgent.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnAgent.setBounds(474, 296, 318, 66);
		panel.add(btnAgent);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(364, 160, 103, 36);
		panel.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(503, 165, 248, 29);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(364, 218, 103, 36);
		panel.add(lblNewLabel_1_1);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(503, 218, 248, 29);
		panel.add(passwordField);

		JLabel lblNewLabel = new JLabel("IDENTIFICATION");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 33));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(392, 32, 424, 80);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel1 = new JLabel("IDAEL");
		lblNewLabel1.setBounds(25, 11, 89, 44);
		frame.getContentPane().add(lblNewLabel1);
		lblNewLabel1.setForeground(Color.ORANGE);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	}
}
