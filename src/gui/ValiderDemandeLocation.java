package gui;

import java.awt.EventQueue;



import dao.MaisonDAO;
import dao.AppartementDAO;
import dao.LocataireDAO;
import dao.LoueDAO;
import model.Loue;
import model.Locataire;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import model.Agent;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ValiderDemandeLocation {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Agent agent = new Agent("IdTest", "NomTest", "prenomTest");
				try {
					ValiderDemandeLocation window = new ValiderDemandeLocation(agent);
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
	public ValiderDemandeLocation(Agent agent) {
		initialize(agent);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Agent agent) {

		MaisonDAO msnDao = new MaisonDAO();
		AppartementDAO appDao = new AppartementDAO();
		frame = new JFrame();
		frame.setTitle("Validation des demandes de location de bien imobilier");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(BailAgent.class.getResource("/model/IDAELicone.jpg")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1290, 630);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null); // Centre le JFrame sur l'écran
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 0, 1264, 125);
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

		JLabel lblEspaceBailleur = new JLabel("ESPACE AGENT");
		lblEspaceBailleur.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspaceBailleur.setForeground(new Color(138, 43, 226));
		lblEspaceBailleur.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblEspaceBailleur.setBounds(390, 22, 438, 62);
		panel.add(lblEspaceBailleur);

		JLabel lblNewLabel_1_1_1 = new JLabel(agent.getAgt_id());
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
					EspaceAgent window = new EspaceAgent(agent);
					window.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(1133, 406, 121, 38);
		panel_1.add(btnNewButton_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(245, 222, 179));
		scrollPane.setBounds(45, 44, 332, 379);
		panel_1.add(scrollPane);

		JTable table = new JTable();
		table.setToolTipText("");

		table.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
		table.setModel(new DefaultTableModel(new Object[][][] {},
				new String[] { "ID BIEN", "ID LOCATAIRE", "STATUT DEMANDE" }));
		table.setRowMargin(1);
		table.setShowHorizontalLines(true);

		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(244, 164, 96));
		panel_2.setBounds(430, 32, 824, 363);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblInfosBails = new JLabel("INFOS LOCATAIRE");
		lblInfosBails.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfosBails.setForeground(Color.DARK_GRAY);
		lblInfosBails.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblInfosBails.setBounds(10, 0, 155, 34);
		panel_2.add(lblInfosBails);

		JLabel lblInfosBails_2 = new JLabel("NOM");
		lblInfosBails_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2.setForeground(Color.BLACK);
		lblInfosBails_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2.setBounds(21, 78, 41, 34);
		panel_2.add(lblInfosBails_2);

		JLabel lblInfosBails_2_1 = new JLabel(".....");
		lblInfosBails_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1.setForeground(Color.BLACK);
		lblInfosBails_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1.setBounds(92, 77, 99, 34);
		panel_2.add(lblInfosBails_2_1);

		JLabel lblInfosBails_2_2 = new JLabel("PRENOM");
		lblInfosBails_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_2.setForeground(Color.BLACK);
		lblInfosBails_2_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_2.setBounds(288, 78, 71, 34);
		panel_2.add(lblInfosBails_2_2);

		JLabel lblInfosBails_2_1_1 = new JLabel(".....");
		lblInfosBails_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_1.setForeground(Color.BLACK);
		lblInfosBails_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_1.setBounds(393, 77, 106, 34);
		panel_2.add(lblInfosBails_2_1_1);

		JLabel lblInfosBails_2_5 = new JLabel("ADRESSE ");
		lblInfosBails_2_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_5.setForeground(Color.BLACK);
		lblInfosBails_2_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_5.setBounds(554, 78, 89, 34);
		panel_2.add(lblInfosBails_2_5);

		JLabel lblInfosBails_2_1_4 = new JLabel(".....");
		lblInfosBails_2_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_4.setForeground(Color.BLACK);
		lblInfosBails_2_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_4.setBounds(703, 77, 112, 34);
		panel_2.add(lblInfosBails_2_1_4);

		JLabel lblInfosBails_2_7 = new JLabel("ID BIEN");
		lblInfosBails_2_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_7.setForeground(Color.BLACK);
		lblInfosBails_2_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_7.setBounds(20, 33, 61, 34);
		panel_2.add(lblInfosBails_2_7);

		JLabel lblInfosBails_2_1_6 = new JLabel(".....");
		lblInfosBails_2_1_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_6.setForeground(Color.BLACK);
		lblInfosBails_2_1_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_6.setBounds(91, 32, 123, 34);
		panel_2.add(lblInfosBails_2_1_6);

		JLabel lblInfosBails_2_3 = new JLabel("EMAIL");
		lblInfosBails_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_3.setForeground(Color.BLACK);
		lblInfosBails_2_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_3.setBounds(21, 145, 61, 34);
		panel_2.add(lblInfosBails_2_3);

		JLabel lblInfosBails_2_1_2 = new JLabel(".....");
		lblInfosBails_2_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_2.setForeground(Color.BLACK);
		lblInfosBails_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_2.setBounds(92, 144, 99, 34);
		panel_2.add(lblInfosBails_2_1_2);

		JLabel lblInfosBails_2_4 = new JLabel("RIB");
		lblInfosBails_2_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_4.setForeground(Color.BLACK);
		lblInfosBails_2_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_4.setBounds(288, 145, 41, 34);
		panel_2.add(lblInfosBails_2_4);

		JLabel lblInfosBails_2_1_3 = new JLabel(".....");
		lblInfosBails_2_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_3.setForeground(Color.BLACK);
		lblInfosBails_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_3.setBounds(359, 144, 140, 34);
		panel_2.add(lblInfosBails_2_1_3);

		JLabel lblInfosBails_2_6 = new JLabel("AGE");
		lblInfosBails_2_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_6.setForeground(Color.BLACK);
		lblInfosBails_2_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_6.setBounds(554, 145, 41, 34);
		panel_2.add(lblInfosBails_2_6);

		JLabel lblInfosBails_2_1_5 = new JLabel(".....");
		lblInfosBails_2_1_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_5.setForeground(Color.BLACK);
		lblInfosBails_2_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_5.setBounds(625, 144, 99, 34);
		panel_2.add(lblInfosBails_2_1_5);
		
		JLabel lblInfosBails_2_7_1 = new JLabel("ID LOCATAIRE");
		lblInfosBails_2_7_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_7_1.setForeground(Color.BLACK);
		lblInfosBails_2_7_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_7_1.setBounds(282, 34, 99, 34);
		panel_2.add(lblInfosBails_2_7_1);
		
		JLabel lblInfosBails_2_1_6_1 = new JLabel(".....");
		lblInfosBails_2_1_6_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_6_1.setForeground(Color.BLACK);
		lblInfosBails_2_1_6_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_6_1.setBounds(391, 32, 123, 34);
		panel_2.add(lblInfosBails_2_1_6_1);

		

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(115, 11, 144, 22);
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maison", "Appartement" }));
		panel_1.add(comboBox);

		JLabel lblNewLabel_2 = new JLabel("TRI:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(77, 15, 100, 18);
		panel_1.add(lblNewLabel_2);

		JButton btnNewButton_3 = new JButton("ACTUALISER");
		btnNewButton_3.addActionListener(new ActionListener() {
			//Remet à jour les sonnées à afficher
			public void actionPerformed(ActionEvent e) {
				ArrayList<Loue> msnList = new ArrayList<Loue>();
				msnList = LoueDAO.getList();
				String colonne[] = { "ID BIEN", "ID LOCATAIRE", "STATUT DEMANDE" };
				DefaultTableModel model = new DefaultTableModel(null, colonne);
				for (int i = 0; i < msnList.size(); i++) {
					Object o[] = { msnList.get(i).getLoue_bn_id(), msnList.get(i).getLoue_lct_id(), msnList.get(i).getStatut_demande() };
					model.addRow(o);
				}
				table.setModel(model);
			}
		});

		table.addMouseListener(new MouseAdapter() { 
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectionner = table.getSelectedRow();
				Object valeurCellule = table.getValueAt(selectionner, 1);
				Locataire lct = LocataireDAO.gets(valeurCellule.toString()); 
				Object valeurCellule0 = table.getValueAt(selectionner, 0);
				Object valeurCellule1 = table.getValueAt(selectionner, 1);  
				lblInfosBails_2_1_6.setText(valeurCellule0.toString());
				lblInfosBails_2_1_6_1.setText(valeurCellule1.toString());
				lblInfosBails_2_1.setText(lct.getLct_nom());
				lblInfosBails_2_1_1.setText(lct.getLct_prenom());
				lblInfosBails_2_1_2.setText(lct.getLct_adresseMail());
				lblInfosBails_2_1_4.setText(lct.getLct_address());
				lblInfosBails_2_1_5.setText(Integer.toString(lct.getLct_age()));
				lblInfosBails_2_1_3.setText(lct.getLct_Rib());
				

			}
		});

		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.setBounds(268, 10, 113, 23);
		panel_1.add(btnNewButton_3);

		JButton btnNewButton = new JButton("VALIDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().toString().equals("Maison")) {
					msnDao.updateDemandeAccepte(lblInfosBails_2_1_6_1.getText(), lblInfosBails_2_1_6.getText());

				} else if (comboBox.getSelectedItem().toString().equals("Appartement")) {
					appDao.updateDemandeAccepte(lblInfosBails_2_1_6_1.getText(), lblInfosBails_2_1_6.getText());
				}
			}
		});
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBounds(520, 414, 100, 30);
		panel_1.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("REJETER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().toString().equals("Maison")) {
					msnDao.updateDemandeRejet(lblInfosBails_2_1_6_1.getText(), lblInfosBails_2_1_6.getText());

				} else if (comboBox.getSelectedItem().toString().equals("Appartement")) {
					appDao.updateDemandeRejet(lblInfosBails_2_1_6_1.getText(), lblInfosBails_2_1_6.getText());
				}
			}
		});
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBounds(892, 414, 100, 30);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("EN ATTENTE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().toString().equals("Maison")) {
					msnDao.updateDemandeAttente(lblInfosBails_2_1_6_1.getText(), lblInfosBails_2_1_6.getText());

				} else if (comboBox.getSelectedItem().toString().equals("Appartement")) {
					appDao.updateDemandeAttente(lblInfosBails_2_1_6_1.getText(), lblInfosBails_2_1_6.getText());
				}
			}
		});
		btnNewButton_1.setForeground(Color.ORANGE);
		btnNewButton_1.setBounds(711, 414, 113, 30);
		panel_1.add(btnNewButton_1);

	}
}
