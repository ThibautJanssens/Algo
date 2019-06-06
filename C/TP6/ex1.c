#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

void printGrille();
void jouer(int colonne, char joueur);
void libererColonne(int numColonne);
void ajouterColonne();

char** grille;
int nbLignes, nbColonnes, i = 0, j = 0;

bool gagne = false;

int main() {

    printf("H = "),
    scanf("%d", &nbLignes);
    printf("L = ");
    scanf("%d", &nbColonnes);

    if((grille = (char**) malloc(nbColonnes * sizeof(char *))) == 0) {
        perror("malloc");
        exit(0);
    }

    for(i = 0 ; i < nbColonnes ; i++) {
        if((grille[i] = (char *) malloc(nbLignes * sizeof(char))) == 0) {
           perror("malloc");
            exit(0); 
        }
    }

    for(i = 0 ; i < nbColonnes ; i++) {
        for(j = 0 ; j < nbLignes ; j++) {
            grille[i][j] = '.';
        }
    }

    int choixColonne;    
    while(!gagne) {
        printf("Colonne joueur X = ");
        scanf("%d", &choixColonne);
        if(choixColonne > 0) {
            jouer(choixColonne-1, 'x');
        } else {
            choixColonne = abs(choixColonne);
            if(choixColonne > nbColonnes) {
                ajouterColonne();
            } else {
                libererColonne(abs(choixColonne));
            }  
        }
        printGrille();

        printf("Colonne joueur O = ");
        scanf("%d", &choixColonne);
        if(choixColonne > 0) {
            jouer(choixColonne-1, 'o');
        } else {
            choixColonne = abs(choixColonne);
            if(choixColonne > nbColonnes) {
                printf("pre-ajouter");
                ajouterColonne();
            } else {
                libererColonne(abs(choixColonne));
            }  
        }
        printGrille();
    }


    for(i = 0 ; i < nbColonnes ; i++) {
        free(grille[i]);
    }
    free(grille);

    return 0;
}

void printGrille() {
    for(i = 0 ; i < nbLignes ; i++) {
        for(j = 0 ; j < nbColonnes ; j++) {
            printf("%c ", grille[j][i]); 
        }
        printf("\n");
    }
}

void jouer(int colonne, char joueur) {
    for(i = nbColonnes-1 ; i > 0 ; i--) {
        if(grille[colonne][i] == '.') {
            grille[colonne][i] = joueur;
            break;
        }
    }
}

void libererColonne(int numColonne) {
    //printf("libererColonne\n");
    //printf("numCol : %d\n", numColonne);
    free(grille[numColonne-1]);
    for(i = numColonne ; i < nbColonnes ; i++) {
        grille[i-1] = grille[i];
    }
    nbColonnes--;
    grille = realloc(grille, nbColonnes * sizeof(char *)); 
}

void ajouterColonne() {
    nbColonnes++;
    grille = realloc(grille, nbColonnes * sizeof(char *));
    for(i = 1 ; i < nbLignes ; i++) {
        grille[nbColonnes-1][i] = '.';
    }
}
