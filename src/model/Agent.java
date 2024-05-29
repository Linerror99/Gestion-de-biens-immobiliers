package model;


/**
 * Classe Agent
 * @author Equipe 5.2
 * @version 1.2
 * */
public class Agent {
	/** 
	 * reference du agent
	 */
	private String agt_id_agent;
	
	/**
	 * nom du agent
	 */
	private String agt_nom;
	
	/**
	 * prenom du agent
	 */
	private String agt_prenom;
	
	/** 
	 * age du agent
	 */
	private int agt_age;
	
	/**
	 * adresse postale du agent
	 */
	private String agt_address;		
	
	/**
	 * adresseMail de l'agent
	 */
	private String agt_adresseMail;
	
	/**
	 * rib de l' agent
	 */
	
	private String agt_id;
	
	/**
	 * mot de passe de l' agent
	 */
	private String agt_mdp;
	
	/**
	 * code de l' agent
	 */
	private String agt_codeagent;
	
	
	
	
	/**
	 * @return the agt_id_agent
	 */
	public String getAgt_id_agent() {
		return agt_id_agent;
	}

	/**
	 * @param agt_id_agent the agt_id_agent to set
	 */
	public void setAgt_id_agent(String agt_id_agent) {
		this.agt_id_agent = agt_id_agent;
	}

	/**
	 * @return the agt_nom
	 */
	public String getAgt_nom() {
		return agt_nom;
	}

	/**
	 * @param agt_nom the agt_nom to set
	 */
	public void setAgt_nom(String agt_nom) {
		this.agt_nom = agt_nom;
	}

	/**
	 * @return the agt_prenom
	 */
	public String getAgt_prenom() {
		return agt_prenom;
	}

	/**
	 * @param agt_prenom the agt_prenom to set
	 */
	public void setAgt_prenom(String agt_prenom) {
		this.agt_prenom = agt_prenom;
	}

	/**
	 * @return the agt_age
	 */
	public int getAgt_age() {
		return agt_age;
	}

	/**
	 * @param agt_age the agt_age to set
	 */
	public void setAgt_age(int agt_age) {
		this.agt_age = agt_age;
	}

	/**
	 * @return the agt_address
	 */
	public String getAgt_address() {
		return agt_address;
	}

	/**
	 * @param agt_address the agt_address to set
	 */
	public void setAgt_address(String agt_address) {
		this.agt_address = agt_address;
	}

	/**
	 * @return the agt_adresseMail
	 */
	public String getAgt_adresseMail() {
		return agt_adresseMail;
	}

	/**
	 * @param agt_adresseMail the agt_adresseMail to set
	 */
	public void setAgt_adresseMail(String agt_adresseMail) {
		this.agt_adresseMail = agt_adresseMail;
	}

	/**
	 * @return the agt_id
	 */
	public String getAgt_id() {
		return agt_id;
	}

	/**
	 * @param agt_id the agt_id to set
	 */
	public void setAgt_id(String agt_id) {
		this.agt_id = agt_id;
	}

	/**
	 * @return the agt_mdp
	 */
	public String getAgt_mdp() {
		return agt_mdp;
	}

	/**
	 * @param agt_mdp the agt_mdp to set
	 */
	public void setAgt_mdp(String agt_mdp) {
		this.agt_mdp = agt_mdp;
	}
	
	
	/**
	 * @return the agt_codeagent
	 */
	public String getAgt_codeagent() {
		return agt_codeagent;
	}
	
	/**
	 * @param agt_codeagent the agt_codeagent to set
	 */
	public void setAgt_codeagent(String agt_codeagent) {
		this.agt_codeagent = agt_codeagent;
	}

	
	
	
	
	/**
	 * @param agt_id_agent
	 * @param agt_nom
	 * @param agt_prenom
	 * @param agt_age
	 * @param agt_address
	 * @param agt_adresseMail
	 * @param agt_id
	 * @param agt_mdp
	 * @param agt_codeagent
	 */
	public Agent(String agt_id_agent, String agt_nom, String agt_prenom, int agt_age, String agt_address,
			String agt_adresseMail, String agt_id, String agt_mdp, String agt_codeagent) {
		super();
		this.agt_id_agent = agt_id_agent;
		this.agt_nom = agt_nom;
		this.agt_prenom = agt_prenom;
		this.agt_age = agt_age;
		this.agt_address = agt_address;
		this.agt_adresseMail = agt_adresseMail;
		this.agt_id = agt_id;
		this.agt_mdp = agt_mdp;
		this.agt_codeagent = agt_codeagent;
	}

	/**
	 * @param agt_nom
	 * @param agt_prenom
	 * @param agt_age
	 * @param agt_address
	 * @param agt_adresseMail
	 * @param agt_id
	 * @param agt_mdp
	 * @param agt_codeagent
	 */
	public Agent( String agt_nom, String agt_prenom, int agt_age, String agt_address,
			String agt_adresseMail, String agt_id, String agt_mdp,String agt_codeagent ) {
		super();
		this.agt_nom = agt_nom;
		this.agt_prenom = agt_prenom;
		this.agt_age = agt_age;
		this.agt_address = agt_address;
		this.agt_adresseMail = agt_adresseMail;
		this.agt_id = agt_id;
		this.agt_mdp = agt_mdp;
		this.agt_codeagent = agt_codeagent ;
	}

	/**
	 * @param agt_id
	 * @param agt_mdp
	 * @param agt_codeagent
	 */
	public Agent(String agt_id, String agt_mdp , String agt_codeagent) {
		super();
		this.agt_id = agt_id;
		this.agt_mdp = agt_mdp;
		this.agt_codeagent = agt_codeagent ;
	}

	/**
	 * Constructor
	 * @param agt_nom
	 * @param agt_prenom
	 * @param agt_id
	 * @param agt_mdp
	 */
	public Agent(String agt_nom, String agt_prenom, String agt_id, String agt_mdp) {
		super();
		this.agt_nom = agt_nom;
		this.agt_prenom = agt_prenom;
		this.agt_id = agt_id;
		this.agt_mdp = agt_mdp;
	}

}
