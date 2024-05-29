package model;


/**
 * Classe Bailleur
 * @author Equipe 5.2
 * @version 1.2
 * */
public class Bailleur {
	
	/** 
	 * reference du bailleur
	 */
	private String bllr_id_bailleur;
	
	/**
	 * nom du bailleur
	 */
	private String bllr_nom;
	
	/**
	 * prenom du bailleur
	 */
	private String bllr_prenom;
	
	/** 
	 * age du bailleur
	 */
	private int bllr_age;
	
	/**
	 * adresse postale du bailleur
	 */
	private String bllr_address;		
	
	/**
	 * adresseMail du bailleur
	 */
	private String bllr_adresseMail;
	
	/**
	 * rib du bailleur
	 */
	private String bllr_id;
	
	/**
	 * mot de passe du bailleur
	 */
	private String bllr_mdp;
	
	
	
	
	/**
	 * @return the bllr_id_bailleur
	 */
	public String getBllr_id_bailleur() {
		return bllr_id_bailleur;
	}

	/**
	 * @param bllr_id_bailleur the bllr_id_bailleur to set
	 */
	public void setBllr_id_bailleur(String bllr_id_bailleur) {
		this.bllr_id_bailleur = bllr_id_bailleur;
	}

	/**
	 * @return the bllr_nom
	 */
	public String getBllr_nom() {
		return bllr_nom;
	}

	/**
	 * @param bllr_nom the bllr_nom to set
	 */
	public void setBllr_nom(String bllr_nom) {
		this.bllr_nom = bllr_nom;
	}

	/**
	 * @return the bllr_prenom
	 */
	public String getBllr_prenom() {
		return bllr_prenom;
	}

	/**
	 * @param bllr_prenom the bllr_prenom to set
	 */
	public void setBllr_prenom(String bllr_prenom) {
		this.bllr_prenom = bllr_prenom;
	}

	/**
	 * @return the bllr_age
	 */
	public int getBllr_age() {
		return bllr_age;
	}

	/**
	 * @param bllr_age the bllr_age to set
	 */
	public void setBllr_age(int bllr_age) {
		this.bllr_age = bllr_age;
	}

	/**
	 * @return the bllr_address
	 */
	public String getBllr_address() {
		return bllr_address;
	}

	/**
	 * @param bllr_address the bllr_address to set
	 */
	public void setBllr_address(String bllr_address) {
		this.bllr_address = bllr_address;
	}

	/**
	 * @return the bllr_adresseMail
	 */
	public String getBllr_adresseMail() {
		return bllr_adresseMail;
	}

	/**
	 * @param bllr_adresseMail the bllr_adresseMail to set
	 */
	public void setBllr_adresseMail(String bllr_adresseMail) {
		this.bllr_adresseMail = bllr_adresseMail;
	}

	/**
	 * @return the bllr_id
	 */
	public String getBllr_id() {
		return bllr_id;
	}

	/**
	 * @param bllr_id the bllr_id to set
	 */
	public void setBllr_id(String bllr_id) {
		this.bllr_id = bllr_id;
	}

	/**
	 * @return the bllr_mdp
	 */
	public String getBllr_mdp() {
		return bllr_mdp;
	}

	/**
	 * @param bllr_mdp the bllr_mdp to set
	 */
	public void setBllr_mdp(String bllr_mdp) {
		this.bllr_mdp = bllr_mdp;
	}

	
	
	
	/**
	 * @param bllr_id_bailleur
	 * @param bllr_nom
	 * @param bllr_prenom
	 * @param bllr_age
	 * @param bllr_address
	 * @param bllr_adresseMail
	 * @param bllr_id
	 * @param bllr_mdp
	 */
	public Bailleur(String bllr_id_bailleur, String bllr_nom, String bllr_prenom, int bllr_age, String bllr_address,
			String bllr_adresseMail, String bllr_id, String bllr_mdp) {
		super();
		this.bllr_id_bailleur = bllr_id_bailleur;
		this.bllr_nom = bllr_nom;
		this.bllr_prenom = bllr_prenom;
		this.bllr_age = bllr_age;
		this.bllr_address = bllr_address;
		this.bllr_adresseMail = bllr_adresseMail;
		this.bllr_id = bllr_id;
		this.bllr_mdp = bllr_mdp;
	}

	/**
	 * @param bllr_nom
	 * @param bllr_prenom
	 * @param bllr_age
	 * @param bllr_address
	 * @param bllr_adresseMail
	 * @param bllr_id
	 * @param bllr_mdp
	 */
	public Bailleur( String bllr_nom, String bllr_prenom, int bllr_age, String bllr_address,
			String bllr_adresseMail, String bllr_id, String bllr_mdp) {
		super();
		this.bllr_nom = bllr_nom;
		this.bllr_prenom = bllr_prenom;
		this.bllr_age = bllr_age;
		this.bllr_address = bllr_address;
		this.bllr_adresseMail = bllr_adresseMail;
		this.bllr_id = bllr_id;
		this.bllr_mdp = bllr_mdp;
	}

	/**
	 * @param bllr_id
	 * @param bllr_mdp
	 */
	public Bailleur(String bllr_id, String bllr_mdp) {
		super();
		this.bllr_id = bllr_id;
		this.bllr_mdp = bllr_mdp;
	}

	/**
	 * @param bllr_id
	 * @param bllr_nom
	 * @param bllr_prenom
	 */
	public Bailleur(  String bllr_id, String bllr_nom, String bllr_prenom) {
		super();
		this.bllr_id = bllr_id;
		this.bllr_nom = bllr_nom;
		this.bllr_prenom = bllr_prenom;
	}
}
