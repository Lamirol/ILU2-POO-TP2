package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = this.controlAfficherMarche.donnerInfosMarche();
		StringBuilder chaine = new StringBuilder();
		if (infosMarche.length == 0) {
			chaine.append("Le marché est vide, revenez plus tard.");
		} else {
			chaine.append(nomAcheteur + ", vous trouverez au marché :");
			for (int indiceInfosMarche = 0; indiceInfosMarche<infosMarche.length; indiceInfosMarche++) {
				String vendeur = infosMarche[indiceInfosMarche];
				String quantite = infosMarche[++indiceInfosMarche];
				String produit = infosMarche[++indiceInfosMarche];
						
				chaine.append("\n- " + vendeur + " qui vend " + quantite + " " + produit);
			}
		}
		System.out.println(chaine.toString());
	}
}
