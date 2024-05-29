package dao;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table B3_Maison
 * 
 * @author Equipe 5.2
 * @version 2.0
 * */
public class MaisonDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public MaisonDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un bien dans la table bien et dans la table maison. 
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param maison est ajouté à maison et bien immobilier
	 * @return retourne le nombre de lignes ajoutees dans les tables
	 */
	public int add(Maison maison) {
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
			ps.setString(1, maison.getBn_adresse());
			ps.setInt(2, maison.getBn_nombredepiece());
			ps.setString(3, maison.getBn_meuble());
			ps.setInt(4, maison.getBn_anneedeconstruction());
			ps.setString(5, maison.getBn_typedechauffage());
			ps.setString(6, maison.getBn_statut());
			ps.setDouble(7, maison.getBn_loyer());
			ps.setDouble(8, maison.getBn_charges());
			ps.setDouble(9, maison.getBn_caution());
			ps.setString(10, maison.getBn_bllr_id());

			// Execution de la requête
			returnValue = ps.executeUpdate();

			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps1 = con.prepareStatement("INSERT INTO b3_maison VALUES(BN_ID_MSN_SEQ.currval, ?, ?, ?)");
			ps1.setString(1, maison.getMsn_cave());
			ps1.setString(2, maison.getMsn_terasse());
			ps1.setString(3, maison.getMsn_jardin());

			// Execution de la requete
			returnValue += ps1.executeUpdate();

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
	 * Permet de recuperer les infos à afficher de la table maison 
	 * et les retourne
	 * 
	 * @param bn_id_bien de la maison recherchee
	 * @return une  maison à partir de son id de la database
	 */
	public Maison getMaison(String bn_id_bien) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Maison returnValue = new Maison();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT Bn_adresse, Bn_nombredepiece, Bn_meuble, Bn_anneedeconstruction, bn_typedechauffage, bn_statut,Bn_loyer,Bn_charges,Bn_caution, Bn_bllr_id, Msn_cave,Msn_terrasse, Msn_jardin, msn_id_maison "
							+ "					FROM b3_bienimmobilier " + "					INNER JOIN b3_maison "
							+ "					ON b3_bienimmobilier.bn_id_bien = b3_maison.msn_id_maison "
							+ "					WHERE bn_id_bien = ?");
			ps.setString(1, bn_id_bien);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				 returnValue =
						new Maison(rs.getString("Bn_adresse"), rs.getInt("Bn_nombredepiece"), rs.getString("Bn_meuble"),
								rs.getInt("Bn_anneedeconstruction"), rs.getString("bn_typedechauffage"),
								rs.getString("Bn_statut"), rs.getDouble("Bn_loyer"), rs.getDouble("Bn_charges"),
								rs.getDouble("Bn_caution"), rs.getString("Bn_bllr_id"), rs.getString("msn_id_maison"),
								rs.getString("Msn_cave"), rs.getString("Msn_terrasse"), rs.getString("Msn_jardin"));
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
	 * Permet de recuperer toutes les infos à afficher des tables maison et bien immobilier
	 * et les retourne
	 * 
	 * @return une ArrayList de toutes les maisons
	 */
	public static ArrayList<Maison> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Maison> returnValue = new ArrayList<Maison>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT Bn_adresse, Bn_nombredepiece, Bn_meuble, Bn_anneedeconstruction, bn_typedechauffage, bn_statut,bn_loyer, bn_charges,bn_caution,Bn_bllr_id, Msn_cave,Msn_terrasse, Msn_jardin, msn_id_maison "
							+ "					FROM b3_bienimmobilier " + "					INNER JOIN b3_maison "
							+ "					ON b3_bienimmobilier.bn_id_bien = b3_maison.msn_id_maison "
							+ "					ORDER BY bn_id_bien ");

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(
						new Maison(rs.getString("Bn_adresse"), rs.getInt("Bn_nombredepiece"), rs.getString("Bn_meuble"),
								rs.getInt("Bn_anneedeconstruction"), rs.getString("bn_typedechauffage"),
								rs.getString("Bn_statut"), rs.getDouble("Bn_loyer"), rs.getDouble("Bn_charges"),
								rs.getDouble("Bn_caution"), rs.getString("Bn_bllr_id"), rs.getString("msn_id_maison"),
								rs.getString("Msn_cave"), rs.getString("Msn_terrasse"), rs.getString("Msn_jardin")));
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
	 * Permet de recuperer toutes les infos à afficher des tables maison et bien immobilier
	 * et les retourne
	 * 
	 * @param bllr_id_bailleur dont on recherche les maisons 
	 * @return une ArrayList de toutes les maisons liées à un bailleur spécifique
	 */
	public static ArrayList<Maison> getListbailleur(String bllr_id_bailleur) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Maison> returnValue = new ArrayList<Maison>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT Bn_adresse, Bn_nombredepiece, Bn_meuble, Bn_anneedeconstruction, bn_typedechauffage, bn_statut,Bn_loyer,Bn_charges,Bn_caution, Bn_bllr_id, Msn_cave,Msn_terrasse, Msn_jardin, msn_id_maison "
							+ "					FROM b3_bienimmobilier " + "					INNER JOIN b3_maison "
							+ "					ON b3_bienimmobilier.bn_id_bien = b3_maison.msn_id_maison "
							+ "					WHERE bn_bllr_id = ?" + "					ORDER BY bn_id_bien ");
			ps.setString(1, bllr_id_bailleur);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(
						new Maison(rs.getString("Bn_adresse"), rs.getInt("Bn_nombredepiece"), rs.getString("Bn_meuble"),
								rs.getInt("Bn_anneedeconstruction"), rs.getString("bn_typedechauffage"), 
								rs.getString("Bn_statut"), rs.getDouble("Bn_loyer"), rs.getDouble("Bn_charges"),
								rs.getDouble("Bn_caution"), rs.getString("Bn_bllr_id"), rs.getString("msn_id_maison"),
								rs.getString("Msn_cave"), rs.getString("Msn_terrasse"), rs.getString("Msn_jardin")));
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
	 * Permet de recuperer les infos à afficher des tables maison et bien immobilier
	 * et les retourne
	 * 
	 * @return une ArrayList de maisons à statut "Validé"
	 */
	public static ArrayList<Maison> getListValide() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Maison> returnValue = new ArrayList<Maison>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT Bn_adresse, Bn_nombredepiece, Bn_meuble, Bn_anneedeconstruction, bn_typedechauffage, bn_statut,Bn_loyer,Bn_charges,Bn_caution, Bn_bllr_id, Msn_cave,Msn_terrasse, Msn_jardin, msn_id_maison "
							+ "					FROM b3_bienimmobilier " + "					INNER JOIN b3_maison "
							+ "						ON b3_bienimmobilier.bn_id_bien = b3_maison.msn_id_maison "
							+ "					WHERE bn_statut =  'Validé'"
							+ "					ORDER BY bn_id_bien ");

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(
						new Maison(rs.getString("Bn_adresse"), rs.getInt("Bn_nombredepiece"), rs.getString("Bn_meuble"),
								rs.getInt("Bn_anneedeconstruction"), rs.getString("bn_typedechauffage"),
								rs.getString("Bn_statut"), rs.getDouble("Bn_loyer"), rs.getDouble("Bn_charges"),
								rs.getDouble("Bn_caution"), rs.getString("Bn_bllr_id"), rs.getString("msn_id_maison"),
								rs.getString("Msn_cave"), rs.getString("Msn_terrasse"), rs.getString("Msn_jardin")));
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
	 * @param msn_id_maison id de la maison 
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int updateStatutRejet(String msn_id_maison) {
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
			ps.setString(1, msn_id_maison);

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
	 * @param msn_id_maison id de la maison 
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int updateStatutValide(String msn_id_maison) {
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
			ps.setString(1, msn_id_maison);

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
	 * @param msn_id_maison id de la maison 
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int updateStatutAttente(String msn_id_maison) {
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
			ps.setString(1, msn_id_maison);

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
	 * @return retourne le nombre de lignes ajoutees dans la table
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
	 * @return retourne le nombre de lignes modifiées dans la table
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
	 * @return retourne le nombre de lignes modifiées dans la table
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
	 * Permet de mettre la demande en "Rejeté" 
	 * 
	 * @param loue_lct_id id du locataire
	 * @param loue_bn_id id du bien 
	 * @return retourne le nombre de lignes modifiées dans la table
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
	
	
	/**
	 * Permet de savoir si l'idée du bien est une maison 
	 * 
	 * @param bn_id_bien de la maison recherchee
	 * @return un string "maison"
	 */
	public String ifMaison(String msn_id_maison) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String returnValue = new String();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT msn_id_maison FROM b3_maison WHERE msn_id_maison = ?");
			ps.setString(1, msn_id_maison);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			if(rs == null) {
				returnValue = "Appartement";
			}else{
				returnValue = "Maison";
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