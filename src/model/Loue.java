package model;

/**
 * Classe Loue
 * @author Equipe 5.2
 * @version 1.2
 * */

public class Loue {
	
	/**
	 * référence du locataire
	 */
	private String loue_lct_id;
	
	/**
	 * référence du bien immobilier
	 */
	private String loue_bn_id;
	
	/**
	 * statutu de la demande de bien immobilier
	 */
	private String statut_demande;
	
	
	
	/**
	 * @return the loue_lct_id
	 */
	public String getLoue_lct_id() {
		return loue_lct_id;
	}

	/**
	 * @param loue_lct_id the loue_lct_id to set
	 */
	public void setLoue_lct_id(String loue_lct_id) {
		this.loue_lct_id = loue_lct_id;
	}

	/**
	 * @return the loue_bn_id
	 */
	public String getLoue_bn_id() {
		return loue_bn_id;
	}

	/**
	 * @param loue_bn_id the loue_bn_id to set
	 */
	public void setLoue_bn_id(String loue_bn_id) {
		this.loue_bn_id = loue_bn_id;
	}

	/**
	 * @return the statut_demande
	 */
	public String getStatut_demande() {
		return statut_demande;
	}

	/**
	 * @param statut_demande the statut_demande to set
	 */
	public void setStatut_demande(String statut_demande) {
		this.statut_demande = statut_demande;
	}
	
	
	
	/**
	 * @param loue_lct_id
	 * @param loue_bn_id
	 * @param statut_demande
	 */
	public Loue(String loue_lct_id, String loue_bn_id, String statut_demande) {
		super();
		this.loue_lct_id = loue_lct_id;
		this.loue_bn_id = loue_bn_id;
		this.statut_demande = statut_demande;
	}

	/**
	 * @param loue_lct_id
	 * @param loue_bn_id
	 */
	public Loue(String loue_lct_id, String loue_bn_id) {
		super();
		this.loue_lct_id = loue_lct_id;
		this.loue_bn_id = loue_bn_id;
	}

}
