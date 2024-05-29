package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Loue;

/**
 * Classe d'acces aux donnees contenues dans la table B3_Loue
 * 
 * @author Equipe 5.2
 * @version 2.0
 * */
public class LoueDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public LoueDAO() {
		super();
	}

	/**
	 * Permet de recuperer les infos à afficher de la table Loue 
	 * et les retourne
	 * 
	 * @return une ArrayList de Loue
	 */
	public static ArrayList<Loue> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Loue> returnValue = new ArrayList<Loue>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM b3_loue ");

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(
						new Loue(rs.getString("Loue_lct_id"), rs.getString("Loue_bn_id"), rs.getString("statut_demande")));
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
	 * Permet de recuperer les infos à afficher de table Loue
	 * et les retourne
	 * 
	 * @param loue_lct_id identifiant du locataire
	 * @return une ArrayList de Loue lié à un locataire specifique
	 */
	public static ArrayList<Loue> getListLocataire(String loue_lct_id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Loue> returnValue = new ArrayList<Loue>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM b3_loue "
					+ "				   WHERE loue_lct_id = ?");
			ps.setString(1, loue_lct_id);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(
						new Loue(rs.getString("Loue_lct_id"), rs.getString("Loue_bn_id"), rs.getString("statut_demande")));
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
