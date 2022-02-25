public class MainVillage {

	public static void main (String[] argv) {
		String[] nomsSchtroumpfs = {
		        "Grand Schtroumpf", "Schtroumpf courant (et pas ordinaire)", "Schtroumpf ordinaire (et pas courant)", "Schtroumpf moralisateur à lunettes",
		        "Schtroumpf boudeur", "Schtroumpf volant", "Schtroumpf étonné", "Schtroumpf acrobate", "Schtroumpf paresseux"
		};
		
		Village village = new Village("Village des Schtroumpfs", 0, nomsSchtroumpfs);
	
		village.solstice_d_ete();
		
		Schtroumpf chef = village.chefDuVillage();
		
		if(chef != null)
			chef.sePresenter();
		
		village.envoyerAuTravail();
		village.schtroumpfsHeureux();
		
		village.envoyerCueillirSalsepareille();
		village.dinerTousEnsemble();
		village.solstice_d_ete();
	}

}
