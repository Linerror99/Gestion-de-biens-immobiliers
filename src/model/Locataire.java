package model;


/**
 * Classe Locataire
 * @author Equipe 5.2
 * @version 1.2
 * */
public class Locataire {
	
	/** 
	 * reference du locataire
	 */
	private String lct_id_locataire;
	
	/**
	 * nom du locataire
	 */
	private String lct_nom;
	
	/**
	 * prenom du locataire
	 */
	private String lct_prenom;
	
	/** 
	 * age du locataire
	 */
	private int lct_age;
	
	/**
	 * adresse postale du locataire
	 */
	private String lct_address;		
	
	/**
	 * adresseMail du locataire
	 */
	private String lct_adresseMail;
	
	/**
	 * rib du locataire
	 */
	private String lct_rib;
	
	/**
	 * identifiant du locataire
	 */
	private String lct_id;
	
	/**
	 * mot de passe du locataire
	 */
	private String lct_mdp;
	
	
	
	
	/**
	 * @return the lct_id_locataire
	 */
	public String getLct_id_locataire() {
		return lct_id_locataire;
	}

	/**
	 * @param lct_id_locataire the lct_id_locataire to set
	 */
	public void setLct_id_locataire(String lct_id_locataire) {
		this.lct_id_locataire = lct_id_locataire;
	}

	/**
	 * @return the lct_nom
	 */
	public String getLct_nom() {
		return lct_nom;
	}

	/**
	 * @param lct_nom the lct_nom to set
	 */
	public void setLct_nom(String lct_nom) {
		this.lct_nom = lct_nom;
	}

	/**
	 * @return the lct_prenom
	 */
	public String getLct_prenom() {
		return lct_prenom;
	}

	/**
	 * @param lct_prenom the lct_prenom to set
	 */
	public void setLct_prenom(String lct_prenom) {
		this.lct_prenom = lct_prenom;
	}

	/**
	 * @return the lct_age
	 */
	public int getLct_age() {
		return lct_age;
	}

	/**
	 * @param lct_age the lct_age to set
	 */
	public void setLct_age(int lct_age) {
		this.lct_age = lct_age;
	}

	/**
	 * @return the lct_address
	 */
	public String getLct_address() {
		return lct_address;
	}

	/**
	 * @param lct_address the lct_address to set
	 */
	public void setLct_address(String lct_address) {
		this.lct_address = lct_address;
	}

	/**
	 * @return the lct_adresseMail
	 */
	public String getLct_adresseMail() {
		return lct_adresseMail;
	}

	/**
	 * @param lct_adresseMail the lct_adresseMail to set
	 */
	public void setLct_adresseMail(String lct_adresseMail) {
		this.lct_adresseMail = lct_adresseMail;
	}

	/**
	 * @return the lct_id
	 */
	public String getLct_id() {
		return lct_id;
	}

	/**
	 * @param lct_id the lct_id to set
	 */
	public void setLct_id(String lct_id) {
		this.lct_id = lct_id;
	}

	/**
	 * @return the lct_mdp
	 */
	public String getLct_mdp() {
		return lct_mdp;
	}

	/**
	 * @param lct_mdp the lct_mdp to set
	 */
	public void setLct_mdp(String lct_mdp) {
		this.lct_mdp = lct_mdp;
	}
	
	/**
	 * @return the rib
	 */
	public String getLct_Rib() {
		return lct_rib;
	}

	/**
	 * @param lct_rib the rib to set
	 */
	public void setLct_Rib(String lct_rib) {
		this.lct_rib = lct_rib;
	}
	
	
	
	/**
	 * @param lct_id_locataire
	 * @param lct_nom
	 * @param lct_prenom
	 * @param lct_age
	 * @param lct_address
	 * @param lct_adresseMail
	 * @param lct_rib
	 * @param lct_id
	 * @param lct_mdp
	 */
	public Locataire(String lct_id_locataire, String lct_nom, String lct_prenom, int lct_age, String lct_address,
			String lct_adresseMail, String lct_rib, String lct_id, String lct_mdp) {
		super();
		this.lct_id_locataire = lct_id_locataire;
		this.lct_nom = lct_nom;
		this.lct_prenom = lct_prenom;
		this.lct_age = lct_age;
		this.lct_address = lct_address;
		this.lct_adresseMail = lct_adresseMail;
		this.lct_rib = lct_rib;
		this.lct_id = lct_id;
		this.lct_mdp = lct_mdp;
	}

	/**
	 * @param lct_nom
	 * @param lct_prenom
	 * @param lct_age
	 * @param lct_address
	 * @param lct_adresseMail
	 * @param lct_id
	 * @param lct_mdp
	 * @param lct_rib
	 */
	public Locataire( String lct_nom, String lct_prenom, int lct_age, String lct_address,
			String lct_adresseMail, String lct_id, String lct_mdp, String lct_rib) {
		super();
		this.lct_nom = lct_nom;
		this.lct_prenom = lct_prenom;
		this.lct_age = lct_age;
		this.lct_address = lct_address;
		this.lct_adresseMail = lct_adresseMail;
		this.lct_id = lct_id;
		this.lct_mdp = lct_mdp;
		this.lct_rib = lct_rib;
	}

	
	/**
	 * @param lct_id
	 * @param lct_mdp
	 */
	public Locataire(String lct_id, String lct_mdp) {
		super();
		this.lct_id = lct_id;
		this.lct_mdp = lct_mdp;
	}
	
	/**
	 * @param lct_id
	 * @param lct_mdp
	 * @param lct_nom
	 * @param lct_prenom
	 */
	public Locataire(String lct_id, String lct_mdp, String lct_nom, String lct_prenom) {
		super();
		this.lct_id = lct_id;
		this.lct_mdp = lct_mdp;
		this.lct_nom = lct_nom;
		this.lct_prenom = lct_prenom;
	}
	
	
	/**
	 * @param lct_id
	 * @param lct_nom
	 * @param lct_prenom
	 */
	public Locataire(String lct_id, String lct_nom, String lct_prenom) {
		super();
		this.lct_id = lct_id;
		this.lct_nom = lct_nom;
		this.lct_prenom = lct_prenom;
	}

	

	@Override
	public String toString() {
		return "Locataire [lct_id_locataire=" + lct_id_locataire + ", lct_nom=" + lct_nom + ", lct_prenom=" + lct_prenom
				+ ", lct_age=" + lct_age + ", lct_address=" + lct_address + ", lct_adresseMail=" + lct_adresseMail
				+ ", lct_rib=" + lct_rib + ", lct_id=" + lct_id + ", lct_mdp=" + lct_mdp + "]";
	}
	
}
