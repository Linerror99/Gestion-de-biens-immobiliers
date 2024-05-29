package model;

/**
* Classe Associe
* @author Equipe 5.2
* @version 1.2
* */

public class Associe {
	
	/**
	 * référence du bailleur
	 */
	private String asso_bl_id;
	
	/**
	 * référence du locataire
	 */
	private String asso_lct_id;
	
	/**
	 * statut de la demande de logement
	 */
	private String statut_bl;
	
	
	
	
	
	
	
	/**
	 * @return the asso_bl_id
	 */
	public String getAsso_bl_id() {
		return asso_bl_id;
	}

	/**
	 * @param asso_bl_id the asso_bl_id to set
	 */
	public void setAsso_bl_id(String asso_bl_id) {
		this.asso_bl_id = asso_bl_id;
	}

	/**
	 * @return the asso_lct_id
	 */
	public String getAsso_lct_id() {
		return asso_lct_id;
	}

	/**
	 * @param asso_lct_id the asso_lct_id to set
	 */
	public void setAsso_lct_id(String asso_lct_id) {
		this.asso_lct_id = asso_lct_id;
	}

	/**
	 * @return the statut_bl
	 */
	public String getStatut_bl() {
		return statut_bl;
	}

	/**
	 * @param statut_bl the statut_bl to set
	 */
	public void setStatut_bl(String statut_bl) {
		this.statut_bl = statut_bl;
	}
	
	
	
	
	
	
	
	
	/**
	 * @param asso_bl_id
	 * @param asso_lct_id
	 * @param statut_bl
	 */
	public Associe(String asso_bl_id, String asso_lct_id, String statut_bl) {
		super();
		this.asso_bl_id = asso_bl_id;
		this.asso_lct_id = asso_lct_id;
		this.statut_bl = statut_bl;
	}

	/**
	 * @param asso_bl_id
	 * @param asso_lct_id
	 */
	public Associe(String asso_bl_id, String asso_lct_id) {
		super();
		this.asso_bl_id = asso_bl_id;
		this.asso_lct_id = asso_lct_id;
	}
}
