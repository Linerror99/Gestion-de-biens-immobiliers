package model;

/**
 * Classe Lie
 * @author Equipe 5.2
 * @version 1.2
 * */

public class Lie  {
	
	/**
	 * référence du locataire
	 */
	private String lie_lct_id;
	
	/**
	 * référence du bailleur
	 */
	private String lie_bl_id;
	
	
	
	/**
	 * @return the lie_lct_id
	 */
	public String getLie_lct_id() {
		return lie_lct_id;
	}

	/**
	 * @param lie_lct_id the lie_lct_id to set
	 */
	public void setLie_lct_id(String lie_lct_id) {
		this.lie_lct_id = lie_lct_id;
	}

	/** 
	 * @return the lie_bl_id
	 */
	public String getLie_bl_id() {
		return lie_bl_id;
	} 

	/**
	 * @param lie_bl_id the lie_bl_id to set
	 */
	public void setLie_bl_id(String lie_bl_id) {
		this.lie_bl_id = lie_bl_id;
	}
	
	
	
	
	/**
	 * @param lie_lct_id
	 * @param lie_bl_id
	 */
	public Lie(String lie_lct_id, String lie_bl_id) {
		super();
		this.lie_lct_id = lie_lct_id;
		this.lie_bl_id = lie_bl_id;
	}
	
}
