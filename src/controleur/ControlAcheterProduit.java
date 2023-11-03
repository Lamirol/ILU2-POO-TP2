package controleur;

import villagegaulois.Village;
import personnages.Gaulois;	//Je suis obligé d'importer la classe Gaulois pour pouvoir gérer l'import de la liste retournée par village.rechercheVendeursProduit
import villagegaulois.Etal; //Pareil pour l'étal retourné par trouverEtalVendeur

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomAcheteur) {
		return this.controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public String[] trouverProduit(String produit) {
		Gaulois[] gaulois = this.village.rechercherVendeursProduit(produit);
		String[] listGauloisString;
		if (gaulois !=null) {
			listGauloisString = new String[gaulois.length];
			for (int indiceListeGaulois = 0; indiceListeGaulois<gaulois.length; indiceListeGaulois++) {
				listGauloisString[indiceListeGaulois] = gaulois[indiceListeGaulois].getNom();
			}
		} else {
			listGauloisString = null;
		}
		return listGauloisString;
	}
	
	public Etal trouverEtalVendeur(String nomVendeur) {
		if(!this.controlVerifierIdentite.verifierIdentite(nomVendeur)) {
			return null;
		} else {
			return this.controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		}
	}
	
	public int acheterProduit(String nomVendeur, int quantite) {
		if(!this.controlVerifierIdentite.verifierIdentite(nomVendeur)) {
			return -1;
		} else {
			Etal etal = this.controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
			return etal.acheterProduit(quantite);
		}
	}
}
