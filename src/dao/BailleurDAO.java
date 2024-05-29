package dao;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table B3_Bailleur
 * 
 * @author Equipe 5.2
 * @version 2.0
 * */
public class BailleurDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public BailleurDAO() {
		super();
	}
	
	private boolean test = true; // Dis si l'ajout est fait ou non

	/**
	 * Permet d'ajouter un bailleur dans la table Bailleur. Le mode est auto-commit
	 * par defaut : chaque insertion est validee
	 * 
	 * @param bailleur le bailleur a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Bailleur bailleur) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement(
					"INSERT INTO b3_Bailleur ( BLLR_ID_BAILLEUR ,BLLR_NOM ,BLLR_PRENOM , BLLR_AGE ,BLLR_ADRESSEMAIL, BLLR_ADRESSE ,BLLR_ID , BLLR_MDP) VALUES(bllr_id_bailleur_seq.nextval, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, bailleur.getBllr_nom());
			ps.setString(2, bailleur.getBllr_prenom());
			ps.setInt(3, bailleur.getBllr_age());
			ps.setString(4, bailleur.getBllr_address());
			ps.setString(5, bailleur.getBllr_adresseMail());
			ps.setString(6, bailleur.getBllr_id());
			ps.setString(7, bailleur.getBllr_mdp());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001")) {
				JOptionPane.showMessageDialog(new JFrame(), "Ce bailleur existe déjà. Ajout impossible !", "Erreur",
						JOptionPane.ERROR_MESSAGE);
				test = false;
			} else {
				test = true;
				e.printStackTrace();
			}
		} finally {
			if (test == true) {
				JOptionPane.showMessageDialog(new JFrame(), "Inscription réussie", "Inscription",
						JOptionPane.DEFAULT_OPTION);
			}
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
	
	/**
	 * Permet d'ajouter une pièce d'identité s'il n'y en a pas dans la table
	 * bailleur et le modifie sinon. Le mode est auto-commit par defaut : chaque
	 * insertion est validee
	 * 
	 * @param bllr_id_bailleur du bailleur 
	 * @param pdfData le fichier en byte à mettre dans la base de donées
	 * @return retourne le nombre de lignes ajoutees dans la table bailleur
	 */
	public static int addPieceIdentite(String bllr_id_bailleur, byte[] pdfData) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("UPDATE b3_bailleur SET bllr_piece_identite = ? WHERE bllr_id_bailleur = ?");
			ps.setBytes(1, pdfData);
			ps.setString(2, bllr_id_bailleur);

			// Execution de la requête
			returnValue = ps.executeUpdate();
			
			JOptionPane.showMessageDialog(new JFrame(), "Fichier ajouté ", "Dépôt de fichier",
					JOptionPane.OK_OPTION);

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				JOptionPane.showMessageDialog(new JFrame(), "Ce fichier existe déjà. Ajout impossible !", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			else
				e.printStackTrace();
		} finally {
			
			JOptionPane.showMessageDialog(new JFrame(), "Fichier déposé avec succès", "Dépôt de fichier!",
					JOptionPane.DEFAULT_OPTION);
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
	
	
	/**
	 * Permet d'ajouter un RIB s'il n'y en a pas dans la table
	 * bailleur et le modifie sinon. Le mode est auto-commit par defaut : chaque
	 * insertion est validee
	 * 
	 * @param bllr_id_bailleur du bailleur 
	 * @param pdfData le fichier en byte à mettre dans la base de donées
	 * @return retourne le nombre de lignes ajoutees dans la table bailleur
	 */
	public static int addRIB(String bllr_id_bailleur, byte[] pdfData) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("UPDATE b3_bailleur SET bllr_RIB = ? WHERE bllr_id_bailleur = ?");
			ps.setBytes(1, pdfData);
			ps.setString(2, bllr_id_bailleur);

			// Execution de la requête
			returnValue = ps.executeUpdate();
			
			JOptionPane.showMessageDialog(new JFrame(), "Fichier ajouté ", "Dépôt de fichier",
					JOptionPane.OK_OPTION);

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				JOptionPane.showMessageDialog(new JFrame(), "Ce fichier existe déjà. Ajout impossible !", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			else
				e.printStackTrace();
		} finally {
			
			JOptionPane.showMessageDialog(new JFrame(), "Fichier déposé avec succès", "Dépôt de fichier!",
					JOptionPane.DEFAULT_OPTION);
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
	
	

	/**
	 * Permet de trouver l'identifiant de l'utilisateur et comparer le mot de passe
	 * 
	 * @param bailleur qui veut se connecter
	 * @return boolean qui dit si la connexion est reussie ou non
	 */
	public boolean connexion(Bailleur bailleur) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Bailleur returnValue = null;
		boolean fin = false;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT bllr_id, bllr_mdp FROM b3_bailleur WHERE bllr_id = ?");
			ps.setString(1, bailleur.getBllr_id());

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Bailleur(rs.getString("bllr_id"), rs.getString("bllr_mdp"));

				if (bailleur.getBllr_id().equals(returnValue.getBllr_id())) {
					if (bailleur.getBllr_mdp().equals(returnValue.getBllr_mdp())) {
						JOptionPane.showMessageDialog(new JFrame(), "Connecté(e) avec succès", "Connexion",
								JOptionPane.DEFAULT_OPTION);
						fin = true;
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Mot de passe erroné", "Erreur de mot de passe",
								JOptionPane.ERROR_MESSAGE);
						fin = false;
					}
				}
				if ((bailleur.getBllr_id().equals(null))) {
					JOptionPane.showMessageDialog(new JFrame(), "Identifiant introuvable", "Erreur d'identifiant",
							JOptionPane.ERROR_MESSAGE);
					fin = false;
				}
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Identifiant introuvable", "Erreur d'identifiant",
						JOptionPane.ERROR_MESSAGE);
				fin = false;
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return fin;
	}

	/**
	 * Permet de trouver un bailleur a partir de son identifiant personnel
	 * 
	 * @param bllr_id permet de retrouver le bailleur a recuperer
	 * @return le bailleur trouve;
	 * 			null si aucun bailleur ne correspond a cette reference
	 */	
	public static Bailleur get(String bllr_id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Bailleur returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT bllr_id_bailleur, bllr_nom, bllr_prenom, bllr_age, bllr_adresse, bllr_adressemail, bllr_id, bllr_mdp FROM b3_bailleur WHERE bllr_id = ?");
			ps.setString(1, bllr_id);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Bailleur(rs.getString("bllr_id_bailleur"), rs.getString("bllr_nom"), rs.getString("bllr_prenom"), rs.getInt("bllr_age"),
						rs.getString("bllr_adresse"), rs.getString("bllr_adressemail"), rs.getString("bllr_id"),
						rs.getString("bllr_mdp"));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet de trouver un bailleur a partir de son identifiant personnel
	 * 
	 * @param bllr_id permet de retrouver le bailleur a recuperer
	 * @return le bailleur trouve;
	 * 			null si aucun bailleur ne correspond a cette reference
	 */	
	public static Bailleur gets(String bllr_id_bailleur) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Bailleur returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT bllr_id_bailleur, bllr_nom, bllr_prenom, bllr_age, bllr_adresse, bllr_adressemail, bllr_id, bllr_mdp FROM b3_bailleur WHERE bllr_id_bailleur = ?");
			ps.setString(1, bllr_id_bailleur);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Bailleur(rs.getString("bllr_id_bailleur"), rs.getString("bllr_nom"), rs.getString("bllr_prenom"), rs.getInt("bllr_age"),
						rs.getString("bllr_adresse"), rs.getString("bllr_adressemail"), rs.getString("bllr_id"),
						rs.getString("bllr_mdp"));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
	
}