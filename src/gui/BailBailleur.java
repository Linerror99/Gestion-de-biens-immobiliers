package gui;

import java.awt.EventQueue;


import dao.BailleurDAO;
import dao.LieDAO;
import dao.LocataireDAO;
import dao.BailDAO;
import model.*;
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

import model.Bailleur;
import model.Bail;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class BailBailleur {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Bailleur bailleur = new Bailleur("p", "p", "p");
				try {
					BailBailleur window = new BailBailleur(bailleur);
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
	public BailBailleur(Bailleur bailleur) {
		initialize(bailleur);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Bailleur bailleur) {

		frame = new JFrame();
		frame.setTitle("Bails du Bailleur");
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

		JLabel lblEspaceBailleur = new JLabel("ESPACE BAILLEUR4");
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane.setBounds(45, 44, 332, 379);
		panel_1.add(scrollPane);

		JTable table = new JTable();
		table.setToolTipText("");

		table.setFont(new Font("Times New Roman", Font.BOLD, 15)); // NOI18N
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID BAIL", "ID BAILLEUR" }));
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
		lblInfosBails.setForeground(Color.DARK_GRAY);
		lblInfosBails.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblInfosBails.setBounds(10, 0, 155, 34);
		panel_2.add(lblInfosBails);

		JLabel lblInfosBails_2_7 = new JLabel("ID BIEN");
		lblInfosBails_2_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_7.setForeground(Color.BLACK);
		lblInfosBails_2_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_7.setBounds(31, 31, 61, 34);
		panel_2.add(lblInfosBails_2_7);

		JLabel lblInfosBails_2_1_6 = new JLabel(".....");
		lblInfosBails_2_1_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_6.setForeground(Color.BLACK);
		lblInfosBails_2_1_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_6.setBounds(112, 30, 123, 34);
		panel_2.add(lblInfosBails_2_1_6);

		JLabel lblInfosBails_2_7_1 = new JLabel("ID LOCATAIRE");
		lblInfosBails_2_7_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_7_1.setForeground(Color.BLACK);
		lblInfosBails_2_7_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_7_1.setBounds(313, 32, 99, 34);
		panel_2.add(lblInfosBails_2_7_1);

		JLabel lblInfosBails_2_1_6_1 = new JLabel(".....");
		lblInfosBails_2_1_6_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_6_1.setForeground(Color.BLACK);
		lblInfosBails_2_1_6_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_6_1.setBounds(422, 30, 123, 34);
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

		JLabel lblInfosBails_2_1_15_1 = new JLabel(".....");
		lblInfosBails_2_1_15_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_15_1.setForeground(Color.BLACK);
		lblInfosBails_2_1_15_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_15_1.setBounds(746, 234, 68, 34);
		panel_2.add(lblInfosBails_2_1_15_1);

		JLabel lblInfosBails_2_7_1_1 = new JLabel("ID BAILLEUR");
		lblInfosBails_2_7_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_7_1_1.setForeground(Color.BLACK);
		lblInfosBails_2_7_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblInfosBails_2_7_1_1.setBounds(570, 33, 99, 34);
		panel_2.add(lblInfosBails_2_7_1_1);

		JLabel lblInfosBails_2_1_6_1_1 = new JLabel(".....");
		lblInfosBails_2_1_6_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_6_1_1.setForeground(Color.BLACK);
		lblInfosBails_2_1_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_6_1_1.setBounds(679, 31, 123, 34);
		panel_2.add(lblInfosBails_2_1_6_1_1);

		JLabel lblInfosBails_2_1_6_2 = new JLabel(".....");
		lblInfosBails_2_1_6_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_6_2.setForeground(Color.BLACK);
		lblInfosBails_2_1_6_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_6_2.setBounds(161, 235, 123, 34);
		panel_2.add(lblInfosBails_2_1_6_2);

		JLabel lblInfosBails_2_1_6_3 = new JLabel(".....");
		lblInfosBails_2_1_6_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_6_3.setForeground(Color.BLACK);
		lblInfosBails_2_1_6_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_6_3.setBounds(161, 268, 123, 34);
		panel_2.add(lblInfosBails_2_1_6_3);

		JLabel lblInfosBails_2_1_6_4 = new JLabel(".....");
		lblInfosBails_2_1_6_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfosBails_2_1_6_4.setForeground(Color.BLACK);
		lblInfosBails_2_1_6_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfosBails_2_1_6_4.setBounds(453, 235, 123, 34);
		panel_2.add(lblInfosBails_2_1_6_4);

		JButton btnNewButton_3 = new JButton("ACTUALISER");
		btnNewButton_3.addActionListener(new ActionListener() {
			// Remet à jour les données à afficher
			public void actionPerformed(ActionEvent e) {
				ArrayList<Bail> bailList = new ArrayList<Bail>();
				bailList = BailDAO.getListbailleur(BailleurDAO.get(bailleur.getBllr_id()).getBllr_id_bailleur());
				String colonne[] = { "ID BAIL", "ID BAILLEUR" };
				DefaultTableModel model = new DefaultTableModel(null, colonne);
				for (int i = 0; i < bailList.size(); i++) {
					Object o[] = { bailList.get(i).getBl_id_bail(), bailList.get(i).getBl_bllr_id() };
					model.addRow(o);
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
				Bail bail = BailDAO.getBail(valeurCellule0.toString());
				Locataire lct = LocataireDAO.gets(LieDAO.getIdLocataire(valeurCellule0.toString()));
				Bailleur bailleur = BailleurDAO.gets(valeurCellule1.toString());
				lblInfosBails_2_1_6.setText(valeurCellule0.toString());
				lblInfosBails_2_1_6_1_1.setText(bail.getBl_bllr_id());
				
				lblInfosBails_2_1_2.setText(bailleur.getBllr_nom()+ " " + bailleur.getBllr_prenom());
				lblInfosBails_2_1_8.setText(bailleur.getBllr_address());
				
				lblInfosBails_2_1_3.setText(lct.getLct_nom() + " " + lct.getLct_prenom());
				lblInfosBails_2_1_9.setText(lct.getLct_nom());
				lblInfosBails_2_1_13.setText(Double.toString(bail.getBl_loyer()));
				lblInfosBails_2_1_14.setText(Double.toString(bail.getBl_caution()));
				lblInfosBails_2_1_16.setText(Double.toString(bail.getBl_charge()));
				lblInfosBails_2_1_6_1.setText(lct.getLct_id_locataire());
				lblInfosBails_2_1_7.setText(bail.getBl_garant());
				lblInfosBails_2_1_15.setText(Double.toString(bail.getBl_frais_agence()));
				lblInfosBails_2_1_6_2.setText(bail.getBl_date());
				lblInfosBails_2_1_6_3.setText(bail.getBl_date_echeance());
				lblInfosBails_2_1_6_4.setText(bail.getBl_date_fin());
				lblInfosBails_2_1_15_1.setText(bail.getBl_duree());

			}
		});

		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.setBounds(151, 10, 135, 23);
		panel_1.add(btnNewButton_3);

	}
}
