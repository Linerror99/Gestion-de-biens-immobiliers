package model;

/**
* Classe Appartement
* @author Equipe 5.2
* @version 1.2
* */

public class Appartement extends BienImmobilier {

	/**
	 * Id généré de appartement
	 */
	private String app_id_appartement;
	
	/**
	 * Balcon ou terrasse de appartement
	 */
	private String app_balconouterrasse;
	
	/**
	 * numéro d'appartement de appartement
	 */
	private int app_numerodappartement;
	
	/**
	 * étage de appartement
	 */
	private int app_etage;
	
	/**
	 * type de appartement
	 */
	private String app_type;
	
	
	
	
	
	
	
	

	/**
	 * @return the app_id_appartement
	 */
	public String getApp_id_appartement() {
		return app_id_appartement;
	}

	/**
	 * @param app_id_appartement the app_id_appartement to set
	 */
	public void setApp_id_appartement(String app_id_appartement) {
		this.app_id_appartement = app_id_appartement;
	}

	/**
	 * @return the app_balconouterrasse
	 */
	public String getApp_balconouterrasse() {
		return app_balconouterrasse;
	}

	/**
	 * @param app_balconouterrasse the app_balconouterrasse to set
	 */
	public void setApp_balconouterrasse(String app_balconouterrasse) {
		this.app_balconouterrasse = app_balconouterrasse;
	}

	/**
	 * @return the app_numerodappartement
	 */
	public int getApp_numerodappartement() {
		return app_numerodappartement;
	}

	/**
	 * @param app_numerodappartement the app_numerodappartement to set
	 */
	public void setApp_numerodappartement(int app_numerodappartement) {
		this.app_numerodappartement = app_numerodappartement;
	}

	/**
	 * @return the app_etage
	 */
	public int getApp_etage() {
		return app_etage;
	}

	/**
	 * @param app_etage the app_etage to set
	 */
	public void setApp_etage(int app_etage) {
		this.app_etage = app_etage;
	}

	/**
	 * @return the app_type
	 */
	public String getApp_type() {
		return app_type;
	}

	/**
	 * @param app_type the app_type to set
	 */
	public void setApp_type(String app_type) {
		this.app_type = app_type;
	}
	
	
	
	
	
	
	
	/**
	 * @param bn_adresse
	 * @param bn_nombredepiece
	 * @param bn_meuble
	 * @param bn_anneedeconstruction
	 * @param bn_typedechauffage
	 * @param bn_loyer
	 * @param bn_charges
	 * @param bn_caution
	 * @param bn_bllr_id
	 * @param app_id_appartement
	 * @param app_balconouterrasse
	 * @param app_numerodappartement
	 * @param app_etage
	 * @param app_type
	 */
	public Appartement(String bn_adresse, int bn_nombredepiece, String bn_meuble, int bn_anneedeconstruction,
			String bn_typedechauffage, double bn_loyer, double bn_charges, double bn_caution, String bn_bllr_id,
			String app_id_appartement, String app_balconouterrasse, int app_numerodappartement, int app_etage,
			String app_type) {
		super(bn_adresse, bn_nombredepiece, bn_meuble, bn_anneedeconstruction, bn_typedechauffage, bn_loyer, bn_charges,
				bn_caution, bn_bllr_id);
		this.app_id_appartement = app_id_appartement;
		this.app_balconouterrasse = app_balconouterrasse;
		this.app_numerodappartement = app_numerodappartement;
		this.app_etage = app_etage;
		this.app_type = app_type;
	}
	
	/**
	 * @param bn_adresse
	 * @param bn_nombredepiece
	 * @param bn_meuble
	 * @param bn_anneedeconstruction
	 * @param bn_typedechauffage
	 * @param bn_loyer
	 * @param bn_charges
	 * @param bn_caution
	 * @param bn_bllr_id
	 * @param app_balconouterrasse
	 * @param app_numerodappartement
	 * @param app_etage
	 * @param app_type
	 */
	public Appartement(String bn_adresse, int bn_nombredepiece, String bn_meuble, int bn_anneedeconstruction,
			String bn_typedechauffage, double bn_loyer, double bn_charges, double bn_caution, String bn_bllr_id,
			String app_balconouterrasse, int app_numerodappartement, int app_etage,
			String app_type) { 
		super(bn_adresse, bn_nombredepiece, bn_meuble, bn_anneedeconstruction, bn_typedechauffage, bn_loyer, bn_charges,
				bn_caution, bn_bllr_id);
		this.app_balconouterrasse = app_balconouterrasse;
		this.app_numerodappartement = app_numerodappartement;
		this.app_etage = app_etage;
		this.app_type = app_type;
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
	 * @param app_id_appartement
	 * @param app_balconouterrasse
	 * @param app_numerodappartement
	 * @param app_etage
	 * @param app_type
	 */
	public Appartement(String bn_adresse, int bn_nombredepiece, String bn_meuble, int bn_anneedeconstruction,
			String bn_typedechauffage, String bn_statut, double bn_loyer, double bn_charges, double bn_caution,
			String bn_bllr_id, String app_id_appartement, String app_balconouterrasse, int app_numerodappartement,
			int app_etage, String app_type) {
		super(bn_adresse, bn_nombredepiece, bn_meuble, bn_anneedeconstruction, bn_typedechauffage, bn_statut, bn_loyer,
				bn_charges, bn_caution, bn_bllr_id);
		this.app_id_appartement = app_id_appartement;
		this.app_balconouterrasse = app_balconouterrasse;
		this.app_numerodappartement = app_numerodappartement;
		this.app_etage = app_etage;
		this.app_type = app_type;
	}

	/**
	 * Constructor without parameters
	 */
	public Appartement() {
	}

	
	
}
