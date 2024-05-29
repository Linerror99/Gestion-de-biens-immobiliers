package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Associe;

/**
 * Classe d'acces aux donnees contenues dans la table b3_Associe
 * 
 * @author Equipe 5.2
 * @version 2.0
 */
public class AssocieDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public AssocieDAO() {
		super();
	}

	/**
	 * Permet de recuperer les infos à afficher de la table Associe
	 * et les retourne
	 * 
	 * @return une ArrayList de Associe
	 */
	public static ArrayList<Associe> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Associe> returnValue = new ArrayList<Associe>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM b3_associe ");

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(
						new Associe(rs.getString("asso_bn_id"), rs.getString("asso_lct_id"), rs.getString("statut_bl")));
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
	 * Permet de recuperer les infos à afficher de table Associe
	 * et les retourne
	 * 
	 * @param asso_bl_id identifiant du locataire
	 * @return une ArrayList de Associe lié à un locataire specifique
	 */
	public static ArrayList<Associe> getListLocataire(String asso_lct_id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Associe> returnValue = new ArrayList<Associe>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM b3_associe "
					+ "				   WHERE asso_lct_id = ?");
			ps.setString(1, asso_lct_id);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(
						new Associe(rs.getString("Associe_bl_id"), rs.getString("Associe_lct_id"), rs.getString("statut_bl")));
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

}
