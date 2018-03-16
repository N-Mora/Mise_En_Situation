package Mise_en_situation.com;

import java.util.Scanner;

/**
 * Premi�re classe du programme.
 * 
 * @author ACTIV
 * @version 1.0.0
 *
 */
public class Correction_Mise_en_Situation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Tableau en 2D qui repr�sente mes utilisateurs.
		Object [][] informationsUtilisateur = new Object [2][4];
		
		// Je cr�e mon clavier.
		Scanner clavier = new Scanner(System.in);
		
		// Je d�clare sans initialiser 4 variables de m�me type.
		String nom, prenom, dateDeNaissance;
		
		// Je fais une boucle pour cr�er mes 2 utilisateurs.
		// On connait les bornes de la boucle. [0;2[
		for (int utilisateurCrees = 0; utilisateurCrees < 2; utilisateurCrees++) {
			prenom = recupererPrenom(clavier);
			nom = recupererNom(clavier);
			dateDeNaissance = recupererDDN(clavier);
			
			String dateAujourdHui = "15/03/2018";
			
			byte age = calculerAge(dateAujourdHui, dateDeNaissance);
			
			System.out.print(prenom+ " "+ nom + " � " +age + " ans,");
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
	 * V�rifie si l'utilisateur est majeur
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
	 * Calculer l'�ge d'une personne � partir de la diff�rence entre deux date
	 * @param dateAujourdHui Objet de type String.
	 * @param dateDeNaissance Objet de type String.
	 * @return L'�ge de l'utilisateur.
	 */
	private static byte calculerAge(String dateAujourdHuiCopie, String dateDeNaissanceCopie) {
		short anneeDeNaissance = Short.parseShort(dateDeNaissanceCopie.split("/")[2]);
		short anneeDAujourdHui = Short.parseShort(dateAujourdHuiCopie.split("/")[2]);
		return (byte) (anneeDAujourdHui - anneeDeNaissance);
	}
	
	/**
	 * R�cup�rer la date de naissance d'une personne.
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
 	* R�cup�rer le nom d'une personne.
 	* @param clavierCopie Objet de type Scanner.
 	* @return nom de l'utilisateur.
 	*/
	private static String recupererNom(Scanner clavierCopie) {
		// V�rifier qu'un nom est au bon format.
		boolean verificateur = false;
		String lastName;
				
		// On doit au moins rentrer une fois dans la boucle. 
		// On boucle tant que le v�rificateur est faux.
		do {
			System.out.print("Entrez votre Nom : ");
			lastName = clavierCopie.nextLine();
			
			// Si le nom est compos� d'au moins 3 caract�res.
			if (lastName.length()>2) {
				// On v�rifie que le nom ne contient que des lettres.
				verificateur = lastName.chars().allMatch(Character::isLetter);
			
			}
				
		} while (verificateur != true);
		
		return lastName;
	}

	/**
	 * R�cup�rer le pr�nom d'une personne.
	 * @param clavierCopie Objet de type Scanner.
	 * @return Prenom de l'utilisateur.
	 */
	private static String recupererPrenom(Scanner clavierCopie) {
		// V�rifier qu'un pr�nom est au bon format.
		boolean verificateur = false;
		String firstName;
		
		// On doit au moins rentrer une fois dans la boucle. 
		// On boucle tant que le v�rificateur est faux.
		do {
			System.out.print("Entrez votre Pr�nom : ");
			firstName = clavierCopie.nextLine();
			
			// Si le pr�nom est compos� d'au moins 3 caract�res.
			if (firstName.length()>2) {
				// On v�rifie que le pr�nom ne contient que des lettres.
				verificateur = firstName.chars().allMatch(Character::isLetter);
			
			}
			
		} while (verificateur != true);
		
		return firstName;
		
	}
}
