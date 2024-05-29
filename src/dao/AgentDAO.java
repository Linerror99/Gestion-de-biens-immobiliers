package dao;
import java.sql.*;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table B3_Agent
 * 
 * @author Equipe 5.2
 * @version 2.0
 * */
public class AgentDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public AgentDAO() {
		super();
	}

	private boolean test = true; // Dis si l'ajout est fait ou non
	
	/**
	 * Permet d'ajouter un agent dans la table Agent.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param agent l'agent à ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table Agent
	 */
	public int add(Agent agent) {
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
			ps = con.prepareStatement("INSERT INTO b3_Agent VALUES(agt_id_agent_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, agent.getAgt_nom());
			ps.setString(2, agent.getAgt_prenom());
			ps.setInt(3, agent.getAgt_age());
			ps.setString(4, agent.getAgt_address());
			ps.setString(5, agent.getAgt_adresseMail());
			ps.setString(6, agent.getAgt_id());
			ps.setString(7, agent.getAgt_mdp());
			ps.setString(8, agent.getAgt_codeagent());
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001")) {
				JOptionPane.showMessageDialog(new JFrame(), "Ce agent existe déjà. Ajout impossible !", "Erreur",
						JOptionPane.ERROR_MESSAGE);
				test = false;
			}
				 
			else if( e.getMessage().contains("ORA-02291")) {
				JOptionPane.showMessageDialog(new JFrame(), "Erreur avec le code agent !", "Erreur",
						JOptionPane.ERROR_MESSAGE); 
				test = false;
			}	
			else {
				test = true;
				e.printStackTrace();
				JOptionPane.showMessageDialog(new JFrame(), "Inscription réussie", "Inscription",
						JOptionPane.DEFAULT_OPTION);
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
	 * Permet de trouver l'identifiant de l'utilisateur et comparer le mot de passe
	 * 
	 * @param agent qui veut se connecter
	 * @return boolean qui dit si la connexion est reussie ou non
	 */
	public boolean connexion(Agent agent) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Agent returnValue = null;
		boolean fin = false ;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT agt_id, agt_mdp, agt_codeagent FROM b3_agent WHERE agt_id = ?");
			ps.setString(1, agent.getAgt_id());

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Agent(rs.getString("agt_id"), rs.getString("agt_mdp"), rs.getString("agt_codeagent"));

				if (agent.getAgt_id().equals(returnValue.getAgt_id())) {
					if (agent.getAgt_mdp().equals(returnValue.getAgt_mdp())) {
						if (agent.getAgt_codeagent().equals(returnValue.getAgt_codeagent())) {
							JOptionPane.showMessageDialog(new JFrame(), "Connecté(e) avec succès", "Connexion",
									JOptionPane.DEFAULT_OPTION);
							fin = true;
						} else {
							JOptionPane.showMessageDialog(new JFrame(), "Code d'agent invalide", "Erreur de code d'agent",
									JOptionPane.ERROR_MESSAGE);
							fin = false;
						}
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Mot de passe erroné", "Erreur de mot de passe",
								JOptionPane.ERROR_MESSAGE);
						fin = false;
					}
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
	 * Permet de trouver un agent a partir de son identifiant personnel
	 * 
	 * @param agt_id permet de retrouver l' agent a recuperer
	 * @return l' agent trouve;
	 * 			null si aucun agent ne correspond a cette reference
	 */	
	public Agent get(String agt_id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Agent returnValue = null;

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement(
					"SELECT agt_id_agent, agt_nom, agt_prenom, agt_age, agt_adresse, agt_adressemail, agt_id, agt_mdp, agt_codeagent FROM b3_agent WHERE agt_id = ?");
			ps.setString(1, agt_id);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Agent(rs.getString("agt_id_agent"),
						rs.getString("agt_nom"),
					       rs.getString("agt_prenom"),
					       rs.getInt("agt_age"),
					       rs.getString("agt_adresse"),
					       rs.getString("agt_adressemail"),
					       rs.getString("agt_id"),
					       rs.getString("agt_mdp"),
					       rs.getString("agt_codeagent"));
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