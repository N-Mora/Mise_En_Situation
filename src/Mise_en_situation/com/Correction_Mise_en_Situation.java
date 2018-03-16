package Mise_en_situation.com;

import java.util.Scanner;

/**
 * Première classe du programme.
 * 
 * @author ACTIV
 * @version 1.0.0
 *
 */
public class Correction_Mise_en_Situation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Tableau en 2D qui représente mes utilisateurs.
		Object [][] informationsUtilisateur = new Object [2][4];
		
		// Je crée mon clavier.
		Scanner clavier = new Scanner(System.in);
		
		// Je déclare sans initialiser 4 variables de même type.
		String nom, prenom, dateDeNaissance;
		
		// Je fais une boucle pour créer mes 2 utilisateurs.
		// On connait les bornes de la boucle. [0;2[
		for (int utilisateurCrees = 0; utilisateurCrees < 2; utilisateurCrees++) {
			prenom = recupererPrenom(clavier);
			nom = recupererNom(clavier);
			dateDeNaissance = recupererDDN(clavier);
			
			String dateAujourdHui = "15/03/2018";
			
			byte age = calculerAge(dateAujourdHui, dateDeNaissance);
			
			System.out.print(prenom+ " "+ nom + " à " +age + " ans,");
			verifierMajorite(age);
			
			// On initialise le tableau en fonction de l'utilisateur.
			informationsUtilisateur[utilisateurCrees][0] = prenom;
			informationsUtilisateur[utilisateurCrees][1] = nom;
			informationsUtilisateur[utilisateurCrees][2] = dateDeNaissance;
			informationsUtilisateur[utilisateurCrees][3] = age;
			
			
		}
		
		System.out.println(" ");
		System.out.println("Les informations des utilisateurs sont :");
		afficherTableau2D(informationsUtilisateur);

	}
	
	/**
	 * Affiche le tableau avec les informations des utilisateurs
	 * @param informationsUtilisateur Objet de type objet
	 */
	private static void afficherTableau2D(Object[][] informationsUtilisateur) {
		for (int index = 0; index < informationsUtilisateur.length; index++) {
			for (Object informations : informationsUtilisateur[index]) {
				System.out.print(informations);
				
			}
			System.out.println();
		}
	}
	
	/**
	 * Vérifie si l'utilisateur est majeur
	 * @param age Objet de type byte
	 */
	private static void verifierMajorite(byte age) {
		if (age < 18) {
			System.out.println(" il n'est pas majeur.");
		} else {
			System.out.println(" il est majeur.");
		}
	}
	

	/**
	 * Calculer l'âge d'une personne à partir de la différence entre deux date
	 * @param dateAujourdHui Objet de type String.
	 * @param dateDeNaissance Objet de type String.
	 * @return L'âge de l'utilisateur.
	 */
	private static byte calculerAge(String dateAujourdHuiCopie, String dateDeNaissanceCopie) {
		short anneeDeNaissance = Short.parseShort(dateDeNaissanceCopie.split("/")[2]);
		short anneeDAujourdHui = Short.parseShort(dateAujourdHuiCopie.split("/")[2]);
		return (byte) (anneeDAujourdHui - anneeDeNaissance);
	}
	
	/**
	 * Récupérer la date de naissance d'une personne.
	 * @param clavierCopie Objet de type Scanner.
	 * @return Date de naissance de l'utilisateur.
	 */
	private static String recupererDDN(Scanner clavierCopie) {
		String birthDate;
		System.out.println("Entrez votre date de naissance (XX/XX/XXXX) : ");
		birthDate = clavierCopie.nextLine();
		return birthDate;
	}
	
	/**
 	* Récupérer le nom d'une personne.
 	* @param clavierCopie Objet de type Scanner.
 	* @return nom de l'utilisateur.
 	*/
	private static String recupererNom(Scanner clavierCopie) {
		// Vérifier qu'un nom est au bon format.
		boolean verificateur = false;
		String lastName;
				
		// On doit au moins rentrer une fois dans la boucle. 
		// On boucle tant que le vérificateur est faux.
		do {
			System.out.print("Entrez votre Nom : ");
			lastName = clavierCopie.nextLine();
			
			// Si le nom est composé d'au moins 3 caractères.
			if (lastName.length()>2) {
				// On vérifie que le nom ne contient que des lettres.
				verificateur = lastName.chars().allMatch(Character::isLetter);
			
			}
				
		} while (verificateur != true);
		
		return lastName;
	}

	/**
	 * Récupérer le prénom d'une personne.
	 * @param clavierCopie Objet de type Scanner.
	 * @return Prenom de l'utilisateur.
	 */
	private static String recupererPrenom(Scanner clavierCopie) {
		// Vérifier qu'un prénom est au bon format.
		boolean verificateur = false;
		String firstName;
		
		// On doit au moins rentrer une fois dans la boucle. 
		// On boucle tant que le vérificateur est faux.
		do {
			System.out.print("Entrez votre Prénom : ");
			firstName = clavierCopie.nextLine();
			
			// Si le prénom est composé d'au moins 3 caractères.
			if (firstName.length()>2) {
				// On vérifie que le prénom ne contient que des lettres.
				verificateur = firstName.chars().allMatch(Character::isLetter);
			
			}
			
		} while (verificateur != true);
		
		return firstName;
		
	}
}
