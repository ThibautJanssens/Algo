#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#ifndef C_BIBLIO_H
#define C_BIBLIO_H

typedef enum Genre{BD, PO, TH, RO, RH, LF, LE, SC, IN, SF, SA, HI}Genre;

typedef struct Livre{
	char titre[128];
	char auteur[80];
	long isbn;
	char editeur[50];
	int annee_edition;
	Genre genre;
}Livre;

bool lireLivre(Livre* l);
char* livre2Str(char* buffer, const Livre livre);
void afficherBib(Livre* bib, int nbLivres);
bool ajouterLivre(Livre** bib, const Livre livre, int* nbLivres, int* taillePhysique);
Genre str2genre(char* genre);
char* genre2str(const Genre genre);
int comparerLivre(Livre* livre1, Livre* livre2);

#endif //C_BIBLIO_H
