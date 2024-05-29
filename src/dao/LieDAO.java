package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Lie;

/**
 * Classe d'acces aux donnees contenues dans la table b3_Lie
 * 
 * @author Equipe 5.2
 * @version 2.0
 */
public class LieDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public LieDAO() {
		super();
	}

	/**
	 * Permet de recuperer les infos à afficher de la table Loue
	 * et les retourne
	 * 
	 * @return une ArrayList de Loue
	 */
	public static ArrayList<Lie> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Lie> returnValue = new ArrayList<Lie>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM b3_lie ");

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(
						new Lie(rs.getString("Lie_lct_id"), rs.getString("Lie_bl_id")));
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
	 * Permet de recuperer les infos à afficher de table Lie
	 * et les retourne
	 * 
	 * @param loue_lct_id identifiant du locataire
	 * @return une ArrayList de Loue lié à un locataire specifique
	 */
	public static ArrayList<Lie> getListLocataire(String lie_lct_id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Lie> returnValue = new ArrayList<Lie>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM b3_lie "
					+ "				   WHERE lie_lct_id = ?");
			ps.setString(1, lie_lct_id);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(
						new Lie(rs.getString("Lie_lct_id"), rs.getString("Lie_bl_id")));
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
	 * Permet de recuperer l'id du locataire d'un bail de la table Lie
	 * et le retourne
	 * 
	 * @param Lie_bl_id est l'id du bail dont on recherche le locataire
	 * @return id du locataire d'un bail de la table  Lie
	 */
	public static String getIdLocataire(String Lie_bl_id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String returnValue = new String();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT Lie_lct_id FROM b3_lie WHERE Lie_bl_id = ? ");
			ps.setString(1, Lie_bl_id);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue = rs.getString("Lie_lct_id");
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
