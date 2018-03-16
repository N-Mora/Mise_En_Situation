package Mise_en_situation.com;

/**
 * Première classe du programme
 * @author ACTIV
 * @version 1.0.0
 * 
 */


import java.util.Calendar;
import java.util.Scanner;

public class Mise_en_Situation {

	//Declaration des Variables 
	static String prenom;
	static String nom;
	static String age;
	static String datedenaissance;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Je crée un clavier.
		Scanner clavier = new Scanner(System.in);

		//Je crée ma boucle, et je l'initie
		int i = 0;
		
		do {
		//Je tape au clavier
		System.out.println("Rentrer son prénom :");
		prenom = clavier.nextLine();
		System.out.println(prenom);
		System.out.println("Rentrer son nom :");
		nom = clavier.nextLine();
		System.out.println(nom);
		System.out.println("Rentrer son age :");
		age = clavier.nextLine();
		System.out.println(age);
		System.out.println("Rentrer sa date de naissance :");
		datedenaissance = clavier.nextLine();
		System.out.println(datedenaissance);
		
		short Age = Short.parseShort(age); //Transforme la variable âge de chaine de caractère à short
		//System.out.println(Age);
		
		//System.out.println(date);
		
		//Je vérifie si la personne est majeur ou non
		if (Age < 18) {
			System.out.println(prenom +" "+ nom + " n'est pas majeur.");
		}  else {
			System.out.println(prenom +" "+ nom + " est majeur");
		} 
		i++;
		
		System.out.println("Le Prénom, le Nom, l'Age et la Date de naissance sont dans cet ordre :");
		//Je crée un tableau.
		Object [] information = new Object[] {prenom,nom,age,datedenaissance};
		//J'affiche mon tableau (verif)
		for (Object x : information) {
			System.out.println(x);
		
		}
		} while (i<2); // Je répète ma boucle pour faire ce tableau pour 2 personnes
		
		
	}
	
	
	

}
