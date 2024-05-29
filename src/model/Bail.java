package model;
 
 
/**
* Classe Bail
* @author Equipe 5.2
* @version 1.2
* */
public class Bail {
	
	
	/**
	 * reference du bail
	 */
	private String bl_id_bail;
	
	/**
	 * date de signature du bail
	 */
	private String bl_date;
	
	/**
	 * durée du bail
	 */
	private String bl_duree;
	
	/**
	 * date de fin du bail
	 */
	private String bl_date_fin;
	
	/**
	 * montant du loyer � payer
	 */
	private double bl_loyer;
	
	/**
	 * montant des charges � payer
	 */
	private double bl_charge;
	
	/**
	 * montant de la caution � payer au momant de la siganture du bail
	 */
	private double bl_caution;
	
	/**
	 * montant des frais d'agence
	 */
	private double bl_frais_agence;
	
	/**
	 * dates auxquelles le loyer doit �tre pay�
	 */
	private String bl_date_echeance;
	
	/**
	 * Présence d'un garant 
	 */
	private String bl_garant;
	
	/**
	 * id du bien lié au bail
	 */
	private String bl_bn_id;
	
	/**
	 * id du bailleur lié au bail
	 */
	private String bl_bllr_id;
	
	
	
	
	/**
	 * @return bl_id_bail
	 */
	public String getBl_id_bail() {
		return bl_id_bail;
	}
 
	/**
	 * @param bl_id_bail
	 */
	public void setBl_id_bail(String bl_id_bail) {
		this.bl_date = bl_id_bail;
	}
	
	/**
	 * @return bl_date
	 */
	public String getBl_date() {
		return bl_date;
	}
 
	/**
	 * @param bl_date
	 */
	public void setBl_date(String bl_date) {
		this.bl_date = bl_date;
	}
 
	/**
	 * @return bl_duree
	 */
	public String getBl_duree() {
		return bl_duree;
	}
 
	/**
	 * @param bl_duree
	 */
	public void setBl_duree(String bl_duree) {
		this.bl_duree = bl_duree;
	}
 
	/**
	 * @return bl_date_fin
	 */
	public String getBl_date_fin() {
		return bl_date_fin;
	}
 
	/**
	 * @param bl_date_fin
	 */
	public void setBl_date_fin(String bl_date_fin) {
		this.bl_date_fin = bl_date_fin;
	}
 
	/**
	 * @return bl_loyer
	 */
	public double getBl_loyer() {
		return bl_loyer;
	}
 
	/**
	 * @param bl_loyer
	 */
	public void setBl_loyer(double bl_loyer) {
		this.bl_loyer = bl_loyer;
	}
 
	/**
	 * @return bl_charge
	 */
	public double getBl_charge() {
		return bl_charge;
	}
 
	/**
	 * @param bl_charge
	 */
	public void setBl_charge(double bl_charge) {
		this.bl_charge = bl_charge;
	}
 
	/**
	 * @return bl_caution
	 */
	public double getBl_caution() {
		return bl_caution;
	}
 
	/**
	 * @param bl_caution
	 */
	public void setBl_caution(double bl_caution) {
		this.bl_caution = bl_caution;
	}
 
	/**
	 * @return bl_frais_agence
	 */
	public double getBl_frais_agence() {
		return bl_frais_agence;
	}
 
	/** 
	 * @param bl_frais_agence
	 */
	public void setBl_frais_agence(double bl_frais_agence) {
		this.bl_frais_agence = bl_frais_agence;
	}
 
	/**
	 * @return bl_date_echeance
	 */
	public String getBl_date_echeance() {
		return bl_date_echeance;
	}
 
	/**
	 * @param bl_date_echeance
	 */
	public void setBl_date_echeance(String bl_date_echeance) {
		this.bl_date_echeance = bl_date_echeance;
	}
 
	/**
	 * @param bl_garant
	 */
	public void setBl_garant(String bl_garant) {
		this.bl_garant = bl_garant;
	}
 
	
	/**
	 * @return bl_garant
	 */
	public String getBl_garant() {
		return bl_garant;
	}
	
	/**
	 * @return the bl_bn_id
	 */
	public String getBl_bn_id() {
		return bl_bn_id;
	}

	/**
	 * @param bl_bn_id the bl_bn_id to set
	 */
	public void setBl_bn_id(String bl_bn_id) {
		this.bl_bn_id = bl_bn_id;
	}

	/**
	 * @return the bl_bllr_id
	 */
	public String getBl_bllr_id() {
		return bl_bllr_id;
	}

	/**
	 * @param bl_bllr_id the bl_bllr_id to set
	 */
	public void setBl_bllr_id(String bl_bllr_id) {
		this.bl_bllr_id = bl_bllr_id;
	}
	
	
	
	
	/**
	 * @param bl_id_bail
	 * @param bl_date
	 * @param bl_duree
	 * @param bl_date_fin
	 * @param bl_loyer
	 * @param bl_charge
	 * @param bl_caution
	 * @param bl_frais_agence
	 * @param bl_date_echeance
	 * @param bl_garant
	 * @param bl_bn_id
	 * @param bl_bllr_id
	 */
	public Bail(String bl_id_bail, String bl_date, String bl_duree, String bl_date_fin, double bl_loyer,
			double bl_charge, double bl_caution, double bl_frais_agence, String bl_date_echeance, String bl_garant,
			String bl_bn_id, String bl_bllr_id) {
		super();
		this.bl_id_bail = bl_id_bail;
		this.bl_date = bl_date;
		this.bl_duree = bl_duree;
		this.bl_date_fin = bl_date_fin;
		this.bl_loyer = bl_loyer;
		this.bl_charge = bl_charge;
		this.bl_caution = bl_caution;
		this.bl_frais_agence = bl_frais_agence;
		this.bl_date_echeance = bl_date_echeance;
		this.bl_garant = bl_garant;
		this.bl_bn_id = bl_bn_id;
		this.bl_bllr_id = bl_bllr_id;
	}

	/**
	 * @param bl_date
	 * @param bl_duree
	 * @param bl_date_fin
	 * @param bl_loyer
	 * @param bl_charge
	 * @param bl_caution
	 * @param bl_frais_agence
	 * @param bl_date_echeance
	 * @param bl_garant
	 * @param bl_bn_id
	 * @param bl_bllr_id
	 */
	public Bail(String bl_date, String bl_duree, String bl_date_fin, double bl_loyer, double bl_charge,
			double bl_caution, double bl_frais_agence, String bl_date_echeance, String bl_garant, String bl_bn_id,
			String bl_bllr_id) {
		super();
		this.bl_date = bl_date;
		this.bl_duree = bl_duree;
		this.bl_date_fin = bl_date_fin;
		this.bl_loyer = bl_loyer;
		this.bl_charge = bl_charge;
		this.bl_caution = bl_caution;
		this.bl_frais_agence = bl_frais_agence;
		this.bl_date_echeance = bl_date_echeance;
		this.bl_garant = bl_garant;
		this.bl_bn_id = bl_bn_id;
		this.bl_bllr_id = bl_bllr_id;
	}

	/**
	 * Constructor without parameters
	 */
	public Bail() {
		super();
	}

	
	
	
}