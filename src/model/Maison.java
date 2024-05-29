package model;

/**
 * Classe Maison
 * @author Equipe 5.2
 * @version 1.2
 * */

public class Maison extends BienImmobilier{

	/**
	 * Id généré de maison
	 */
	private String msn_id_maison;
	
	/**
	 * Cave de maison
	 */
	private String msn_cave;
	
	/**
	 * terasse de maison
	 */
	private String msn_terasse;

	/**
	 * jardin de maison
	 */
	private String msn_jardin;
	
	
	
	/**
	 * @return the msn_id_maison
	 */
	public String getMsn_id_maison() {
		return msn_id_maison;
	}

	/**
	 * @param msn_id_maison the msn_id_maison to set
	 */
	public void setMsn_id_maison(String msn_id_maison) {
		this.msn_id_maison = msn_id_maison;
	}

	/**
	 * @return the msn_cave
	 */
	public String getMsn_cave() {
		return msn_cave;
	}

	/**
	 * @param msn_cave the msn_cave to set
	 */
	public void setMsn_cave(String msn_cave) {
		this.msn_cave = msn_cave;
	}

	/**
	 * @return the msn_terasse
	 */
	public String getMsn_terasse() {
		return msn_terasse;
	}

	/**
	 * @param msn_terasse the msn_terasse to set
	 */
	public void setMsn_terasse(String msn_terasse) {
		this.msn_terasse = msn_terasse;
	}

	/**
	 * @return the msn_jardin
	 */
	public String getMsn_jardin() {
		return msn_jardin;
	}

	/**
	 * @param msn_jardin the msn_jardin to set
	 */
	public void setMsn_jardin(String msn_jardin) {
		this.msn_jardin = msn_jardin;
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
	 * @param msn_id_maison
	 * @param msn_cave
	 * @param msn_terasse
	 * @param msn_jardin
	 */
	public Maison(String bn_adresse, int bn_nombredepiece, String bn_meuble, int bn_anneedeconstruction,
			String bn_typedechauffage, String bn_statut, double bn_loyer, double bn_charges, double bn_caution,
			String bn_bllr_id, String msn_id_maison, String msn_cave, String msn_terasse, String msn_jardin) {
		super(bn_adresse, bn_nombredepiece, bn_meuble, bn_anneedeconstruction, bn_typedechauffage, bn_statut, bn_loyer,
				bn_charges, bn_caution, bn_bllr_id);
		this.msn_id_maison = msn_id_maison;
		this.msn_cave = msn_cave;
		this.msn_terasse = msn_terasse;
		this.msn_jardin = msn_jardin;
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
	 * @param msn_id_maison
	 * @param msn_cave
	 * @param msn_terasse
	 * @param msn_jardin
	 */
	public Maison(String bn_adresse, int bn_nombredepiece, String bn_meuble, int bn_anneedeconstruction,
			String bn_typedechauffage, double bn_loyer, double bn_charges, double bn_caution, String bn_bllr_id,
			String msn_id_maison, String msn_cave, String msn_terasse, String msn_jardin) {
		super(bn_adresse, bn_nombredepiece, bn_meuble, bn_anneedeconstruction, bn_typedechauffage, bn_loyer, bn_charges,
				bn_caution, bn_bllr_id);
		this.msn_id_maison = msn_id_maison;
		this.msn_cave = msn_cave;
		this.msn_terasse = msn_terasse;
		this.msn_jardin = msn_jardin;
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
	 * @param msn_cave
	 * @param msn_terasse
	 * @param msn_jardin
	 */
	public Maison(String bn_adresse, int bn_nombredepiece, String bn_meuble, int bn_anneedeconstruction,
			String bn_typedechauffage, double bn_loyer, double bn_charges, double bn_caution, String bn_bllr_id, String msn_cave, String msn_terasse, String msn_jardin) {
		super(bn_adresse, bn_nombredepiece, bn_meuble, bn_anneedeconstruction, bn_typedechauffage, bn_loyer, bn_charges,
				bn_caution, bn_bllr_id);
		this.msn_cave = msn_cave;
		this.msn_terasse = msn_terasse;
		this.msn_jardin = msn_jardin;
	}

	
	/**
	 * Constructor without parameter
	 */
	public Maison() {
	}


}
