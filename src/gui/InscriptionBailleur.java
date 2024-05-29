package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import dao.BailleurDAO;
import model.Bailleur;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class InscriptionBailleur {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriptionBailleur window = new InscriptionBailleur();
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
	public InscriptionBailleur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setTitle("Inscription Baileur");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(BailAgent.class.getResource("/model/IDAELicone.jpg")));
		frame.getContentPane().setBackground(new Color(245, 222, 179));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1290, 630);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null); // Centre le JFrame sur l'écran
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 164, 96));
		panel.setBounds(10, 100, 1266, 483);
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
		btnNewButton.setBounds(911, 359, 318, 66);
		panel.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(42, 31, 103, 36);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(181, 36, 248, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(42, 89, 103, 36);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(181, 94, 248, 29);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("NOM");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(42, 138, 103, 36);
		panel.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(181, 143, 248, 29);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("PRENOM");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(42, 194, 103, 36);
		panel.add(lblNewLabel_1_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(181, 199, 248, 29);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("ADRESSE");
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1_3.setBounds(42, 253, 103, 36);
		panel.add(lblNewLabel_1_1_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(181, 258, 248, 29);
		panel.add(textField_4);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("EMAIL");
		lblNewLabel_1_1_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1_4.setBounds(611, 31, 103, 36);
		panel.add(lblNewLabel_1_1_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(769, 36, 248, 29);
		panel.add(textField_5);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("AGE");
		lblNewLabel_1_1_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1_5.setBounds(611, 89, 103, 36);
		panel.add(lblNewLabel_1_1_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(769, 94, 248, 29);
		panel.add(textField_6);
		
		JButton btnBailleur = new JButton("S'INSCRIRE");
		btnBailleur.setBackground(new Color(154, 205, 50));
		btnBailleur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_2.getText().equals("") || textField_3.getText().equals("") || textField_6.getText().equals("") || textField_4.getText().equals("") || textField_5.getText().equals("") || textField.getText().equals("") || textField_1.getText().equals("")  ) {
					JOptionPane.showMessageDialog(new JFrame(), "Veuillez remplir tous les champs !",
							"Champs obligatoires", JOptionPane.ERROR_MESSAGE);
				}else {
					Bailleur bllr = new Bailleur(textField_2.getText(),textField_3.getText(), Integer.parseInt(textField_6.getText()), textField_4.getText(), textField_5.getText(), textField.getText(), textField_1.getText());
					BailleurDAO bllrDao = new BailleurDAO ();
					bllrDao.add(bllr);
					textField_2.setText("");
					textField_3.setText(""); 
					textField_6.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField.setText("");
					textField_1.setText("");
				}
				
			}
		});
		btnBailleur.setForeground(Color.BLUE);
		btnBailleur.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnBailleur.setBounds(514, 359, 318, 66);
		panel.add(btnBailleur); 
		
		//****** Définir le bouton par défaut ******
        frame.getRootPane().setDefaultButton(btnBailleur);
        
        btnBailleur.setMnemonic(KeyEvent.VK_ENTER);
		
		JLabel lblNewLabel = new JLabel("INSCRIPTION");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(138, 43, 226));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(353, 10, 424, 80);
		frame.getContentPane().add(lblNewLabel);
	}
}
