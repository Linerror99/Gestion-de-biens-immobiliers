package gui;

import java.awt.EventQueue;

import dao.MaisonDAO;
import dao.AppartementDAO;
import model.Maison;
import model.Appartement;
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

public class ValidationDepotBien {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Agent agent = new Agent("p", "p", "p");
				try {
					ValidationDepotBien window = new ValidationDepotBien(agent);
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
	public ValidationDepotBien(Agent agent) {
		initialize(agent);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Agent agent) {

		MaisonDAO msnDao = new MaisonDAO();
		AppartementDAO appDao = new AppartementDAO();
		frame = new JFrame();
		frame.setTitle("Validation des demandes de dépôt de bien");
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
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_1_1.setBounds(1133, 406, 121, 38);
		panel_1.add(btnNewButton_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 44, 332, 379);
		panel_1.add(scrollPane);

		JTable table = new JTable();
		table.setToolTipText("");

		table.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID BIEN", "STATUT" }));
		table.setRowMargin(1);
		table.setShowHorizontalLines(true);

		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(244, 164, 96));
		panel_2.setBounds(430, 32, 824, 368);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblInfosBails = new JLabel("INFOS BIEN");
		lblInfosBails.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfosBails.setForeground(new Color(0, 0, 0));
		lblInfosBails.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblInfosBails.setBounds(10, 0, 120, 34);
		panel_2.add(lblInfosBails);

		JLabel lblInfosBails_2 = new JLabel("BIEN");
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

		JLabel lblInfosBails_2_2 = new JLabel("TYPE");
		lblInfosBails_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_2.setForeground(Color.BLACK);
		lblInfosBails_2_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_2.setBounds(288, 78, 52, 34);
		panel_2.add(lblInfosBails_2_2);

		JLabel lblInfosBails_2_1_1 = new JLabel(".....");
		lblInfosBails_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_1.setForeground(Color.BLACK);
		lblInfosBails_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_1.setBounds(393, 77, 106, 34);
		panel_2.add(lblInfosBails_2_1_1);

		JLabel lblInfosBails_2_3 = new JLabel("NOMBRE DE PIECES");
		lblInfosBails_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_3.setForeground(Color.BLACK);
		lblInfosBails_2_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_3.setBounds(21, 144, 144, 34);
		panel_2.add(lblInfosBails_2_3);

		JLabel lblInfosBails_2_1_2 = new JLabel(".....");
		lblInfosBails_2_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_2.setForeground(Color.BLACK);
		lblInfosBails_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_2.setBounds(206, 143, 52, 34);
		panel_2.add(lblInfosBails_2_1_2);

		JLabel lblInfosBails_2_4 = new JLabel("ANNEE DE CONSTRUCTION");
		lblInfosBails_2_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_4.setForeground(Color.BLACK);
		lblInfosBails_2_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_4.setBounds(21, 173, 165, 34);
		panel_2.add(lblInfosBails_2_4);

		JLabel lblInfosBails_2_1_3 = new JLabel(".....");
		lblInfosBails_2_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_3.setForeground(Color.BLACK);
		lblInfosBails_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_3.setBounds(206, 172, 57, 34);
		panel_2.add(lblInfosBails_2_1_3);

		JLabel lblInfosBails_2_9 = new JLabel("MEUBLE");
		lblInfosBails_2_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_9.setForeground(Color.BLACK);
		lblInfosBails_2_9.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_9.setBounds(288, 144, 71, 34);
		panel_2.add(lblInfosBails_2_9);

		JLabel lblInfosBails_2_1_8 = new JLabel(".....");
		lblInfosBails_2_1_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_8.setForeground(Color.BLACK);
		lblInfosBails_2_1_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_8.setBounds(391, 143, 57, 34);
		panel_2.add(lblInfosBails_2_1_8);

		JLabel lblInfosBails_2_10 = new JLabel("JARDIN");
		lblInfosBails_2_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_10.setForeground(Color.BLACK);
		lblInfosBails_2_10.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_10.setBounds(546, 218, 165, 34);
		panel_2.add(lblInfosBails_2_10);

		JLabel lblInfosBails_2_1_9 = new JLabel(".....");
		lblInfosBails_2_1_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_9.setForeground(Color.BLACK);
		lblInfosBails_2_1_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_9.setBounds(721, 217, 52, 34);
		panel_2.add(lblInfosBails_2_1_9);

		JLabel lblInfosBails_2_1_10_1 = new JLabel(".....");
		lblInfosBails_2_1_10_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_10_1.setForeground(Color.BLACK);
		lblInfosBails_2_1_10_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_10_1.setBounds(131, 286, 105, 34);
		panel_2.add(lblInfosBails_2_1_10_1);

		JLabel lblInfosBails_2_11_1 = new JLabel("LOYER");
		lblInfosBails_2_11_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_11_1.setForeground(Color.BLACK);
		lblInfosBails_2_11_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_11_1.setBounds(20, 286, 71, 34);
		panel_2.add(lblInfosBails_2_11_1);

		JLabel lblInfosBails_2_1_10_2 = new JLabel(".....");
		lblInfosBails_2_1_10_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_10_2.setForeground(Color.BLACK);
		lblInfosBails_2_1_10_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_10_2.setBounds(392, 286, 105, 34);
		panel_2.add(lblInfosBails_2_1_10_2);

		JLabel lblInfosBails_2_11_2 = new JLabel("CHARGES");
		lblInfosBails_2_11_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_11_2.setForeground(Color.BLACK);
		lblInfosBails_2_11_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_11_2.setBounds(287, 286, 71, 34);
		panel_2.add(lblInfosBails_2_11_2);

		JLabel lblInfosBails_2_1_10_4 = new JLabel(".....");
		lblInfosBails_2_1_10_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_10_4.setForeground(Color.BLACK);
		lblInfosBails_2_1_10_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_10_4.setBounds(131, 307, 105, 34);
		panel_2.add(lblInfosBails_2_1_10_4);

		JLabel lblInfosBails_2_11_4 = new JLabel("CAUTION");
		lblInfosBails_2_11_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_11_4.setForeground(Color.BLACK);
		lblInfosBails_2_11_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_11_4.setBounds(20, 307, 71, 34);
		panel_2.add(lblInfosBails_2_11_4);

		JLabel lblInfosBails_2_4_1 = new JLabel("CAVE");
		lblInfosBails_2_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_4_1.setForeground(Color.BLACK);
		lblInfosBails_2_4_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_4_1.setBounds(20, 217, 57, 34);
		panel_2.add(lblInfosBails_2_4_1);

		JLabel lblInfosBails_2_1_3_1 = new JLabel(".....");
		lblInfosBails_2_1_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_3_1.setForeground(Color.BLACK);
		lblInfosBails_2_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_3_1.setBounds(102, 216, 52, 34);
		panel_2.add(lblInfosBails_2_1_3_1);

		JLabel lblInfosBails_2_10_1 = new JLabel("TERRASSE");
		lblInfosBails_2_10_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_10_1.setForeground(Color.BLACK);
		lblInfosBails_2_10_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_10_1.setBounds(237, 217, 199, 34);
		panel_2.add(lblInfosBails_2_10_1);

		JLabel lblInfosBails_2_1_9_1 = new JLabel(".....");
		lblInfosBails_2_1_9_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_9_1.setForeground(Color.BLACK);
		lblInfosBails_2_1_9_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_9_1.setBounds(446, 216, 52, 34);
		panel_2.add(lblInfosBails_2_1_9_1);

		JLabel lblInfosBails_2_5 = new JLabel("ADRESSE BIEN");
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

		JLabel lblInfosBails_2_6 = new JLabel("TYPE DE CHAUFFAGE");
		lblInfosBails_2_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_6.setForeground(Color.BLACK);
		lblInfosBails_2_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_6.setBounds(547, 144, 127, 34);
		panel_2.add(lblInfosBails_2_6);

		JLabel lblInfosBails_2_1_5 = new JLabel(".....");
		lblInfosBails_2_1_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_5.setForeground(Color.BLACK);
		lblInfosBails_2_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_5.setBounds(703, 143, 99, 34);
		panel_2.add(lblInfosBails_2_1_5);

		JLabel lblInfosBails_2_7 = new JLabel("ID");
		lblInfosBails_2_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_7.setForeground(Color.BLACK);
		lblInfosBails_2_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_7.setBounds(20, 33, 41, 34);
		panel_2.add(lblInfosBails_2_7);

		JLabel lblInfosBails_2_1_6 = new JLabel("ID BIEN");
		lblInfosBails_2_1_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_6.setForeground(Color.BLACK);
		lblInfosBails_2_1_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_6.setBounds(91, 32, 123, 34);
		panel_2.add(lblInfosBails_2_1_6);

		JButton btnNewButton_1 = new JButton("EN ATTENTE");
		btnNewButton_1.setForeground(Color.ORANGE);
		btnNewButton_1.setBounds(711, 414, 100, 30);
		panel_1.add(btnNewButton_1);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(154, 11, 144, 22);
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maison", "Appartement" }));
		panel_1.add(comboBox);

		JLabel lblNewLabel_2 = new JLabel("TRI:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(77, 15, 100, 18);
		panel_1.add(lblNewLabel_2);

		JButton btnNewButton_3 = new JButton("OK");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().toString().equals("Maison")) {
					ArrayList<Maison> msnList = new ArrayList<Maison>();
					msnList = MaisonDAO.getList();
					String colonne[] = { "ID BIEN", "Statut" };
					DefaultTableModel model = new DefaultTableModel(null, colonne);
					for (int i = 0; i < msnList.size(); i++) {
						Object o[] = { msnList.get(i).getMsn_id_maison(), msnList.get(i).getBn_statut() };
						model.addRow(o);
					}
					table.setModel(model);
				} else if (comboBox.getSelectedItem().toString().equals("Appartement")) {
					ArrayList<Appartement> appList = new ArrayList<Appartement>();
					appList = AppartementDAO.getList();
					String colonne[] = { "ID BIEN", "Statut" };
					DefaultTableModel model = new DefaultTableModel(null, colonne);
					for (int i = 0; i < appList.size(); i++) {
						Object o[] = { appList.get(i).getApp_id_appartement(), appList.get(i).getBn_statut() };
						model.addRow(o);
					}
					table.setModel(model);
				}
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectionner = table.getSelectedRow();
				if (comboBox.getSelectedItem().toString().equals("Maison")) {
					ArrayList<Maison> msnList = new ArrayList<Maison>();
					msnList = MaisonDAO.getList();
					lblInfosBails_2_1_6.setText(msnList.get(selectionner).getMsn_id_maison());
					lblInfosBails_2_1.setText("Maison");
					lblInfosBails_2_1_1.setText("Pas de type");
					lblInfosBails_2_1_2.setText(Integer.toString(msnList.get(selectionner).getBn_nombredepiece()));
					lblInfosBails_2_1_4.setText(msnList.get(selectionner).getBn_adresse());
					lblInfosBails_2_1_8.setText(msnList.get(selectionner).getBn_meuble());
					lblInfosBails_2_1_5.setText(msnList.get(selectionner).getBn_typedechauffage());
					lblInfosBails_2_1_3
							.setText(Integer.toString(msnList.get(selectionner).getBn_anneedeconstruction()));
					lblInfosBails_2_4_1.setText("CAVE");
					lblInfosBails_2_1_3_1.setText(msnList.get(selectionner).getMsn_cave());
					lblInfosBails_2_10_1.setText("TERRASSE");
					lblInfosBails_2_1_9_1.setText(msnList.get(selectionner).getMsn_terasse());
					lblInfosBails_2_10.setText("JARDIN");
					lblInfosBails_2_1_9.setText(msnList.get(selectionner).getMsn_jardin());
					lblInfosBails_2_1_10_1.setText(Double.toString(msnList.get(selectionner).getBn_loyer()));
					lblInfosBails_2_1_10_2.setText(Double.toString(msnList.get(selectionner).getBn_charges()));
					lblInfosBails_2_1_10_4.setText(Double.toString(msnList.get(selectionner).getBn_caution()));
					

				} else if (comboBox.getSelectedItem().toString().equals("Appartement")) {
					ArrayList<Appartement> appList = new ArrayList<Appartement>();
					appList = AppartementDAO.getList();
					lblInfosBails_2_1_6.setText(appList.get(selectionner).getApp_id_appartement());
					lblInfosBails_2_1.setText("Appartement");
					lblInfosBails_2_1_1.setText(appList.get(selectionner).getApp_type());
					lblInfosBails_2_1_2.setText(Integer.toString(appList.get(selectionner).getBn_nombredepiece()));
					lblInfosBails_2_1_4.setText(appList.get(selectionner).getBn_adresse());
					lblInfosBails_2_1_8.setText(appList.get(selectionner).getBn_meuble());
					lblInfosBails_2_1_5.setText(appList.get(selectionner).getBn_typedechauffage());
					lblInfosBails_2_1_3
							.setText(Integer.toString(appList.get(selectionner).getBn_anneedeconstruction()));
					lblInfosBails_2_4_1.setText("ETAGE");
					lblInfosBails_2_1_3_1.setText(Integer.toString(appList.get(selectionner).getApp_etage()));
					lblInfosBails_2_10_1.setText("NUMERO D'APPARTEMENT");
					lblInfosBails_2_1_9_1
							.setText(Integer.toString(appList.get(selectionner).getApp_numerodappartement()));
					lblInfosBails_2_10.setText("BALCON OU TERRASSE");
					lblInfosBails_2_1_9.setText(appList.get(selectionner).getApp_balconouterrasse());
					lblInfosBails_2_1_10_1.setText(Double.toString(appList.get(selectionner).getBn_loyer()));
					lblInfosBails_2_1_10_2.setText(Double.toString(appList.get(selectionner).getBn_charges()));
					lblInfosBails_2_1_10_4.setText(Double.toString(appList.get(selectionner).getBn_caution()));

				}

			}
		});

		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.setBounds(307, 10, 52, 23);
		panel_1.add(btnNewButton_3);

		JButton btnNewButton = new JButton("VALIDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().toString().equals("Maison")) {
					msnDao.updateStatutValide(lblInfosBails_2_1_6.getText());

				} else if (comboBox.getSelectedItem().toString().equals("Appartement")) {
					appDao.updateStatutValide(lblInfosBails_2_1_6.getText());
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
					msnDao.updateStatutRejet(lblInfosBails_2_1_6.getText());

				} else if (comboBox.getSelectedItem().toString().equals("Appartement")) {
					appDao.updateStatutRejet(lblInfosBails_2_1_6.getText());
				}
			}
		});
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBounds(892, 414, 100, 30);
		panel_1.add(btnNewButton_2);

	}
}
