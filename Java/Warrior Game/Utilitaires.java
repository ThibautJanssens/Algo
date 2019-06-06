/**
 * 
 * @author Janssens Thibaut  - IPL - 1/12/15
 * @author Lespinois Nicolas - IPL
 *
 */
public class Utilitaires {
	//choisis une valeur aleatoire entre deux bornes.
	public static int lancerDe (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;

		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1))
								+ valeurMinimale;
		return resultat;
	}
	
	//permet d'afficher une table donner en parametre (dans ce cas-ci une table de guerriers).
	public static void afficherTableGuerrier(Guerrier[] table){
		for (int i = 0; i < table.length; i++) {
			System.out.println(" "+table[i]);
		}		
	}
		
	//trie un table mis en parametre par ordre alphabetique (dans ce cas-ci un tableau de guerrier).
	public static Guerrier[] trierTableAlphabetique(Guerrier[] warList){
		Guerrier temp;
		for (int i =0;i<warList.length;i++){
			if(warList[i]== null)
				break;
			for(int j = 1; j < warList.length-1;j++){
				if(warList[j]== null)
					break;
				if(warList[j-1].getNom().compareTo(warList[j].getNom()) > 0){
					temp = warList[j-1];
					warList[j-1] = warList[j];
					warList[j] = temp;
				}
			}
		}
		return warList;
	
	}
	
	//trie un table mis en parametre par ordre croissant de points de vie (dans ce cas-ci un tableau de guerrier).
	public static Guerrier[] trierTableVie(Guerrier[] warList){
		Guerrier temp;
		for (int i =0;i<warList.length;i++){
			
			for(int j = 1; j < warList.length-1;j++){
				
				if(warList[j-1].getPointsDeVie() > warList[j].getPointsDeVie()){
					temp = warList[j-1];
					warList[j-1] = warList[j];
					warList[j] = temp;
				}
			}
		}
		return warList;
	}
	
	//permet d'afficher le contenu d'une equipe de guerrier
	public static void afficherEquipe(EquipeGuerriers equipe){
		for(int i = 0; i < equipe.nombreGuerrierEnVie;i++){
			System.out.println(" "+equipe.getWarList()[i]);
		}
	}
}