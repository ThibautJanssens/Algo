#include "biblio.h"

char* lesGenres[] = {"Bande dessinée", "Poésie", "Théâtre", "Roman", "Roman historique", "Littérature française",
                     "Littérature étrangère", "Sciences", "Informatique", "Science-fiction", "Santé",
                     "Histoire"};

bool lireLivre(Livre* l){

}

char* livre2Str(char* buffer, const Livre livre){

}

void afficherBib(Livre* bib, int nbLivres){

}

bool ajouterLivre(Livre** bib, const Livre livre, int* nbLivres, int* taillePhysique){

}

Genre str2genre(char* genre){
	for(Genre g = BD; g <= HI; g++){
		if(strcmp(genre, lesGenres[g]) == 0){
			return g;
		}
	}
	return -1;
}

char* genre2str(const Genre genre){
	if(genre < BD || genre > HI){
		return NULL;
	}else {
		return lesGenres[genre];
	}
}

//0 si les livres a et b ont la même année d'édition
//1 annee edition livre 1 > annee edition livre 2
//-1 annee edition livre 1 < annee edition livre 2
int comparerLivre(Livre* livre1, Livre* livre2){
	return 0;
}

int main(int argc, char *argv[]) {
	int nbLivre, taillePhysique;
	char* buffer;

	Livre* livre;
	if((buffer = (char*) malloc(256 * sizeof(char))) == NULL) {
		perror("Error: malloc buffer");
		exit(1);
	}


	if((livre = (Livre*) malloc(sizeof(Livre))) == NULL) {
		perror("Error: malloc Livre");
		exit(1);
	}

	int taille = 100;
	char* ligne;
	fgets(ligne, taille, stdin);

	Genre genre = str2genre(ligne);
	printf("Genre = %d\n", genre);
	char* toRet = genre2str(genre);
	printf("String du genre = %s\n", toRet);
	return 0;
}