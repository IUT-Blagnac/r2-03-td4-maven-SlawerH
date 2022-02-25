import java.util.ArrayList;

public class Village {
	private String nom;
	// private Schtroumpf[] schtroumpfs;
	// private int nbSchtroumpfs;
	private ArrayList<Schtroumpf> schtroumpfs;
	private int nbSalsepareille;
	
	public Village (String pfNomV, int pfStockSalsepareille, String[] pfNomsDesSchtroumpfs) {
		this.nom = pfNomV;
		this.nbSalsepareille = pfStockSalsepareille;
		this.schtroumpfs = new ArrayList<Schtroumpf>();
		
		for(int i = 0; i < pfNomsDesSchtroumpfs.length; i++) {
			Schtroumpf schtroumpf = new Schtroumpf(pfNomsDesSchtroumpfs[i], (int)(Math.random()*150));
			schtroumpf.setVillage(this);
			
			this.schtroumpfs.add(schtroumpf);
			//this.nbSchtroumpfs++;
		}
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getNbSchtroumpf() {
		return this.schtroumpfs.size();
	}
	
	public int getStocketSalsepareille() {
		return this.nbSalsepareille;
	}
	
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
	
	public void addStockSalsepareilles(int pfQuantite) {
		this.nbSalsepareille += pfQuantite;
	}
	
	public void dinerTousEnsemble() {
		int nbSchtroumpfs = this.schtroumpfs.size();
		
		for(int i = 0; i < nbSchtroumpfs; i++) {
			this.schtroumpfs.get(i).dinerAuVillage();
		}
	}
	
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
