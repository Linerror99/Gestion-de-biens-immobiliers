package gui;

import java.awt.EventQueue;

import model.Bailleur;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.BailleurDAO;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;

public class EspaceBailleur {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Bailleur bailleur = new Bailleur("p", "p", "p");
				try {
					EspaceBailleur window = new EspaceBailleur(bailleur);
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
	public EspaceBailleur(Bailleur bailleur) {
		initialize(bailleur);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Bailleur bailleur) {
		frame = new JFrame();

		frame.setTitle("Espace Bailleur");
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
		
		JLabel lblEspaceLocataire = new JLabel("ESPACE BAILLEUR");
		lblEspaceLocataire.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspaceLocataire.setForeground(new Color(138, 43, 226));
		lblEspaceLocataire.setFont(new Font("Times New Roman", Font.BOLD, 43));
		lblEspaceLocataire.setBounds(321, 90, 593, 90);
		panel.add(lblEspaceLocataire);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(bailleur.getBllr_id());
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
					BailBailleur window = new BailBailleur(bailleur);
					window.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(62, 88, 283, 106);
		panel_1.add(btnNewButton);
		
		JButton btnRechercherLocation = new JButton("Ajouter bien immobilier");
		btnRechercherLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DepotdeBien window = new DepotdeBien(bailleur);
					window.frame.setVisible(true);
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRechercherLocation.setForeground(Color.BLACK);
		btnRechercherLocation.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnRechercherLocation.setBounds(496, 88, 283, 106);
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
		
		JButton btnNewButton_1 = new JButton("Suivre demande d'ajout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SuiviDemandeDepot window = new SuiviDemandeDepot(bailleur);
					window.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
				
			}
			
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(921, 88, 283, 106);
		panel_1.add(btnNewButton_1);
		
		JButton btnDposerPieceDidentit = new JButton("Déposer pièce d'identité");
		btnDposerPieceDidentit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setDialogTitle("Sélectionnez un fichier");
		        fileChooser.setAcceptAllFileFilterUsed(false);
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Documents", "pdf");
		        fileChooser.addChoosableFileFilter(filter);
		        FileNameExtensionFilter filters = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png");
		        fileChooser.addChoosableFileFilter(filters);

		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            // Vous pouvez maintenant utiliser 'selectedFile' pour lire le fichier PDF et l'insérer dans la base de données
		            Path pdfPath = Paths.get(selectedFile.getAbsolutePath());
			        try {
			        	byte[] pdfData = Files.readAllBytes(pdfPath);
			        	BailleurDAO.addPieceIdentite(BailleurDAO.get(bailleur.getBllr_id()).getBllr_id_bailleur(), pdfData);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			       
		        }
			}
		});
		btnDposerPieceDidentit.setForeground(Color.BLACK);
		btnDposerPieceDidentit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDposerPieceDidentit.setBounds(273, 205, 283, 106);
		panel_1.add(btnDposerPieceDidentit);
		
		JButton btnDposerRib = new JButton("Déposer RIB");
		btnDposerRib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setDialogTitle("Sélectionnez un fichier");
		        fileChooser.setAcceptAllFileFilterUsed(false);
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Documents", "pdf");
		        fileChooser.addChoosableFileFilter(filter);
		        FileNameExtensionFilter filters = new FileNameExtensionFilter("Fichiers texte", "txt");
		        fileChooser.addChoosableFileFilter(filters);

		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            // Vous pouvez maintenant utiliser 'selectedFile' pour lire le fichier PDF et l'insérer dans la base de données
		            Path pdfPath = Paths.get(selectedFile.getAbsolutePath());
			        try {
			        	byte[] pdfData = Files.readAllBytes(pdfPath);
			        	BailleurDAO.addRIB(BailleurDAO.get(bailleur.getBllr_id()).getBllr_id_bailleur(), pdfData);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			       
		        }	
			}
		});
		btnDposerRib.setForeground(Color.BLACK);
		btnDposerRib.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDposerRib.setBounds(687, 205, 283, 106);
		panel_1.add(btnDposerRib);
	}
}
