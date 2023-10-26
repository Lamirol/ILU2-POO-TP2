package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		Etal etal = null;
		if (this.village.trouverHabitant(nomVendeur) != null){
			etal = this.village.rechercherEtal(this.village.trouverHabitant(nomVendeur));
		}
		return etal;
	}
}
