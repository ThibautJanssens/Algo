//1
#include <stdlib.h>
#include <stdio.h>

struct Etudiant {
	char nom[20];
	char prenom [20];
	int noma;
};


void afficher (struct Etudiant e) {
	printf("Etudiant: %s - %s - %i\n", e.nom, e.prenom, e.noma);
}

int main () {
	struct Etudiant stud = {"Dupont", "Jean", 123456};
	afficher(stud);
}

//2
#include <stdlib.h>
#include <stdio.h>

struct Fraction {
	int numerateur;
	int denominateur;
};


void inverse (struct Fraction * f) {
	int tmp = f->numerateur;
	f->numerateur = f->denominateur;
	f->denominateur = tmp;
}

int main () {
	struct Fraction fraction = {3, 5};
	inverse(&fraction);

	printf("Fraction: %d / %d\n", fraction.numerateur, fraction.denominateur);
}

//3
#include <stdlib.h>
#include <stdio.h>

#define TAILLE 3

struct Point {
	int x;
	int y;
};

struct Point lirePoint ();
void afficherPoints (struct Point * t,  int taille);


int main () {
	struct Point tab[TAILLE];
	// saisie de TAILLE points
	for (int i=0; i<TAILLE; i++) {
		tab[i] = lirePoint();
	}
	// affichage des points
	afficherPoints(tab, TAILLE);
}


struct Point lirePoint () {
	struct Point p;
	scanf("%i", &p.x);
	scanf("%i", &p.y);
	return p;
}

void afficherPoints (struct Point * t,  int taille) {
	for (int i=0; i<taille; i++)
		printf("point %i: (%d,%d)\n", i+1, t[i].x, t[i].y);
}

//4
#include <stdio.h>
#include<stdlib.h>

typedef struct Date {
	int jour, mois, annee;
}Date;


void afficher (Date d);

int main () {
	Date date;
	scanf("%d", &date.jour);
	scanf("%d", &date.mois);
	scanf("%d", &date.annee);
	afficher(date);
}

void afficher (Date d) {
	printf("Date: %d/%d/%d\n", d.jour, d.mois, d.annee);
}