package model;


/**
 * Classe BienImmobilier
 * @author Equipe 5.2
 * @version 1.2
 * */
public class BienImmobilier {
	
	/**
	 * Id généré du bienImmobilier
	 */
	private String bn_id_bien;
	
	/**
	 * adresse du bienImmobilier
	 */
	private String bn_adresse;
	
	/** 
	 * nombredepiece du bienImmobilier
	 */
	private int bn_nombredepiece;
	
	/**
	 * meuble du bienImmobilier
	 */
	private String bn_meuble;		
	
	/**
	 * année de construction du bienImmobilier
	 */
	private int bn_anneedeconstruction;
	
	/**
	 * type de chauffage du bienImmobilier
	 */
	private String bn_typedechauffage;
	
	/**
	 * statut du bienImmobilier
	 */
	private String bn_statut;
	
	/**
	 * loyer du bienImmobilier
	 */
	private double bn_loyer;
	
	/**
	 * charges du bienImmobilier
	 */
	private double bn_charges;
	
	/**
	 * caution du bienImmobilier
	 */
	private double bn_caution;
	
	/**
	 * id du bailleur du bienImmobilier
	 */
	private String bn_bllr_id;
	
	
	
	/**
	 * @return the bn_id_bien
	 */
	public String getBn_id_bien() {
		return bn_id_bien;
	}

	/**
	 * @param bn_id_bien the bn_id_bien to set
	 */
	public void setBn_id_bien(String bn_id_bien) {
		this.bn_id_bien = bn_id_bien;
	}

	/**
	 * @return the bn_adresse
	 */
	public String getBn_adresse() {
		return bn_adresse;
	}

	/**
	 * @param bn_adresse the bn_adresse to set
	 */
	public void setBn_adresse(String bn_adresse) {
		this.bn_adresse = bn_adresse;
	}

	/**
	 * @return the bn_nombredepiece
	 */
	public int getBn_nombredepiece() {
		return bn_nombredepiece;
	}

	/**
	 * @param bn_nombredepiece the bn_nombredepiece to set
	 */
	public void setBn_nombredepiece(int bn_nombredepiece) {
		this.bn_nombredepiece = bn_nombredepiece;
	}

	/**
	 * @return the bn_meuble
	 */
	public String getBn_meuble() {
		return bn_meuble;
	}

	/**
	 * @param bn_meuble the bn_meuble to set
	 */
	public void setBn_meuble(String bn_meuble) {
		this.bn_meuble = bn_meuble;
	}

	/**
	 * @return the bn_anneedeconstruction
	 */
	public int getBn_anneedeconstruction() {
		return bn_anneedeconstruction;
	}

	/**
	 * @param bn_anneedeconstruction the bn_anneedeconstruction to set
	 */
	public void setBn_anneedeconstruction(int bn_anneedeconstruction) {
		this.bn_anneedeconstruction = bn_anneedeconstruction;
	}

	/**
	 * @return the bn_typedechauffage
	 */
	public String getBn_typedechauffage() {
		return bn_typedechauffage;
	}

	/**
	 * @param bn_typedechauffage the bn_typedechauffage to set
	 */
	public void setBn_typedechauffage(String bn_typedechauffage) {
		this.bn_typedechauffage = bn_typedechauffage;
	}
	
	/**
	 * @return the bn_statut
	 */
	public String getBn_statut() {
		return bn_statut;
	}

	/**
	 * @param bn_statut the bn_statut to set
	 */
	public void setBn_statut(String bn_statut) {
		this.bn_statut = bn_statut;
	}
	
	/**
	 * @return the bn_loyer
	 */
	public double getBn_loyer() {
		return bn_loyer;
	}

	/**
	 * @param bn_loyer the bn_loyer to set
	 */
	public void setBn_loyer(double bn_loyer) {
		this.bn_loyer = bn_loyer;
	}

