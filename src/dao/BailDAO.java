package dao;

import java.sql.*;

import dao.*;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table B3_Bail
 * 
 * @author Equipe 5.2
 * @version 2.0
 */
public class BailDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public BailDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un bien dans la table bail. Le mode est auto-commit par
	 * defaut : chaque insertion est validee
	 * 
	 * @param bail est ajouté à bail
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Bail bail, String lie_lct_id) {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement(
					"INSERT INTO b3_bail(BL_ID_BAIL, BL_DATE, BL_DUREE, BL_DATE_FIN, BL_LOYER, BL_CHARGE, BL_CAUTION, BL_FRAIS_AGENCE, BL_DATE_ECHEANCE, BL_GARANT, BL_BN_ID, BL_BLLR_ID) VALUES(BL_ID_BAIL_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setDate(1, java.sql.Date.valueOf(bail.getBl_date()));
			ps.setString(2, bail.getBl_duree());
			ps.setDate(3, java.sql.Date.valueOf(bail.getBl_date_fin()));
			ps.setDouble(4, bail.getBl_loyer());
			ps.setDouble(5, bail.getBl_charge());
			ps.setDouble(6, bail.getBl_caution());
			ps.setDouble(7, bail.getBl_frais_agence());
			ps.setDate(8, java.sql.Date.valueOf(bail.getBl_date_echeance()));
			ps.setString(9, bail.getBl_garant());
			ps.setString(10, bail.getBl_bn_id());
			ps.setString(11, bail.getBl_bllr_id());

			// Execution de la requête
			returnValue = ps.executeUpdate();

			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps1 = con.prepareStatement("INSERT INTO b3_lie VALUES(?, BL_ID_BAIL_SEQ.currval)");
			ps1.setString(1, lie_lct_id);

			// Execution de la requête
			returnValue = ps1.executeUpdate();
			
			AppartementDAO.updateStatutLoué(bail.getBl_bn_id());

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				JOptionPane.showMessageDialog(new JFrame(), "Cette maison  existe déjà. Ajout impossible !", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			else
				e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (ps1 != null) {
					ps1.close();
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
	 * Permet de recuperer les infos à afficher de la table bail et les retourne
	 * 
	 * @param bl_id_bail du bail recherche
	 * @return un bail à partir de son id de la database
	 */
	public static Bail getBail(String bl_id_bail) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Bail returnValue = new Bail();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT BL_ID_BAIL,	BL_DATE, BL_DUREE, BL_DATE_FIN, BL_LOYER, BL_CHARGE, BL_CAUTION, BL_FRAIS_AGENCE, BL_DATE_ECHEANCE, BL_GARANT, BL_BN_ID, BL_BLLR_ID "
							+ "					FROM b3_bail " + "					WHERE bl_id_bail = ?");
			ps.setString(1, bl_id_bail);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue = new Bail(rs.getString("BL_ID_BAIL"), rs.getDate("BL_DATE").toString(),
						rs.getString("BL_DUREE"), rs.getDate("BL_DATE_FIN").toString(), rs.getDouble("BL_LOYER"),
						rs.getDouble("BL_CHARGE"), rs.getDouble("BL_CAUTION"), rs.getDouble("BL_FRAIS_AGENCE"),
						rs.getDate("BL_DATE_ECHEANCE").toString(), rs.getString("BL_GARANT"), rs.getString("BL_BN_ID"),
						rs.getString("BL_BLLR_ID"));

			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet de recuperer toutes les infos à afficher de la table bail et les
	 * retourne
	 * 
	 * @return une ArrayList de tous les bails
	 */
	public static ArrayList<Bail> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Bail> returnValue = new ArrayList<Bail>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT BL_ID_BAIL,	BL_DATE, BL_DUREE, BL_DATE_FIN, BL_LOYER, BL_CHARGE, BL_CAUTION, BL_FRAIS_AGENCE, BL_DATE_ECHEANCE, BL_GARANT, BL_BN_ID, BL_BLLR_ID "
							+ "					FROM b3_bail ");

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new Bail(rs.getString("BL_ID_BAIL"), rs.getDate("BL_DATE").toString(),
						rs.getString("BL_DUREE"), rs.getDate("BL_DATE_FIN").toString(), rs.getDouble("BL_LOYER"),
						rs.getDouble("BL_CHARGE"), rs.getDouble("BL_CAUTION"), rs.getDouble("BL_FRAIS_AGENCE"),
						rs.getDate("BL_DATE_ECHEANCE").toString(), rs.getString("BL_GARANT"), rs.getString("BL_BN_ID"),
						rs.getString("BL_BLLR_ID")));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet de recuperer toutes les infos à afficher de la table bail et les
	 * retourne
	 * 
	 * @param bllr_id_bailleur dont on recherche les bails
	 * @return une ArrayList de touts les bails liés à un bailleur spécifique
	 */
	public static ArrayList<Bail> getListbailleur(String bllr_id_bailleur) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Bail> returnValue = new ArrayList<Bail>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT BL_ID_BAIL,	BL_DATE, BL_DUREE, BL_DATE_FIN, BL_LOYER, BL_CHARGE, BL_CAUTION, BL_FRAIS_AGENCE, BL_DATE_ECHEANCE, BL_GARANT, BL_BN_ID, BL_BLLR_ID "
							+ "					FROM b3_bail " + "					WHERE bl_bllr_id = ?"
							+ "					ORDER BY bl_bllr_id ");
			ps.setString(1, bllr_id_bailleur);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new Bail(rs.getString("BL_ID_BAIL"), rs.getDate("BL_DATE").toString(),
						rs.getString("BL_DUREE"), rs.getDate("BL_DATE_FIN").toString(), rs.getDouble("BL_LOYER"),
						rs.getDouble("BL_CHARGE"), rs.getDouble("BL_CAUTION"), rs.getDouble("BL_FRAIS_AGENCE"),
						rs.getDate("BL_DATE_ECHEANCE").toString(), rs.getString("BL_GARANT"), rs.getString("BL_BN_ID"),
						rs.getString("BL_BLLR_ID")));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet d'ajouter un etat des lieux entrant s'il n'y en a pas dans la table
	 * bail et le modifie sinon. Le mode est auto-commit par defaut : chaque
	 * insertion est validee
	 * 
	 * @param bail est ajouté à bail
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public static int addEtatDesLieux_IN(String bl_id_bail, byte[] pdfData) {
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
			ps = con.prepareStatement("UPDATE b3_bail SET ETATDESLIEUX_IN = ? WHERE bl_id_bail = ?");
			ps.setBytes(1, pdfData);
			ps.setString(2, bl_id_bail);

			// Execution de la requête
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				JOptionPane.showMessageDialog(new JFrame(), "Ce fichier  existe déjà. Ajout impossible !", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			else
				e.printStackTrace();
		} finally {
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
	 * Permet d'ajouter un etat des lieux sortant s'il n'y en a pas dans la table
	 * bail et le modifie sinon. Le mode est auto-commit par defaut : chaque
	 * insertion est validee
	 * 
	 * @param bail est ajouté à bail
	 * @return retourne le nombre de lignes ajoutees dans la table bail
	 */
	public static int addEtatDesLieux_OUT(String bl_id_bail, byte[] pdfData) {
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
			ps = con.prepareStatement("UPDATE b3_bail SET ETATDESLIEUX_OUT = ? WHERE bl_id_bail = ?");
			ps.setBytes(1, pdfData);
			ps.setString(2, bl_id_bail);

			// Execution de la requête
			returnValue = ps.executeUpdate();
			
			JOptionPane.showMessageDialog(new JFrame(), "Fichier ajouté ", "Dépôt de fichier",
					JOptionPane.OK_OPTION);

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				JOptionPane.showMessageDialog(new JFrame(), "Ce fichier  existe déjà. Ajout impossible !", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			else
				e.printStackTrace();
		} finally {
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
	 * Permet d'ajouter un etat des lieux sortant s'il n'y en a pas dans la table
	 * bail et le modifie sinon. Le mode est auto-commit par defaut : chaque
	 * insertion est validee
	 * 
	 * @param bail est ajouté à bail
	 * @return retourne le nombre de lignes ajoutees dans la table bail
	 */
	public static int addAttestationAssurance(String bl_id_bail, byte[] pdfData) {
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
			ps = con.prepareStatement("UPDATE b3_bail SET ATTESTATIONASSURANCE = ? WHERE bl_id_bail = ?");
			ps.setBytes(1, pdfData);
			ps.setString(2, bl_id_bail);

			// Execution de la requête
			returnValue = ps.executeUpdate();
			
			JOptionPane.showMessageDialog(new JFrame(), "Fichier ajouté ", "Dépôt de fichier",
					JOptionPane.OK_OPTION);

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				JOptionPane.showMessageDialog(new JFrame(), "Ce fichier  existe déjà. Ajout impossible !", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			else
				e.printStackTrace();
		} finally {
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

}