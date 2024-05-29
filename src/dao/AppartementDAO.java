package dao;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table Appartement
 * 
 * @author Equipe 5.2
 * @version 2.0
 */
public class AppartementDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public AppartementDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un appartement dans la table bienimmobilier et dans la table appartement. 
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param appartement est ajouté à appartement et bienimmobilier
	 * @return retourne le nombre de lignes ajoutees dans les tables
	 */
	public int add(Appartement appartement) {
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
					"INSERT INTO b3_bienimmobilier VALUES(BN_ID_MSN_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, appartement.getBn_adresse());
			ps.setInt(2, appartement.getBn_nombredepiece());
			ps.setString(3, appartement.getBn_meuble());
			ps.setInt(4, appartement.getBn_anneedeconstruction());
			ps.setString(5, appartement.getBn_typedechauffage());
			ps.setString(6, appartement.getBn_statut());
			ps.setDouble(7, appartement.getBn_loyer());
			ps.setDouble(8, appartement.getBn_charges());
			ps.setDouble(9, appartement.getBn_caution());
			ps.setString(10, appartement.getBn_bllr_id());

			// Execution de la requête pour l'insertion dans la table bienimmobilier
			returnValue = ps.executeUpdate();

			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps1 = con.prepareStatement("INSERT INTO b3_appartement VALUES( BN_ID_MSN_SEQ.currval, ?, ?, ?, ?)");
			ps1.setString(1, appartement.getApp_balconouterrasse());
			ps1.setInt(2, appartement.getApp_etage());
			ps1.setInt(3, appartement.getApp_numerodappartement());
			ps1.setString(4, appartement.getApp_type());

			// Execution de la requete pour l'insertion dans la table appartement
			returnValue += ps1.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				JOptionPane.showMessageDialog(new JFrame(), "Cet appartement  existe déjà. Ajout impossible !",
						"Erreur", JOptionPane.ERROR_MESSAGE);
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
	 * Permet de recuperer les infos à afficher de la table appartement 
	 * et les retourne
	 * 
	 * @param bn_id_bien de l' appartement recherchee
	 * @return un  appartement à partir de son id de la database
	 */
	public Appartement getAppartement(String bn_id_bien) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Appartement returnValue = new Appartement();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT Bn_adresse, Bn_nombredepiece, Bn_meuble, Bn_anneedeconstruction, bn_typedechauffage, bn_statut, Bn_loyer,Bn_charges,Bn_caution, Bn_bllr_id, App_balconouterrasse, App_etage, App_numerodappartement, App_type, app_id_appartement "
							+ "					FROM b3_bienimmobilier "
							+ "					INNER JOIN b3_appartement "
							+ "					ON b3_bienimmobilier.bn_id_bien = b3_appartement.app_id_appartement "
							+ "					ORDER BY bn_id_bien ");

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue = new Appartement(rs.getString("Bn_adresse"), rs.getInt("Bn_nombredepiece"),
						rs.getString("Bn_meuble"), rs.getInt("Bn_anneedeconstruction"),
						rs.getString("bn_typedechauffage"), rs.getString("Bn_statut"), rs.getDouble("Bn_loyer"),
						rs.getDouble("Bn_charges"), rs.getDouble("Bn_caution"), rs.getString("Bn_bllr_id"),
						rs.getString("app_id_appartement"), rs.getString("App_balconouterrasse"),
						rs.getInt("App_numerodappartement"), rs.getInt("App_etage"), rs.getString("App_type"));
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
	 * Permet de recuperer les infos à afficher des tables appartement et bienimmobilier
	 *  et les retourne
	 * 
	 * @return une ArrayList des appartements dans la base de données
	 */
	public static ArrayList<Appartement> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Appartement> returnValue = new ArrayList<Appartement>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT Bn_adresse, Bn_nombredepiece, Bn_meuble, Bn_anneedeconstruction, bn_typedechauffage, bn_statut, Bn_loyer,Bn_charges,Bn_caution, Bn_bllr_id, App_balconouterrasse, App_etage, App_numerodappartement, App_type, app_id_appartement "
							+ "					FROM b3_bienimmobilier "
							+ "					INNER JOIN b3_appartement "
							+ "					ON b3_bienimmobilier.bn_id_bien = b3_appartement.app_id_appartement "
							+ "					ORDER BY bn_id_bien ");

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new Appartement(rs.getString("Bn_adresse"), rs.getInt("Bn_nombredepiece"),
						rs.getString("Bn_meuble"), rs.getInt("Bn_anneedeconstruction"),
						rs.getString("bn_typedechauffage"), rs.getString("Bn_statut"), rs.getDouble("Bn_loyer"),
						rs.getDouble("Bn_charges"), rs.getDouble("Bn_caution"), rs.getString("Bn_bllr_id"),
						rs.getString("app_id_appartement"), rs.getString("App_balconouterrasse"),
						rs.getInt("App_numerodappartement"), rs.getInt("App_etage"), rs.getString("App_type")));
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
	 * Permet de recuperer les infos à afficher des tables appartement et bien
	 * immobilier pour un Bailleur specifique et les retourne
	 * 
	 * @return une ArrayList des appartements dans la base de données
	 */
	public static ArrayList<Appartement> getListbailleur(String bllr_id_bailleur) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Appartement> returnValue = new ArrayList<Appartement>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT Bn_adresse, Bn_nombredepiece, Bn_meuble, Bn_anneedeconstruction, bn_typedechauffage, bn_statut, Bn_loyer,Bn_charges,Bn_caution, Bn_bllr_id, App_balconouterrasse, App_etage, App_numerodappartement, App_type, app_id_appartement "
							+ "					FROM b3_bienimmobilier "
							+ "					INNER JOIN b3_appartement "
							+ "					ON b3_bienimmobilier.bn_id_bien = b3_appartement.app_id_appartement "
							+ "					WHERE bn_bllr_id = ?"	
							+ "					ORDER BY bn_id_bien ");
			ps.setString(1, bllr_id_bailleur);
 
			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new Appartement(rs.getString("Bn_adresse"), rs.getInt("Bn_nombredepiece"),
						rs.getString("Bn_meuble"), rs.getInt("Bn_anneedeconstruction"),
						rs.getString("bn_typedechauffage"), rs.getString("Bn_statut"), rs.getDouble("Bn_loyer"),
						rs.getDouble("Bn_charges"), rs.getDouble("Bn_caution"), rs.getString("Bn_bllr_id"),
						rs.getString("app_id_appartement"), rs.getString("App_balconouterrasse"),
						rs.getInt("App_numerodappartement"), rs.getInt("App_etage"), rs.getString("App_type")));
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
	 * Permet de recuperer les infos à afficher des tables appartement et bienimmobilier
	 *  qui sont déjà validés par l'agent et les retourne
	 * 
	 * @return une ArrayList des appartements dans la base de données
	 */
	public static ArrayList<Appartement> getListValide() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Appartement> returnValue = new ArrayList<Appartement>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT Bn_adresse, Bn_nombredepiece, Bn_meuble, Bn_anneedeconstruction, bn_typedechauffage, bn_statut, Bn_loyer ,Bn_charges ,Bn_caution ,Bn_bllr_id , App_balconouterrasse, App_etage, App_numerodappartement, App_type, app_id_appartement "
							+ "					FROM b3_bienimmobilier "
							+ "					INNER JOIN b3_appartement "
							+ "					ON b3_bienimmobilier.bn_id_bien = b3_appartement.app_id_appartement "
							+ "					WHERE bn_statut =  'Validé'"
							+ "					ORDER BY bn_id_bien ");

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new Appartement(rs.getString("Bn_adresse"), rs.getInt("Bn_nombredepiece"),
						rs.getString("Bn_meuble"), rs.getInt("Bn_anneedeconstruction"),
						rs.getString("bn_typedechauffage"), rs.getString("Bn_statut"), rs.getDouble("Bn_loyer"),
						rs.getDouble("Bn_charges"), rs.getDouble("Bn_caution"), rs.getString("Bn_bllr_id"),
						rs.getString("app_id_appartement"), rs.getString("App_balconouterrasse"),
						rs.getInt("App_numerodappartement"), rs.getInt("App_etage"), rs.getString("App_type")));
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
	 * Permet de modifier le statut d'un bien à "Rejeté". 
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param app_id_appartement id de l'appartement 
	 * @return retourne le nombre de lignes modifiees dans la table bienimmobilier
	 */
	public int updateStatutRejet(String app_id_appartement) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans la modification.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("UPDATE b3_bienimmobilier SET bn_statut = 'Rejeté' WHERE bn_id_bien = ?");
			ps.setString(1, app_id_appartement);

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
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
	 * Permet de modifier le statut d'un bien à "Validé". 
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param app_id_appartement id de l'appartement 
	 * @return retourne le nombre de lignes modifiees dans la table bienimmobilier
	 */
	public int updateStatutValide(String app_id_appartement) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans la modification.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("UPDATE b3_bienimmobilier SET bn_statut = 'Validé' WHERE bn_id_bien = ?");
			ps.setString(1, app_id_appartement);

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
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
	 * Permet de modifier le statut d'un bien à "En attente". 
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param app_id_appartement id de l'appartement 
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int updateStatutAttente(String app_id_appartement) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans la modification.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("UPDATE b3_bienimmobilier SET bn_statut = 'En attente' WHERE bn_id_bien = ?");
			ps.setString(1, app_id_appartement);

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
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
	 * Permet de modifier le statut d'un bien à "Loué". 
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param app_id_appartement id de l'appartement 
	 * @return retourne le nombre de lignes modifiees dans la table bienimmobilier
	 */
	public static  int updateStatutLoué(String app_id_appartement) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans la modification.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("UPDATE b3_bienimmobilier SET bn_statut = 'Loué' WHERE bn_id_bien = ?");
			ps.setString(1, app_id_appartement);

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
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
	 * Permet d'ajouter une ligne dans la table Loue pour une maison liée à un locataire.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param loue_lct_id id du locataire
	 * @param loue_bn_id id du bien 
	 * @return retourne le nombre de lignes ajoutees dans la table bienimmobilier
	 */
	public int addDemande(String loue_lct_id, String loue_bn_id) {
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
					"INSERT INTO b3_loue VALUES(?, ?, 'Demande')");
			ps.setString(1, loue_lct_id);
			ps.setString(2, loue_bn_id);
			

			// Execution de la requête
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				JOptionPane.showMessageDialog(new JFrame(), "Vous avez déjà fait une demande. Demande impossible !", "Erreur",
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
	 * Permet de mettre la demande en Attente 
	 * 
	 * @param loue_lct_id id du locataire
	 * @param loue_bn_id id du bien 
	 * @return retourne le nombre de lignes modifiées dans la table bienimmobilier
	 */
	public int updateDemandeAttente(String loue_lct_id, String loue_bn_id) {
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
					"UPDATE b3_loue SET statut_demande = 'En attente' WHERE loue_lct_id = ? AND loue_bn_id = ?");
			ps.setString(1, loue_lct_id);
			ps.setString(2, loue_bn_id);
			

			// Execution de la requête
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
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
	 * Permet de mettre la demande en "Accepté" 
	 * 
	 * @param loue_lct_id id du locataire
	 * @param loue_bn_id id du bien 
	 * @return retourne le nombre de lignes modifiées dans la table bienimmobilier
	 */
	public int updateDemandeAccepte(String loue_lct_id, String loue_bn_id) {
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
					"UPDATE b3_loue SET statut_demande = 'Accepté' WHERE loue_lct_id = ? AND loue_bn_id = ?");
			ps.setString(1, loue_lct_id);
			ps.setString(2, loue_bn_id);
			

			// Execution de la requête
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
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
	 * Permet de mettre la demande en "Achevé" 
	 * 
	 * @param loue_lct_id id du locataire
	 * @param loue_bn_id id du bien 
	 * @return retourne le nombre de lignes modifiées dans la table bienimmobilier
	 */
	public int updateDemandeAchevé(String loue_lct_id, String loue_bn_id) {
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
					"UPDATE b3_loue SET statut_demande = 'Achevé' WHERE loue_lct_id = ? AND loue_bn_id = ?");
			ps.setString(1, loue_lct_id);
			ps.setString(2, loue_bn_id);
			

			// Execution de la requête
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
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
	 * Permet de mettre la demande en "Rejeté" 
	 * 
	 * @param loue_lct_id id du locataire
	 * @param loue_bn_id id du bien 
	 * @return retourne le nombre de lignes modifiées dans la table bienimmobilier 
	 */
	public int updateDemandeRejet(String loue_lct_id, String loue_bn_id) {
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
					"UPDATE b3_loue SET statut_demande = 'Rejeté' WHERE loue_lct_id = ? AND loue_bn_id = ?");
			ps.setString(1, loue_lct_id);
			ps.setString(2, loue_bn_id);
			

			// Execution de la requête
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			
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