	/**
	 * @return the bn_charges
	 */
	public double getBn_charges() {
		return bn_charges;
	}

	/**
	 * @param bn_charges the bn_charges to set
	 */
	public void setBn_charges(double bn_charges) {
		this.bn_charges = bn_charges;
	}

	/**
	 * @return the bn_caution
	 */
	public double getBn_caution() {
		return bn_caution;
	}

	/**
	 * @param bn_caution the bn_caution to set
	 */
	public void setBn_caution(double bn_caution) {
		this.bn_caution = bn_caution;
	}

	/**
	 * @return the bn_bllr_id
	 */
	public String getBn_bllr_id() {
		return bn_bllr_id;
	}

	/**
	 * @param bn_bllr_id the bn_bllr_id to set
	 */
	public void setBn_bllr_id(String bn_bllr_id) {
		this.bn_bllr_id = bn_bllr_id;
	}

	
	
	/**
	 * @param bn_adresse
	 * @param bn_nombredepiece
	 * @param bn_meuble
	 * @param bn_anneedeconstruction
	 * @param bn_typedechauffage
	 * @param bn_statut
	 * @param bn_loyer
	 * @param bn_charges
	 * @param bn_caution
	 * @param bn_bllr_id
	 */
	public BienImmobilier(String bn_adresse, int bn_nombredepiece, String bn_meuble, int bn_anneedeconstruction,
			String bn_typedechauffage, double bn_loyer, double bn_charges, double bn_caution,
			String bn_bllr_id) {
		super();
		this.bn_adresse = bn_adresse;
		this.bn_nombredepiece = bn_nombredepiece;
		this.bn_meuble = bn_meuble;
		this.bn_anneedeconstruction = bn_anneedeconstruction;
		this.bn_typedechauffage = bn_typedechauffage;
		this.bn_statut = "En attente";
		this.bn_loyer = bn_loyer;
		this.bn_charges = bn_charges;
		this.bn_caution = bn_caution;
		this.bn_bllr_id = bn_bllr_id;
	}


	/**
	 * @param bn_adresse
	 * @param bn_nombredepiece
	 * @param bn_meuble
	 * @param bn_anneedeconstruction
	 * @param bn_typedechauffage
	 * @param bn_statut
	 * @param bn_loyer
	 * @param bn_charges
	 * @param bn_caution
	 * @param bn_bllr_id
	 */
	public BienImmobilier(String bn_adresse, int bn_nombredepiece, String bn_meuble, int bn_anneedeconstruction,
			String bn_typedechauffage, String bn_statut, double bn_loyer, double bn_charges, double bn_caution,
			String bn_bllr_id) {
		super();
		this.bn_adresse = bn_adresse;
		this.bn_nombredepiece = bn_nombredepiece;
		this.bn_meuble = bn_meuble;
		this.bn_anneedeconstruction = bn_anneedeconstruction;
		this.bn_typedechauffage = bn_typedechauffage;
		this.bn_statut = bn_statut;
		this.bn_loyer = bn_loyer;
		this.bn_charges = bn_charges;
		this.bn_caution = bn_caution;
		this.bn_bllr_id = bn_bllr_id;
	}

	/**
	 * Constructor without parameter
	 */
	public BienImmobilier() {
		super();
	}

	@Override
	public String toString() {
		return "BienImmobilier [bn_id_bien=" + bn_id_bien + ", bn_adresse=" + bn_adresse + ", bn_nombredepiece="
				+ bn_nombredepiece + ", bn_meuble=" + bn_meuble + ", bn_anneedeconstruction=" + bn_anneedeconstruction
				+ ", bn_typedechauffage=" + bn_typedechauffage + ", bn_statut=" + bn_statut + ", bn_loyer=" + bn_loyer
				+ ", bn_charges=" + bn_charges + ", bn_caution=" + bn_caution + ", bn_bllr_id=" + bn_bllr_id + "]";
	}
	
}
