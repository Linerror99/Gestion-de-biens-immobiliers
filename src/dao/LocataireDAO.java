package dao;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table B3_Locataire
 * 
 * @author Equipe 5.2
 * @version 2.0
 */
public class LocataireDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public LocataireDAO() {
		super();
	}

	private boolean test = true; // Dis si l'ajout est fait ou non

	/**
	 * Permet d'ajouter un locataire dans la table Locataire. Le mode est
	 * auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param locataire le locataire a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Locataire locataire) {
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
					"INSERT INTO b3_Locataire ( LCT_ID_LOCATAIRE, LCT_NOM, LCT_PRENOM, LCT_AGE, LCT_ADRESSEMAIL, LCT_ADRESSE, LCT_ID, LCT_MDP, LCT_RIB)VALUES(lct_id_locataire_seq.nextval, ?, ?, ?, ?, ?, ?, ?,?)");
			ps.setString(1, locataire.getLct_nom());
			ps.setString(2, locataire.getLct_prenom());
			ps.setInt(3, locataire.getLct_age());
			ps.setString(4, locataire.getLct_address());
			ps.setString(5, locataire.getLct_adresseMail());
			ps.setString(6, locataire.getLct_id());
			ps.setString(7, locataire.getLct_mdp());
			ps.setString(8, locataire.getLct_Rib());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001")) {
				JOptionPane.showMessageDialog(new JFrame(), "Ce locataire existe déjà. Ajout impossible !", "Erreur",
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
	 * Permet d'ajouter un RIB s'il n'y en a pas dans la table locataire et le
	 * modifie sinon. Le mode est auto-commit par defaut : chaque insertion est
	 * validee
	 * 
	 * @param lct_id_locataire du locataire
	 * @param pdfData          le fichier en byte à mettre dans la base de donées
	 * @return retourne le nombre de lignes ajoutees dans la table locataire
	 */
	public static int addRIB(String lct_id_locataire, byte[] pdfData) {
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
			ps = con.prepareStatement("UPDATE b3_locataire SET lctRIB = ? WHERE lct_id_locataire = ?");
			ps.setBytes(1, pdfData);
			ps.setString(2, lct_id_locataire);

			// Execution de la requête
			returnValue = ps.executeUpdate();

			JOptionPane.showMessageDialog(new JFrame(), "Fichier ajouté ", "Dépôt de fichier", JOptionPane.OK_OPTION);

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
	 * Permet d'ajouter un RIB s'il n'y en a pas dans la table locataire et le
	 * modifie sinon. Le mode est auto-commit par defaut : chaque insertion est
	 * validee
	 * 
	 * @param lct_id_locataire du locataire
	 * @param pdfData          le fichier en byte à mettre dans la base de donées
	 * @return retourne le nombre de lignes ajoutees dans la table locataire
	 */
	public static int addPieceIdentite(String lct_id_locataire, byte[] pdfData) {
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
			ps = con.prepareStatement("UPDATE b3_locataire SET lct_Piece_Identite = ? WHERE lct_id_locataire = ?");
			ps.setBytes(1, pdfData);
			ps.setString(2, lct_id_locataire);

			// Execution de la requête
			returnValue = ps.executeUpdate();

			JOptionPane.showMessageDialog(new JFrame(), "Fichier ajouté ", "Dépôt de fichier", JOptionPane.OK_OPTION);

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
	 * @param locataire qui veut se connecter
	 * @return boolean qui dit si la connexion est reussie ou non
	 */
	public boolean connexion(Locataire locataire) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Locataire returnValue = null;
		boolean fin = false;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT lct_id, lct_mdp FROM b3_locataire WHERE lct_id = ?");
			ps.setString(1, locataire.getLct_id());

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Locataire(rs.getString("lct_id"), rs.getString("lct_mdp"));

				if (locataire.getLct_id().equals(returnValue.getLct_id())) {
					if (locataire.getLct_mdp().equals(returnValue.getLct_mdp())) {
						JOptionPane.showMessageDialog(new JFrame(), "Connecté(e) avec succès", "Connexion",
								JOptionPane.DEFAULT_OPTION);
						fin = true;
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Mot de passe erroné", "Erreur de mot de passe",
								JOptionPane.ERROR_MESSAGE);
						fin = false;
					}
				}
				if ((locataire.getLct_id().equals(null))) {
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
	 * Permet de trouver un locataire a partir de son identifiant personnel
	 * 
	 * @param lct_id permet de retrouver le locataire a recuperer
	 * @return le locataire trouve; null si aucun locataire ne correspond a cette
	 *         reference
	 */
	public static Locataire get(String lct_id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Locataire returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT lct_id_locataire, lct_nom, lct_prenom, lct_age, lct_adresse, lct_adressemail, lct_id, lct_mdp, lct_rib FROM b3_locataire WHERE lct_id = ?");
			ps.setString(1, lct_id);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Locataire(rs.getString("lct_id_locataire"), rs.getString("lct_nom"),
						rs.getString("lct_prenom"), rs.getInt("lct_age"), rs.getString("lct_adresse"),
						rs.getString("lct_adressemail"), rs.getString("lct_id"), rs.getString("lct_mdp"),
						rs.getString("lct_rib"));
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
	 * Permet de trouver un locataire a partir de son identifiant clé de la base de
	 * données
	 * 
	 * @param lct_id permet de retrouver le locataire a recuperer
	 * @return le locataire trouve; null si aucun locataire ne correspond a cette
	 *         reference
	 */
	public static Locataire gets(String lct_id_locataire) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Locataire returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT lct_id_locataire, lct_nom, lct_prenom, lct_age, lct_adresse, lct_adressemail, lct_id, lct_mdp, lct_rib FROM b3_locataire WHERE lct_id_locataire = ?");
			ps.setString(1, lct_id_locataire);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Locataire(rs.getString("lct_id_locataire"), rs.getString("lct_nom"),
						rs.getString("lct_prenom"), rs.getInt("lct_age"), rs.getString("lct_adresse"),
						rs.getString("lct_adressemail"), rs.getString("lct_id"), rs.getString("lct_mdp"),
						rs.getString("lct_rib"));
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