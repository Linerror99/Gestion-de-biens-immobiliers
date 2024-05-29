package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import dao.AgentDAO;
import model.Agent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class IdentificationAgent {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IdentificationAgent window = new IdentificationAgent();
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
	public IdentificationAgent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setTitle("Connexion Agent");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(BailAgent.class.getResource("/model/IDAELicone.jpg")));
		frame.setBackground(new Color(0, 0, 255));
		frame.getContentPane().setBackground(new Color(245, 222, 179));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1290, 630);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null); // Centre le JFrame sur l'écran
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 164, 96));
		panel.setBounds(0, 158, 1276, 425);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("QUITTER");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnNewButton.setBounds(892, 266, 318, 66);
		panel.add(btnNewButton);
		
		JButton btnAgent = new JButton("S'INSCRIRE");
		btnAgent.setBackground(new Color(154, 205, 50));
		btnAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InscriptionAgent window = new InscriptionAgent();
					window.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnAgent.setForeground(Color.BLUE);
		btnAgent.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnAgent.setBounds(91, 266, 318, 66);
		panel.add(btnAgent);
		
		JButton btnAgent1 = new JButton("SE CONNECTER");
		btnAgent1.setBackground(new Color(154, 205, 50));
		btnAgent1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Agent agt = new Agent(textField.getText(), passwordField.getText(), passwordField_1.getText());
				AgentDAO agtDao = new AgentDAO ();
				Agent agtx = agtDao.get(agt.getAgt_id());
				if(agtDao.connexion(agt)) {
					try {
						EspaceAgent window = new EspaceAgent(agtx);
						window.frame.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					frame.dispose();
				}
			}
		});
		btnAgent1.setForeground(Color.BLUE);
		btnAgent1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnAgent1.setBounds(477, 266, 318, 66);
		panel.add(btnAgent1);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(357, 57, 103, 36);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel1 = new JLabel("IDAEL");
		lblNewLabel1.setBounds(25, 11, 114, 44);
		frame.getContentPane().add(lblNewLabel1);
		lblNewLabel1.setForeground(Color.ORANGE);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		
		textField = new JTextField();
		textField.setBackground(new Color(245, 245, 220));
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setBounds(496, 62, 248, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(357, 104, 103, 36);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("AGENT CODE");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(357, 155, 129, 36);
		panel.add(lblNewLabel_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(245, 245, 220));
		passwordField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		passwordField.setBounds(496, 109, 248, 29);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBackground(new Color(245, 245, 220));
		passwordField_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		passwordField_1.setBounds(496, 155, 248, 29);
		panel.add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("IDENTIFICATION");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 33));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(392, 32, 424, 80);
		frame.getContentPane().add(lblNewLabel);
	}
}
