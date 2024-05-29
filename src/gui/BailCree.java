package gui;

import java.awt.EventQueue;

import dao.MaisonDAO;
import dao.AppartementDAO;
import dao.BailleurDAO;
import dao.LocataireDAO;
import dao.LoueDAO;
import dao.BailDAO;
import model.Maison;
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
import model.Appartement;
import model.Bailleur;
import model.Bail;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class BailCree {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Agent agent = new Agent("p", "p", "p");
				try {
					BailCree window = new BailCree(agent);
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
	public BailCree(Agent agent) {
		initialize(agent);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Agent agent) {

		MaisonDAO msnDao = new MaisonDAO();
		AppartementDAO appDao = new AppartementDAO();
		frame = new JFrame();

		frame.setTitle("Créer un Bail");
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
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_1_1.setBounds(1133, 406, 121, 38);
		panel_1.add(btnNewButton_1_1);

		JScrollPane scrollPane = new JScrollPane();
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

		JLabel lblInfosBails = new JLabel("INFOS BAIL");
		lblInfosBails.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfosBails.setForeground(new Color(0, 0, 0));
		lblInfosBails.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblInfosBails.setBounds(10, 0, 155, 34);
		panel_2.add(lblInfosBails);

		JLabel lblInfosBails_2_7 = new JLabel("ID BIEN");
		lblInfosBails_2_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_7.setForeground(Color.BLACK);
		lblInfosBails_2_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_7.setBounds(31, 34, 61, 34);
		panel_2.add(lblInfosBails_2_7);

		JLabel lblInfosBails_2_1_6 = new JLabel(".....");
		lblInfosBails_2_1_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_6.setForeground(Color.BLACK);
		lblInfosBails_2_1_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_6.setBounds(102, 33, 123, 34);
		panel_2.add(lblInfosBails_2_1_6);

		JLabel lblInfosBails_2_7_1 = new JLabel("ID LOCATAIRE");
		lblInfosBails_2_7_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_7_1.setForeground(Color.BLACK);
		lblInfosBails_2_7_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_7_1.setBounds(293, 35, 99, 34);
		panel_2.add(lblInfosBails_2_7_1);

		JLabel lblInfosBails_2_1_6_1 = new JLabel(".....");
		lblInfosBails_2_1_6_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_6_1.setForeground(Color.BLACK);
		lblInfosBails_2_1_6_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_6_1.setBounds(402, 33, 123, 34);
		panel_2.add(lblInfosBails_2_1_6_1);

		JLabel lblInfosBails_2_3 = new JLabel("BAILLEUR");
		lblInfosBails_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_3.setForeground(Color.BLACK);
		lblInfosBails_2_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_3.setBounds(31, 123, 105, 34);
		panel_2.add(lblInfosBails_2_3);

		JLabel lblInfosBails_2_9 = new JLabel("ADRESSE BAILLEUR");
		lblInfosBails_2_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_9.setForeground(Color.BLACK);
		lblInfosBails_2_9.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_9.setBounds(409, 123, 135, 34);
		panel_2.add(lblInfosBails_2_9);

		JLabel lblInfosBails_2_10 = new JLabel("ADRESSE LOCATAIRE");
		lblInfosBails_2_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_10.setForeground(Color.BLACK);
		lblInfosBails_2_10.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_10.setBounds(409, 152, 135, 34);
		panel_2.add(lblInfosBails_2_10);

		JLabel lblInfosBails_2_4 = new JLabel("LOCATAIRE");
		lblInfosBails_2_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_4.setForeground(Color.BLACK);
		lblInfosBails_2_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_4.setBounds(31, 152, 120, 34);
		panel_2.add(lblInfosBails_2_4);

		JLabel lblInfosBails_2_4_1 = new JLabel("GARANT");
		lblInfosBails_2_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_4_1.setForeground(Color.BLACK);
		lblInfosBails_2_4_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_4_1.setBounds(31, 183, 120, 34);
		panel_2.add(lblInfosBails_2_4_1);

		JLabel lblInfosBails_2_5_1 = new JLabel("DATE DEBUT");
		lblInfosBails_2_5_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_5_1.setForeground(Color.BLACK);
		lblInfosBails_2_5_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_5_1.setBounds(31, 235, 86, 34);
		panel_2.add(lblInfosBails_2_5_1);

		JLabel lblInfosBails_2_6 = new JLabel("DUREE");
		lblInfosBails_2_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_6.setForeground(Color.BLACK);
		lblInfosBails_2_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_6.setBounds(672, 235, 61, 34);
		panel_2.add(lblInfosBails_2_6);

		JLabel lblInfosBails_2_11 = new JLabel("DATE FIN");
		lblInfosBails_2_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_11.setForeground(Color.BLACK);
		lblInfosBails_2_11.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_11.setBounds(372, 235, 71, 34);
		panel_2.add(lblInfosBails_2_11);

		JLabel lblInfosBails_2_12 = new JLabel("DATE ECHEANCE");
		lblInfosBails_2_12.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_12.setForeground(Color.BLACK);
		lblInfosBails_2_12.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_12.setBounds(31, 268, 120, 34);
		panel_2.add(lblInfosBails_2_12);

		JLabel lblInfosBails_2_11_3 = new JLabel("FRAIS D'AGENCE");
		lblInfosBails_2_11_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_11_3.setForeground(Color.BLACK);
		lblInfosBails_2_11_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_11_3.setBounds(523, 303, 105, 34);
		panel_2.add(lblInfosBails_2_11_3);

		JLabel lblInfosBails_2_11_2 = new JLabel("CHARGES");
		lblInfosBails_2_11_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_11_2.setForeground(Color.BLACK);
		lblInfosBails_2_11_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_11_2.setBounds(298, 303, 71, 34);
		panel_2.add(lblInfosBails_2_11_2);

		JLabel lblInfosBails_2_11_4 = new JLabel("CAUTION");
		lblInfosBails_2_11_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_11_4.setForeground(Color.BLACK);
		lblInfosBails_2_11_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_11_4.setBounds(31, 324, 71, 34);
		panel_2.add(lblInfosBails_2_11_4);

		JLabel lblInfosBails_2_11_1 = new JLabel("LOYER");
		lblInfosBails_2_11_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_11_1.setForeground(Color.BLACK);
		lblInfosBails_2_11_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_11_1.setBounds(31, 303, 71, 34);
		panel_2.add(lblInfosBails_2_11_1);

		JLabel lblInfosBails_2_1_2 = new JLabel(".....");
		lblInfosBails_2_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_2.setForeground(Color.BLACK);
		lblInfosBails_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_2.setBounds(185, 122, 99, 34);
		panel_2.add(lblInfosBails_2_1_2);

		JLabel lblInfosBails_2_1_3 = new JLabel(".....");
		lblInfosBails_2_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_3.setForeground(Color.BLACK);
		lblInfosBails_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_3.setBounds(185, 152, 99, 34);
		panel_2.add(lblInfosBails_2_1_3);

		JLabel lblInfosBails_2_1_7 = new JLabel(".....");
		lblInfosBails_2_1_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_7.setForeground(Color.BLACK);
		lblInfosBails_2_1_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_7.setBounds(185, 183, 99, 34);
		panel_2.add(lblInfosBails_2_1_7);

		JLabel lblInfosBails_2_1_8 = new JLabel(".....");
		lblInfosBails_2_1_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_8.setForeground(Color.BLACK);
		lblInfosBails_2_1_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_8.setBounds(564, 123, 99, 34);
		panel_2.add(lblInfosBails_2_1_8);

		JLabel lblInfosBails_2_1_9 = new JLabel(".....");
		lblInfosBails_2_1_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_9.setForeground(Color.BLACK);
		lblInfosBails_2_1_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_9.setBounds(564, 152, 99, 34);
		panel_2.add(lblInfosBails_2_1_9);

		JLabel lblInfosBails_2_1_13 = new JLabel(".....");
		lblInfosBails_2_1_13.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_13.setForeground(Color.BLACK);
		lblInfosBails_2_1_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_13.setBounds(148, 303, 99, 34);
		panel_2.add(lblInfosBails_2_1_13);

		JLabel lblInfosBails_2_1_14 = new JLabel(".....");
		lblInfosBails_2_1_14.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_14.setForeground(Color.BLACK);
		lblInfosBails_2_1_14.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_14.setBounds(148, 314, 99, 34);
		panel_2.add(lblInfosBails_2_1_14);

		JLabel lblInfosBails_2_1_15 = new JLabel(".....");
		lblInfosBails_2_1_15.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_15.setForeground(Color.BLACK);
		lblInfosBails_2_1_15.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_15.setBounds(672, 303, 99, 34);
		panel_2.add(lblInfosBails_2_1_15);

		JLabel lblInfosBails_2_1_16 = new JLabel(".....");
		lblInfosBails_2_1_16.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_16.setForeground(Color.BLACK);
		lblInfosBails_2_1_16.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_16.setBounds(428, 303, 89, 34);
		panel_2.add(lblInfosBails_2_1_16);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(148, 241, 50, 22);
		comboBox_1.setModel(new DefaultComboBoxModel<String>(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		panel_2.add(comboBox_1);

		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(201, 241, 50, 22);
		comboBox_2.setModel(new DefaultComboBoxModel<String>(new String[] { "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
				"25", "26", "27", "28", "29", "30", "31" }));
		panel_2.add(comboBox_2);

		JComboBox<Object> comboBox_3 = new JComboBox<Object>();
		comboBox_3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1990", "1991", "1992", "1993",
				"1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006",
				"2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019",
				"2020", "2021", "2022", "2023", "2024" }));
		comboBox_3.setBounds(258, 241, 79, 22);
		panel_2.add(comboBox_3);

		JLabel lblInfosBails_2_1_15_1 = new JLabel(".....");
		lblInfosBails_2_1_15_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_15_1.setForeground(Color.BLACK);
		lblInfosBails_2_1_15_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_15_1.setBounds(746, 234, 68, 34);
		panel_2.add(lblInfosBails_2_1_15_1);

		JComboBox<String> comboBox_1_1 = new JComboBox<String>();
		comboBox_1_1.setBounds(440, 241, 50, 22);
		comboBox_1_1.setModel(new DefaultComboBoxModel<String>(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		panel_2.add(comboBox_1_1);

		JComboBox<String> comboBox_2_1 = new JComboBox<String>();
		comboBox_2_1.setBounds(493, 241, 50, 22);
		comboBox_2_1.setModel(new DefaultComboBoxModel<String>(new String[] { "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
				"25", "26", "27", "28", "29", "30", "31" }));
		panel_2.add(comboBox_2_1);

		JComboBox<String> comboBox_3_1 = new JComboBox<String>();
		comboBox_3_1.setBounds(550, 241, 79, 22);
		comboBox_3_1.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "1990", "1991", "1992",
				"1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005",
				"2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018",
				"2019", "2020", "2021", "2022", "2023", "2024" }));
		panel_2.add(comboBox_3_1);

		JComboBox<String> comboBox_1_2 = new JComboBox<String>();
		comboBox_1_2.setBounds(148, 270, 50, 22);
		comboBox_1_2.setModel(new DefaultComboBoxModel<String>(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		panel_2.add(comboBox_1_2);

		JComboBox<String> comboBox_2_2 = new JComboBox<String>();
		comboBox_2_2.setBounds(201, 270, 50, 22);
		comboBox_2_2.setModel(new DefaultComboBoxModel<String>(new String[] { "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
				"25", "26", "27", "28", "29", "30", "31" }));
		panel_2.add(comboBox_2_2);

		JComboBox<String> comboBox_3_2 = new JComboBox<String>();
		comboBox_3_2.setBounds(258, 270, 79, 22);
		comboBox_3_2.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "1990", "1991", "1992",
				"1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005",
				"2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018",
				"2019", "2020", "2021", "2022", "2023", "2024" }));
		panel_2.add(comboBox_3_2);

		JLabel lblInfosBails_2_7_1_1 = new JLabel("ID BAILLEUR");
		lblInfosBails_2_7_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_7_1_1.setForeground(Color.BLACK);
		lblInfosBails_2_7_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_7_1_1.setBounds(550, 36, 99, 34);
		panel_2.add(lblInfosBails_2_7_1_1);

		JLabel lblInfosBails_2_1_6_1_1 = new JLabel(".....");
		lblInfosBails_2_1_6_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_6_1_1.setForeground(Color.BLACK);
		lblInfosBails_2_1_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_6_1_1.setBounds(659, 34, 123, 34);
		panel_2.add(lblInfosBails_2_1_6_1_1);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(154, 11, 144, 22);
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maison", "Appartement" }));
		panel_1.add(comboBox);

		JLabel lblNewLabel_2 = new JLabel("TRI:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(77, 15, 100, 18);
		panel_1.add(lblNewLabel_2);

		JButton btnNewButton_3 = new JButton("ACTUALISER");
		btnNewButton_3.addActionListener(new ActionListener() {
			// Remet à jour les sonnées à afficher
			public void actionPerformed(ActionEvent e) {
				ArrayList<Loue> msnList = new ArrayList<Loue>();
				msnList = LoueDAO.getList();
				String colonne[] = { "ID BIEN", "ID LOCATAIRE", "STATUT DEMANDE" };
				DefaultTableModel model = new DefaultTableModel(null, colonne);
				for (int i = 0; i < msnList.size(); i++) {
					if (comboBox.getSelectedItem().toString().equals("Maison")) {
						if (msnDao.ifMaison(msnList.get(i).getLoue_bn_id()).equals("Maison")) {
							Object o[] = { msnList.get(i).getLoue_bn_id(), msnList.get(i).getLoue_lct_id(),
									msnList.get(i).getStatut_demande() };
							model.addRow(o);
						}
					} else {
						if (msnDao.ifMaison(msnList.get(i).getLoue_bn_id()).equals("Appartement")) {
							Object o1[] = { msnList.get(i).getLoue_bn_id(), msnList.get(i).getLoue_lct_id(),
									msnList.get(i).getStatut_demande() };
							model.addRow(o1);
						}
					}
					table.setModel(model);
				}
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectionner = table.getSelectedRow();
				Object valeurCellule0 = table.getValueAt(selectionner, 0);
				Object valeurCellule1 = table.getValueAt(selectionner, 1);
				Locataire lct = LocataireDAO.gets(valeurCellule1.toString());
				String check = msnDao.ifMaison(valeurCellule0.toString());
				if (check.equals("Maison")) {
					Maison msn = msnDao.getMaison(valeurCellule0.toString());
					Bailleur bllr = BailleurDAO.gets(msn.getBn_bllr_id());
					lblInfosBails_2_1_6_1_1.setText(bllr.getBllr_id_bailleur());
					lblInfosBails_2_1_2.setText(bllr.getBllr_nom() + " " + bllr.getBllr_prenom());
					lblInfosBails_2_1_8.setText(bllr.getBllr_address());
					lblInfosBails_2_1_3.setText(lct.getLct_nom() + " " + lct.getLct_prenom());
					lblInfosBails_2_1_9.setText(lct.getLct_address());
					lblInfosBails_2_1_13.setText(Double.toString(msn.getBn_loyer()));
					lblInfosBails_2_1_14.setText(Double.toString(msn.getBn_caution()));
					lblInfosBails_2_1_16.setText(Double.toString(msn.getBn_charges()));
					comboBox_1_2.getSelectedItem().toString();
					lblInfosBails_2_1_15.setText(String.join("-", comboBox_3_2.getSelectedItem().toString(),
							comboBox_2_2.getSelectedItem().toString(), comboBox_1_2.getSelectedItem().toString()));
					System.out.println(lblInfosBails_2_1_15.getText() + lblInfosBails_2_1_15.getText());
					lblInfosBails_2_1_6.setText(valeurCellule0.toString());
					lblInfosBails_2_1_6_1.setText(valeurCellule1.toString());
				} else {
					Appartement app = appDao.getAppartement(valeurCellule0.toString());
					Bailleur bllr = BailleurDAO.gets(app.getApp_id_appartement());
					lblInfosBails_2_1_6_1_1.setText(bllr.getBllr_id_bailleur());
					lblInfosBails_2_1_2.setText(bllr.getBllr_nom() + " " + bllr.getBllr_prenom());
					lblInfosBails_2_1_8.setText(bllr.getBllr_address());
					lblInfosBails_2_1_3.setText(lct.getLct_nom() + " " + lct.getLct_prenom());
					lblInfosBails_2_1_9.setText(lct.getLct_address());
					lblInfosBails_2_1_13.setText(Double.toString(app.getBn_loyer()));
					lblInfosBails_2_1_14.setText(Double.toString(app.getBn_caution()));
					lblInfosBails_2_1_16.setText(Double.toString(app.getBn_charges()));
					lblInfosBails_2_1_15.setText("Frais agence à ...");
					lblInfosBails_2_1_6.setText(valeurCellule0.toString());
					lblInfosBails_2_1_6_1.setText(valeurCellule1.toString());
				}

			}
		});

		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.setBounds(307, 10, 113, 23);
		panel_1.add(btnNewButton_3);

		JButton btnNewButton = new JButton("Créer le bail");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.getSelectedItem().toString();
				comboBox_1_1.getSelectedItem().toString();
				comboBox_1_2.getSelectedItem().toString();
				Bail bail = new Bail(String.join("-", comboBox_3.getSelectedItem().toString(),
						comboBox_2.getSelectedItem().toString(), comboBox_1.getSelectedItem().toString()).toString(),
						"A completer",
						String.join("-", comboBox_3_1.getSelectedItem().toString(),
								comboBox_2_1.getSelectedItem().toString(), comboBox_1_1.getSelectedItem().toString())
								.toString(),
						Double.parseDouble(lblInfosBails_2_1_13.getText()),
						Double.parseDouble(lblInfosBails_2_1_16.getText()),
						Double.parseDouble(lblInfosBails_2_1_14.getText()),
						Double.parseDouble(lblInfosBails_2_1_14.getText())/* A compléter */,
						String.join("-", comboBox_3_2.getSelectedItem().toString(),
								comboBox_2_2.getSelectedItem().toString(), comboBox_1_2.getSelectedItem().toString())
								.toString(),
						"Garant ", lblInfosBails_2_1_6.getText(), lblInfosBails_2_1_6_1_1.getText());
				BailDAO bailDao = new BailDAO();
				bailDao.add(bail, lblInfosBails_2_1_6_1.getText());
			}
		});
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBounds(704, 402, 194, 42);
		panel_1.add(btnNewButton);

	}
}
