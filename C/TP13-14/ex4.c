#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>

#define TAILLE_LIGNE 256
#define DEFAULT_SIZE 6

void imprimerTable(char* leg, int** tab, int sz);
char* lireLigne();
bool ajouterTable(int* *tab, int *tailleL, int *tailleP, int x);
int chargerTable(char* mots, int nbrMots, int** tab, int tailleP);

int main(int argc, char *argv[]) {
    lireLigne();
    return 0;
}

void imprimerTable(char* leg, int** tab, int sz){
    printf("%s\n", leg);
    for(int i = 0 ; i < sz ; i++) {
        printf("%ls\n", tab[i]);
    }
}

char* lireLigne(){
       char buf[6];
       fgets(buf, 6, stdin);

    /*
       stdin => a b c d e f g h i j k l \n ...
                ---------|---------|------|
                malloc     realloc   end car \n
                strcpy     strcat
                           boucle tant que pas de \n
     */

    chargerTable(mots, nbreLits, tab, tailleP);
}

bool ajouterTable(int* *tab, int *tailleL, int *tailleP, int x){
    if(*tailleL == 0){
        *tailleP = DEFAULT_SIZE;
        if((*tab = (int*) malloc(*tailleP * sizeof(int *))) == NULL) {
            perror("malloc");
            return false;
        }
    }

    else if(*tailleL == *tailleP){
        *tailleP *= 2;
        if((*tab = (int*) realloc(*tab, *tailleP * sizeof(int *)))==NULL){
            perror("realloc");
            return false;
        }
    }
    *tab[*tailleL] = x;
    (*tailleL)++;
    return true;
}

int chargerTable(char* mots, int nbrMots, int** tab, int tailleP){

    ajouterTable(tab, tailleL, tailleP, x);
    return tailleL;
}