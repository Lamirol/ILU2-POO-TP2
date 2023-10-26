package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		StringBuilder chaine = new StringBuilder();
		if (!this.controlLibererEtal.isVendeur(nomVendeur)){
			chaine.append("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
			System.out.println(chaine.toString());
		} else {
			String[] donneesEtal = this.controlLibererEtal.libererEtal(nomVendeur);
			chaine.append("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + " " + donneesEtal[2] + ".");
			chaine.append("Aurevoir " + nomVendeur + ", passez une bonne journée.");
			System.out.println(chaine.toString());
		}
	}

}
