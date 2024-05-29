package gui;

import java.awt.EventQueue;


import dao.BailleurDAO;
import dao.MaisonDAO;
import dao.AppartementDAO;
import model.Maison;
import model.Appartement;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import model.Bailleur;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class DepotdeBien   {

	public JFrame frame ;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Bailleur bailleur = new Bailleur("z", "z", "z");
				try {
					DepotdeBien window = new DepotdeBien(bailleur);
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
	public DepotdeBien(Bailleur bailleur) {
		initialize(bailleur);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Bailleur bailleur) {
		MaisonDAO msnDao = new MaisonDAO();
		AppartementDAO appDao = new AppartementDAO();

		frame = new JFrame() ;
		frame.setTitle("Déposer un bien immobilier");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(BailAgent.class.getResource("/model/IDAELicone.jpg")));
		frame.getContentPane().setBackground(new Color(245, 222, 179));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1290, 630);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null); // Centre le JFrame sur l'écran
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 11, 1274, 114);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("IDAEL");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 89, 44);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(bailleur.getBllr_nom());
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(1165, 66, 89, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel(bailleur.getBllr_prenom());
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(1165, 79, 89, 14);
		panel.add(lblNewLabel_1_1);

		JLabel lblEspaceBailleur = new JLabel("ESPACE BAILLEUR");
		lblEspaceBailleur.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspaceBailleur.setForeground(new Color(138, 43, 226));
		lblEspaceBailleur.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblEspaceBailleur.setBounds(390, 22, 438, 62);
		panel.add(lblEspaceBailleur);

		JLabel lblNewLabel_1_1_1 = new JLabel(bailleur.getBllr_id());
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(1165, 94, 89, 14);
		panel.add(lblNewLabel_1_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 222, 179));
		panel_1.setBounds(0, 125, 1264, 455);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton_1_1 = new JButton("RETOUR");
		btnNewButton_1_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EspaceBailleur window = new EspaceBailleur(bailleur);
					window.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_1_1.setBounds(1133, 406, 121, 38);
		panel_1.add(btnNewButton_1_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(244, 164, 96));
		panel_2.setBounds(10, 11, 1254, 388);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblInfosBails = new JLabel("INFOS BIEN IMMOBILIER");
		lblInfosBails.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfosBails.setForeground(Color.DARK_GRAY);
		lblInfosBails.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblInfosBails.setBounds(10, 0, 189, 34);
		panel_2.add(lblInfosBails);

		JLabel lblInfosBails_2 = new JLabel("BIEN");
		lblInfosBails_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2.setForeground(Color.BLACK);
		lblInfosBails_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2.setBounds(20, 45, 86, 34);
		panel_2.add(lblInfosBails_2);

		JLabel lblInfosBails_2_2 = new JLabel("TYPE");
		lblInfosBails_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_2.setForeground(Color.BLACK);
		lblInfosBails_2_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_2.setBounds(443, 46, 71, 34);
		panel_2.add(lblInfosBails_2_2);

		JLabel lblInfosBails_2_3 = new JLabel("NOMBRE DE PIECES");
		lblInfosBails_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_3.setForeground(Color.BLACK);
		lblInfosBails_2_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_3.setBounds(20, 106, 135, 34);
		panel_2.add(lblInfosBails_2_3);

		JLabel lblInfosBails_2_4 = new JLabel("MEUBLE");
		lblInfosBails_2_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_4.setForeground(Color.BLACK);
		lblInfosBails_2_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_4.setBounds(440, 106, 71, 34);
		panel_2.add(lblInfosBails_2_4);

		JLabel lblInfosBails_2_5 = new JLabel("CAVE");
		lblInfosBails_2_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_5.setForeground(Color.BLACK);
		lblInfosBails_2_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_5.setBounds(20, 218, 162, 34);
		panel_2.add(lblInfosBails_2_5);

		JLabel lblInfosBails_2_6 = new JLabel("TERRASSE");
		lblInfosBails_2_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_6.setForeground(Color.BLACK);
		lblInfosBails_2_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_6.setBounds(440, 219, 120, 34);
		panel_2.add(lblInfosBails_2_6);

		JLabel lblInfosBails_2_9 = new JLabel("ADRESSE BIEN");
		lblInfosBails_2_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_9.setForeground(Color.BLACK);
		lblInfosBails_2_9.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_9.setBounds(813, 45, 101, 34);
		panel_2.add(lblInfosBails_2_9);

		JLabel lblInfosBails_2_10 = new JLabel("TYPE DE CHAUFFAGE");
		lblInfosBails_2_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_10.setForeground(Color.BLACK);
		lblInfosBails_2_10.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_10.setBounds(813, 106, 135, 34);
		panel_2.add(lblInfosBails_2_10);

		JLabel lblInfosBails_2_11 = new JLabel("JARDIN");
		lblInfosBails_2_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_11.setForeground(Color.BLACK);
		lblInfosBails_2_11.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_11.setBounds(813, 219, 162, 34);
		panel_2.add(lblInfosBails_2_11);

		JLabel lblInfosBails_2_11_1 = new JLabel("LOYER");
		lblInfosBails_2_11_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_11_1.setForeground(Color.BLACK);
		lblInfosBails_2_11_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_11_1.setBounds(20, 286, 71, 34);
		panel_2.add(lblInfosBails_2_11_1);

		JLabel lblInfosBails_2_11_2 = new JLabel("CHARGES");
		lblInfosBails_2_11_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_11_2.setForeground(Color.BLACK);
		lblInfosBails_2_11_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_11_2.setBounds(443, 286, 71, 34);
		panel_2.add(lblInfosBails_2_11_2);

		JLabel lblInfosBails_2_11_4 = new JLabel("CAUTION");
		lblInfosBails_2_11_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_11_4.setForeground(Color.BLACK);
		lblInfosBails_2_11_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_11_4.setBounds(20, 314, 71, 34);
		panel_2.add(lblInfosBails_2_11_4);

		JLabel lblInfosBails_2_4_1 = new JLabel("ANNEE CONSTRUCTION");
		lblInfosBails_2_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_4_1.setForeground(Color.BLACK);
		lblInfosBails_2_4_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_4_1.setBounds(20, 135, 162, 34);
		panel_2.add(lblInfosBails_2_4_1);

		textField = new JTextField();
		textField.setBounds(973, 52, 194, 20);
		panel_2.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(187, 321, 194, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(187, 142, 194, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(187, 293, 194, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(561, 293, 173, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(561, 51, 173, 22);
		comboBox_1.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Loft", "Duplex", "Chambre", "Studio", "Penthouse", "T1", "T3" }));

		panel_2.add(comboBox_1);

		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(187, 112, 194, 22);
		comboBox_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
		panel_2.add(comboBox_2);

		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setBounds(561, 112, 173, 22);
		comboBox_3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oui", "Non" }));
		panel_2.add(comboBox_3);

		JComboBox<String> comboBox_4 = new JComboBox<String>();
		comboBox_4.setBounds(973, 112, 194, 22);
		comboBox_4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gaz", "Electrique" }));
		panel_2.add(comboBox_4);

		JComboBox<String> comboBox_5 = new JComboBox<String>();
		comboBox_5.setBounds(187, 224, 194, 22);
		comboBox_5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oui", "Non" }));
		panel_2.add(comboBox_5);

		JComboBox<String> comboBox_6 = new JComboBox<String>();
		comboBox_6.setBounds(561, 224, 173, 22);
		comboBox_6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oui", "Non" }));
		panel_2.add(comboBox_6);

		JComboBox<String> comboBox_7 = new JComboBox<String>();
		comboBox_7.setBounds(973, 224, 194, 22);
		comboBox_7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oui", "Non" }));
		panel_2.add(comboBox_7);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox.getSelectedItem().toString().equals("Appartement")) {
					lblInfosBails_2_5.setText("NUMERO APPARTEMENT");
					lblInfosBails_2_6.setText("NUMERO ETAGE");
					lblInfosBails_2_11.setText("BALCON OU TERRASSE");
					comboBox_5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"0", "1", "2", "3", "4",
							"5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
							"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35",
							"36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
							"51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65",
							"66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80",
							"81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95",
							"96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108",
							"109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121",
							"122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134",
							"135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147",
							"148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160",
							"161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173",
							"174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186",
							"187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198",
							"199", "200" }));
					comboBox_6.setModel(new javax.swing.DefaultComboBoxModel<>(
							new String[] {"0", "1", "2", "3", "4",
									"5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
									"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35",
									"36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
									"51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65",
									"66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80",
									"81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95",
									"96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108",
									"109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121",
									"122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134",
									"135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147",
									"148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160",
									"161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173",
									"174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186",
									"187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198",
									"199", "200"}));
					comboBox_1.setEnabled(true);
				} else {
					lblInfosBails_2_5.setText("CAVE");
					lblInfosBails_2_6.setText("TERASSE");
					lblInfosBails_2_11.setText("JARDIN");
					comboBox_5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oui", "Non" }));
					comboBox_6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oui", "Non" }));
					comboBox_1.setEnabled(false);
				}
			}
		});
		comboBox.setBounds(187, 51, 194, 22);
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maison", "Appartement" }));
		panel_2.add(comboBox);

		
		JButton btnNewButton = new JButton("SOUMETTRE");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("") || textField_1.getText().equals("")
						|| textField_2.getText().equals("") || textField_3.getText().equals("")
						|| textField_4.getText().equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs sont obligatoires",
							"Erreur de soumission", JOptionPane.ERROR_MESSAGE);
				} else {
					if (comboBox.getSelectedItem().toString().equals("Maison")) {
						Maison msn = new Maison(textField.getText(),
								Integer.parseInt(comboBox_2.getSelectedItem().toString()),
								comboBox_3.getSelectedItem().toString(), Integer.parseInt(textField_2.getText()),
								comboBox_4.getSelectedItem().toString(), Double.parseDouble(textField_3.getText()),
								Double.parseDouble(textField_4.getText()), Double.parseDouble(textField_1.getText()),
								BailleurDAO.get(bailleur.getBllr_id()).getBllr_id_bailleur(),
								comboBox_5.getSelectedItem().toString(), comboBox_6.getSelectedItem().toString(),
								comboBox_7.getSelectedItem().toString());
						msnDao.add(msn);
						JOptionPane.showMessageDialog(new JFrame(), "Bien soumis avec succès", "Message",
								JOptionPane.DEFAULT_OPTION);
					} else if (comboBox.getSelectedItem().toString().equals("Appartement")) {
						Appartement app = new Appartement(textField.getText(),
								Integer.parseInt(comboBox_2.getSelectedItem().toString()),
								comboBox_3.getSelectedItem().toString(), Integer.parseInt(textField_2.getText()),
								comboBox_4.getSelectedItem().toString(), Double.parseDouble(textField_3.getText()),
								Double.parseDouble(textField_4.getText()), Double.parseDouble(textField_1.getText()),
								BailleurDAO.get(bailleur.getBllr_id()).getBllr_id_bailleur(),
								comboBox_5.getSelectedItem().toString(),
								Integer.parseInt(comboBox_5.getSelectedItem().toString()),
								Integer.parseInt(comboBox_6.getSelectedItem().toString()),
								comboBox_1.getSelectedItem().toString());
						appDao.add(app);
						JOptionPane.showMessageDialog(new JFrame(), "Bien soumis avec succès", "Message",
								JOptionPane.DEFAULT_OPTION);
					}
					textField.setText("") ; 
					textField_1.setText("");
					textField_2.setText("") ; 
					textField_3.setText("");
					textField_4.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(1110, 338, 113, 39);
		panel_2.add(btnNewButton);
		
		
		//****** Définir le bouton par défaut ******
        frame.getRootPane().setDefaultButton(btnNewButton);
        
        btnNewButton.setMnemonic(KeyEvent.VK_ENTER);
        
        JButton btnNewButton_1 = new JButton("...");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
					Adresse window = new Adresse();
					window.frame.setVisible(true);
					textField.setText(Adresse.adresse);// 	A boser fooorrrtttttttttttttttttttt
        	}
        });
        textField.setText(Adresse.adresse);
        btnNewButton_1.setBounds(1179, 51, 44, 23);
        panel_2.add(btnNewButton_1);

	}
}
