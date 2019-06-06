#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

void afficherPlateau(char** tableau, int nbLignes, int nbColonnes);
void lireColonne(char pionJoueur, int *colJoueur);
void placerPion(char** tableau, char pionJoueur, int numColonne, int colJoueur, int *remplissageCol);
void ajouterColonne(char** tableau, int nbLignes, int *nbColonnes, int *remplissageCol);
void supprimerColonne(char** tableau, int *nbColonnes, int colADetruire, int *remplissageCol);

int main(){
    int nLignes, nCol;
    char **cases;
    int *remplissageCol;
    char pionJoueur = 'X';
    char pionJouePas = 'O';

    printf("H = ?\n");
    scanf("%d", &nLignes);
    printf("L = ?\n");
    scanf("%d", &nCol);
    printf("\n");

    // Allocation de la matrice et du tableau de positions des jetons
    cases = (char **)malloc(nCol*sizeof(char *));
    remplissageCol = (int *)malloc(nCol*sizeof(int));
    if (cases == NULL || remplissageCol == NULL){
        perror("Probleme memoire!\n");
        exit(1);
    }
    for (int j = 0; j < nCol; j++){
        cases[j] = (char *)malloc(nLignes*sizeof(char));
        if (cases[j] == NULL){
            perror("Probleme memoire!\n");
            exit(1);
        }
    }

    // Initialisation de la matrice
    for (int j = 0; j< nCol; j++){
        remplissageCol[j] = nLignes-1;
        for (int i = 0; i < nLignes; i++){
            cases[j][i] = '.';
        }
    }

    // Jeu
    int colJoueur;
    do{
        // Permutation des joueurs
        char temp = pionJoueur;
        pionJoueur = pionJouePas;
        pionJouePas = temp;

        // Affichage tableau
        afficherPlateau(cases, nLignes, nCol);

        // Lecture de la colonne où jouer
        lireColonne(pionJoueur, &colJoueur);


        // Cas de la colonne pleine
        if (colJoueur>0 && colJoueur<nCol && remplissageCol[colJoueur-1] < 0){
            printf("Colonne pleine!\n");
            continue;
        }

        // Cas de placement d'un pion
        /*if (colJoueur>0 && colJoueur<=nCol){
            cases[colJoueur-1][remplissageCol[colJoueur-1]] = pionJoueur;
            remplissageCol[colJoueur-1]--;
        }*/
        placerPion(cases, pionJoueur, nCol, colJoueur, remplissageCol);

        // Cas du rajout de colonne
        if (colJoueur>nCol){
            /*nCol++;
            cases = (char **)realloc(cases, nCol*sizeof(char *));
            cases[nCol-1] = (char *)malloc(nLignes*sizeof(char));
            remplissageCol[nCol-1] = nLignes-1;
            for (int i=0; i<nLignes; i++){
                cases[nCol-1][i] = '.';
            }*/
            ajouterColonne(cases, nLignes, &nCol, remplissageCol);
        }

        // Cas de la suppression d'une colonne
        if (colJoueur<0 && -colJoueur<=nCol){
            /*int colADetruire = -colJoueur-1;
            free(cases[colADetruire]);
            // On decale toutes les colonnes vers la gauche
            for (int j = colADetruire; j<nCol; j++){
                cases[j] = cases[j+1];
                remplissageCol[j] = remplissageCol[j+1];
            }
            nCol--;
            // Ici taille logique == taille physique
            cases = (char **)realloc(cases, nCol*sizeof(char *));*/
            supprimerColonne(cases, &nCol, -colJoueur-1, remplissageCol);
        }
    } while (nCol != 0);

    printf("Fin de partie!");
    exit(0);
}

void afficherPlateau(char** tableau, int nbLignes, int nbColonnes) {
    for (int i = 0; i < nbLignes; i++){
       for (int j = 0 ; j< nbColonnes ; j++){
            printf("%2c", tableau[j][i]);
        }
        printf("\n");
    }
}

void lireColonne(char pionJoueur, int *colJoueur) {
    printf("Colonne joueur %c ? ", pionJoueur);
    int temp;
    scanf("%d", &temp);
    *colJoueur = temp;
}

void placerPion(char** tableau, char pionJoueur, int numColonne, int colJoueur, int *remplissageCol) {
    if (colJoueur > 0 && colJoueur <= numColonne){
        tableau[colJoueur-1][remplissageCol[colJoueur-1]] = pionJoueur;
        remplissageCol[colJoueur-1]--;
    }
}

void ajouterColonne(char** tableau, int nbLignes, int *nbColonnes, int *remplissageCol) {
    int nbCol = *nbColonnes;
    nbCol++;
    tableau = (char **) realloc(tableau, nbCol*sizeof(char *));
    tableau[nbCol-1] = (char *) malloc(nbLignes*sizeof(char));
    remplissageCol[nbCol-1] = nbLignes-1;
    for (int i = 0; i < nbLignes ; i++){
        tableau[nbCol-1][i] = '.';
    }
    *nbColonnes = nbCol;
}

void supprimerColonne(char** tableau, int *nbColonnes, int colADetruire, int *remplissageCol) {
    int nbCol = *nbColonnes;
    free(tableau[colADetruire]);
    // On decale toutes les colonnes vers la gauche
    for (int j = colADetruire; j < nbCol; j++){
        tableau[j] = tableau[j+1];
        remplissageCol[j] = remplissageCol[j+1];
    }
    nbCol--;
    // Ici taille logique == taille physique
    tableau = (char **) realloc(tableau, nbCol*sizeof(char *));
    *nbColonnes = nbCol;
}