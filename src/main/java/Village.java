import java.util.ArrayList;

public class Village {
	private String nom;
	private ArrayList<Schtroumpf> schtroumpfs;
	private int nbSalsepareille;
	
	/**
	 * Crée un village
	 */
	public Village (String pfNomV, int pfStockSalsepareille, String[] pfNomsDesSchtroumpfs) {
		this.nom = pfNomV;
		this.nbSalsepareille = pfStockSalsepareille;
		this.schtroumpfs = new ArrayList<Schtroumpf>();
		
		for(int i = 0; i < pfNomsDesSchtroumpfs.length; i++) {
			Schtroumpf schtroumpf = new Schtroumpf(pfNomsDesSchtroumpfs[i], (int)(Math.random()*150));
			schtroumpf.setVillage(this);
			
			this.schtroumpfs.add(schtroumpf);
		}
	}
	
    /**
     * Retourne le nom du village
	 * @return le nom du village
     */
	public String getNom() {
		return this.nom;
	}
	
    /**
     * Retourne le nombre de Schtroumpfs
	 * @return le nombre de Schtroumpfs
     */
	public int getNbSchtroumpf() {
		return this.schtroumpfs.size();
	}
	
    /**
     * Retourne le stock de salespareille
	 * @return le stock de salespareille
     */
	public int getStocketSalsepareille() {
		return this.nbSalsepareille;
	}
	
	/**
	 * Réalise un solstice d'été (tout les Schtroumpfs du village chantent et se présentent)
	 */
	public void solstice_d_ete() {
		int nbContents = 0;
		
		int nbSchtroumpfs = this.schtroumpfs.size();
		
		for(int i = 0; i < nbSchtroumpfs; i++) {
			Schtroumpf schtroumpf = this.schtroumpfs.get(i);
			
			schtroumpf.sePresenter();
			schtroumpf.chanter();
			
			if(schtroumpf.estContent())
				nbContents++;
		}

		System.out.println("Village : " + this.getNom());
		System.out.println("Nombre de Schtroumpfs : " + this.getNbSchtroumpf());
		System.out.println("Nombre de Schtroumpfs contents : " + nbContents);
	}
	
	/**
	 * Retourne le chef du village (plus âgé)
	 * @return le chef du village
	 */
	public Schtroumpf chefDuVillage() {
		int nbSchtroumpfs = this.schtroumpfs.size();
		
		if(nbSchtroumpfs == 0)
			return null;
		
		Schtroumpf plusVieux = this.schtroumpfs.get(0);
		
		for(int i = 1; i < nbSchtroumpfs; i++) {
			Schtroumpf schtroumpf = this.schtroumpfs.get(i);
			
			if(schtroumpf.getAge() > plusVieux.getAge())
				plusVieux = schtroumpf;
		}
		
		return plusVieux;
	}
	
	/**
	 * Envoi les Schtroumpfs heureux (1 sur 2) au travail
	 */
	public void envoyerAuTravail() {
		boolean prochainVaTravailler = false;

		int nbSchtroumpfs = this.schtroumpfs.size();
		
		for(int i = 0; i < nbSchtroumpfs; i++) {
			Schtroumpf schtroumpf = this.schtroumpfs.get(i);
			
			if(!schtroumpf.estContent())
				continue;
			
			if(prochainVaTravailler)
				schtroumpf.allerTravailler();

			prochainVaTravailler = !prochainVaTravailler;
		}
	}
	
	/**
	 * Réalise la présentation et le chant des Schtroumpfs heuruex
	 */
	public void schtroumpfsHeureux() {
		int nbSchtroumpfs = this.schtroumpfs.size();
		
		for(int i = 0; i < nbSchtroumpfs; i++) {
			Schtroumpf schtroumpf = this.schtroumpfs.get(i);
			
			if(!schtroumpf.estContent())
				continue;
			
			schtroumpf.sePresenter();
			schtroumpf.chanter();
		}
	}
	
	/**
	 * Rajoute du stock de salsepareille
	 * @param int pfQuantite : quantité à rajouter
	 */
	public void addStockSalsepareilles(int pfQuantite) {
		this.nbSalsepareille += pfQuantite;
	}
	
	/**
	 * Réalisation du dîner des Schtroumpfs ensemble
	 */
	public void dinerTousEnsemble() {
		int nbSchtroumpfs = this.schtroumpfs.size();
		
		for(int i = 0; i < nbSchtroumpfs; i++) {
			this.schtroumpfs.get(i).dinerAuVillage();
		}
	}
	
	/**
	 * Envoie 1 Schtroumpf sur 2 heureux à la récole
	 */
	public void envoyerCueillirSalsepareille() {
		boolean prochainVaCueillir = false;

		int nbSchtroumpfs = this.schtroumpfs.size();
		
		for(int i = 0; i < nbSchtroumpfs; i++) {
			Schtroumpf schtroumpf = this.schtroumpfs.get(i);
			
			if(!schtroumpf.estContent())
				continue;
			
			if(prochainVaCueillir)
				schtroumpf.recolterSalsepareille();

			prochainVaCueillir = !prochainVaCueillir;
		}
	}
}
