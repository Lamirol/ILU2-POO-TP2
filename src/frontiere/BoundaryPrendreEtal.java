package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		StringBuilder chaine = new StringBuilder();
		if (!this.controlPrendreEtal.verifierIdentite(nomVendeur)) {
			chaine.append("Je suis désolé " + nomVendeur + " mais il faut être un habitant de notre "
					+ "village pour commercer ici");
			System.out.println(chaine.toString());
		} else {
			chaine.append("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.");
			if (!this.controlPrendreEtal.resteEtals()){
				chaine.append("Désolé " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occupé.");
				System.out.println(chaine.toString());
			} else {
				System.out.println(chaine.toString());
				installerVendeur(nomVendeur);
			}
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder question = new StringBuilder();
		question.append("C'est parfait, il me reste un étal pour vous !\n");
		question.append("Il me faudrait quelques renseignements :\n");
		question.append("Quel produit souhaitez-vous vendre ?\n");
		String produit = Clavier.entrerClavier(question.toString());
		
		StringBuilder questionQuantite = new StringBuilder();
		questionQuantite.append("Combien souhaitez-vous en vendre ?");
		int quantiteProduit = Clavier.entrerEntier(questionQuantite.toString());
		
		int indiceEtal = this.controlPrendreEtal.prendreEtal(nomVendeur, produit, quantiteProduit);
		StringBuilder chaine = new StringBuilder();
		chaine.append("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + (indiceEtal+1));
		System.out.println(chaine.toString());
	}
}
