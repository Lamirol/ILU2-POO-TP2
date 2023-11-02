package frontiere;

//import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	//private Scanner scan = new Scanner(System.in);    //Non-utilisé avec la classe Clavier
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!this.controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			StringBuilder chaine = new StringBuilder();
			chaine.append("Je suis désolé " + nomAcheteur + " mais il faut être un "
					+ "habitant de notre village pour commercer ici.");
			System.out.println(chaine.toString());
		} else {
			choixProduit(nomAcheteur);
		}
	}
	
	private void choixProduit(String nomAcheteur) {
		StringBuilder chaine = new StringBuilder();
		chaine.append("Quel produit voulez-vous acheter ?\n");
		String produit = Clavier.entrerClavier(chaine.toString());
		
		StringBuilder chaineProduit = new StringBuilder();
		String[] listeVendeurs = this.controlAcheterProduit.trouverProduit(produit);
		if(listeVendeurs == null) {
			chaineProduit.append("Désolé, personne ne vend ce produit au marché");
			System.out.println(chaineProduit.toString());
		} else {
			chaineProduit.append("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
			for (int indiceListeVendeur = 0; indiceListeVendeur<listeVendeurs.length; indiceListeVendeur++) {
				chaineProduit.append((indiceListeVendeur+1) + " - " + listeVendeurs[indiceListeVendeur] + "\n");
			}
			int numVendeur = Clavier.entrerEntier(chaineProduit.toString());
			
			StringBuilder chaineDeplacement = new StringBuilder();
			while(numVendeur > (listeVendeurs.length)) {
				chaineDeplacement.append("Veuillez entrer un entier valide.\n");
				numVendeur = Clavier.entrerEntier(chaineDeplacement.toString());
			}
			String nomVendeur = listeVendeurs[(numVendeur-1)];
			chaineDeplacement.append(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur + "\n");
			chaineDeplacement.append("Bonjour " + nomAcheteur + "\n");
			chaineDeplacement.append("Combien de " + produit + " voulez-vous acheter ?\n");
			int quantite = Clavier.entrerEntier(chaineDeplacement.toString());
			
			int quantiteAchetee = this.controlAcheterProduit.acheterProduit(quantite, nomVendeur);
			StringBuilder chaineAchat = new StringBuilder();
			if (quantiteAchetee == -1){
				chaineAchat.append("Je suis désolé " + nomAcheteur + " mais " + nomVendeur + " n'est pas un habitant de notre village et ne peut pas commercer ici\n");
			} else if(quantiteAchetee == 0){
				chaineAchat.append(nomAcheteur + " veut acheter " + quantite + " " + produit + " mais malheureusement il n'y en a plus !\n");
			} else if(quantiteAchetee == quantite) {
				chaineAchat.append(nomAcheteur + " achète " + quantiteAchetee + " " + produit + " à " + nomVendeur + ".");
			} else {
				chaineAchat.append(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement " 
						+ nomVendeur + " n'en a plus que " + quantiteAchetee + ". " + nomAcheteur + " achète tout le stock de " + nomVendeur + ".\n");
			}				
		}
	}
}
