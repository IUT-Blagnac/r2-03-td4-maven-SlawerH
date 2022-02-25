public class Schtroumpf {
	private String nom;
	private int age;
	private boolean content;
	private Village village;

    /**
     * Crée un Schtroumpf sans village
     */
	public Schtroumpf(String nom, int age) {
		this.nom = nom;
		this.age = age;
		this.content = true;
		this.village = null;
	}
	
    /**
     * Crée un Schtroumpf avec village
     */
	public Schtroumpf(String nom, int age, Village village) {
		this.nom = nom;
		this.age = age;
		this.content = true;
		this.village = village;
	}
	
    /**
     * Retourne le nom du Strchoumpf
	 * @return le nom du Schtroumpf
     */
	public String getNom() {
		return this.nom;
	}
	
    /**
     * Retourne l'âge du Strchoumpf
	 * @return l'âge du Schtroumpf
     */
	public int getAge() {
		return this.age;
	}
	
    /**
     * Retourne le village du Strchoumpf
	 * @return le village du Schtroumpf
     */
	public Village getVillage() {
		return this.village;
	}
	
    /**
     * Définit le village du Schtroumpf
	 * @param Village pfVillage : le village à attribuer
     */
	public void setVillage(Village pfVillage) {
		this.village = pfVillage;
	}

	
	
    /**
     * Retourne l'humeur du Schtroumpf
	 * @return vrai si heureux, faux sinon
     */	
	public boolean estContent() {
		return this.content;
	}

    /**
     * Retourne un affichage compréhensible pour un Schtroumpf
	 * @return un affichage compréhensible
     */
	public String toString() {
		return "Je suis " + this.getNom()
				+ ", j'ai " + this.age + ", "
				+ (this.village != null ? "j'habite " + this.village.getNom() : "je suis ermite")
				+ " ans et je suis " + (this.estContent() ? "": "PAS ") + "content";
	}
	
    /**
     * Affiche la présentation compréhensible du Schtroumpf
     */
	public void sePresenter() {
		System.out.println(this.toString());
	}
	
	/**
	 * Retourne le chant du Schtroumpf
	 * @return le chant
	 */
	public String leChant() {
		return this.estContent() ? "la, la, la Schtroumpf la, la" : "gloups";
	}
	
	/**
	 * Affiche le chant du Schtroumpf
	 */
	public void chanter() {
		System.out.println(this.leChant());
	}
	
	/**
	 * Réalise l'anniversaire du Schtroumpf (vieillissement d'un an)
	 */
	public void anniversaire() {
		this.age++;
	}
	
	/**
	 * Donne à manger au Schtroumpf (et le rend heureux)
	 * @param int pfQte : quantité à manger
	 */
	public void manger(int pfQte) {
		if(pfQte <= 0)
			return;
		
		this.content = true;
	}
	
	/**
	 * Fait aller le Schtroumpf au travail (et le rend malheureux)
	 */
	public void allerTravailler() {
		this.content = false;
	}
	
	/**
	 * Envoie le Schtroumpf à la récolte
	 */
	public void recolterSalsepareille() {
		if(this.village != null) {			
			this.content = false;
			this.village.addStockSalsepareilles(5);
		} else {
			this.content = true;
		}
	}
	
	/**
	 * Fait dinerle Schtroumpf à son village
	 */
	public void dinerAuVillage() {
		if(this.village == null) {
			this.content = false;
			return;
		}
		
		if(this.content)
			return;
		
		if(this.village.getStocketSalsepareille() < 3)
			return;
		
		this.village.addStockSalsepareilles(-3);
		this.content = true;
	}
}
