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
    * 
     */
	public String getNom() {
		return this.nom;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public Village getVillage() {
		return this.village;
	}
	
	public void setVillage(Village pfVillage) {
		this.village = pfVillage;
	}
	
	public boolean estContent() {
		return this.content;
	}
	
	public String toString() {
		return "Je suis " + this.getNom()
				+ ", j'ai " + this.age + ", "
				+ (this.village != null ? "j'habite " + this.village.getNom() : "je suis ermite")
				+ " ans et je suis " + (this.estContent() ? "": "PAS ") + "content";
	}
	
	public void sePresenter() {
		System.out.println(this.toString());
	}
	
	public String leChant() {
		return this.estContent() ? "la, la, la Schtroumpf la, la" : "gloups";
	}
	
	public void chanter() {
		System.out.println(this.leChant());
	}
	
	public void anniversaire() {
		this.age++;
	}
	
	public void manger(int pfQte) {
		if(pfQte <= 0)
			return;
		
		this.content = true;
	}
	
	public void allerTravailler() {
		this.content = false;
	}
	
	public void recolterSalsepareille() {
		if(this.village != null) {			
			this.content = false;
			this.village.addStockSalsepareilles(5);
		} else {
			this.content = true;
		}
	}
	
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
