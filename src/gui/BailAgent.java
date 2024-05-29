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
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import model.Bailleur;
import model.Bail;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class BailAgent {

	public JFrame frmTousLesBails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Agent agent = new Agent("p", "p", "p");
				try {
					BailAgent window = new BailAgent(agent);
					window.frmTousLesBails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BailAgent(Agent agent) {
		initialize(agent);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Agent agent) {

		frmTousLesBails = new JFrame();
		frmTousLesBails.setTitle("Tous les bails");
		frmTousLesBails.setIconImage(Toolkit.getDefaultToolkit().getImage(BailAgent.class.getResource("/model/IDAELicone.jpg")));
		frmTousLesBails.setResizable(false);
		frmTousLesBails.setBounds(100, 100, 1290, 630);
		frmTousLesBails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTousLesBails.setLocationRelativeTo(null); // Centre le JFrame sur l'écran
		frmTousLesBails.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 0, 1264, 125);
		frmTousLesBails.getContentPane().add(panel);
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
		frmTousLesBails.getContentPane().add(panel_1);
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
				frmTousLesBails.dispose();
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
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
				bailList = BailDAO.getList();
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
		
		JButton btnNewButton = new JButton("ETAT DES LIEUX ENTRANT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setDialogTitle("Sélectionnez un fichier PDF");
		        fileChooser.setAcceptAllFileFilterUsed(false);
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Documents", "pdf");
		        fileChooser.addChoosableFileFilter(filter);

		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            // Vous pouvez maintenant utiliser 'selectedFile' pour lire le fichier PDF et l'insérer dans la base de données
		            Path pdfPath = Paths.get(selectedFile.getAbsolutePath());
			        try {
			        	byte[] pdfData = Files.readAllBytes(pdfPath);
			        	BailDAO.addEtatDesLieux_IN(lblInfosBails_2_1_6.getText(), pdfData);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			       
		        }
			}
		});
		btnNewButton.setBackground(new Color(127, 255, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(451, 408, 201, 35);
		panel_1.add(btnNewButton);
		
		JButton btnEtatDesLieux = new JButton("ETAT DES LIEUX SORTANT");
		btnEtatDesLieux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setDialogTitle("Sélectionnez un fichier PDF");
		        fileChooser.setAcceptAllFileFilterUsed(false);
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Documents", "pdf");
		        fileChooser.addChoosableFileFilter(filter);

		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            // On maintenant utilise 'selectedFile' pour lire le fichier PDF et l'insérer dans la base de données
		            Path pdfPath = Paths.get(selectedFile.getAbsolutePath());
			        try {
			        	byte[] pdfData = Files.readAllBytes(pdfPath);
			        	BailDAO.addEtatDesLieux_OUT(lblInfosBails_2_1_6.getText(), pdfData);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			       
		        }
			}
		});
		btnEtatDesLieux.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnEtatDesLieux.setBackground(new Color(127, 255, 0));
		btnEtatDesLieux.setBounds(674, 408, 201, 35);
		panel_1.add(btnEtatDesLieux);
		
		JButton btnAttestationAssurance = new JButton("ATTESTATION ASSURANCE");
		btnAttestationAssurance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setDialogTitle("Sélectionnez une image");
		        fileChooser.setAcceptAllFileFilterUsed(false);
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png");
		        fileChooser.addChoosableFileFilter(filter);

		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            // Vous pouvez maintenant utiliser 'selectedFile' pour lire le fichier PDF et l'insérer dans la base de données
		            Path imagePath = Paths.get(selectedFile.getAbsolutePath());
			        try {
			        	byte[] pdfData = Files.readAllBytes(imagePath);
			        	BailDAO.addAttestationAssurance(lblInfosBails_2_1_6.getText(), pdfData);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			       
		        }
			}
		});
		btnAttestationAssurance.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnAttestationAssurance.setBackground(new Color(127, 255, 0));
		btnAttestationAssurance.setBounds(895, 409, 201, 35);
		panel_1.add(btnAttestationAssurance);

	}
}
