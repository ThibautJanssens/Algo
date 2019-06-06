#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TAILLE_MIN_TABLEAU 2
#define TAILLE_LIGNE 256

int main(){

    int taillePhysique = TAILLE_MIN_TABLEAU;
    int tailleLogique = 0;

    char **table = (char**) malloc(TAILLE_MIN_TABLEAU*sizeof(char*));

    char ligne[TAILLE_LIGNE];
    int longueur, i;
    while(fgets(ligne, TAILLE_LIGNE, stdin) != NULL) {
        longueur = strlen(ligne);
        ligne[longueur-1] = '\0';
        if(tailleLogique == 0) {
            table[0] = (char*) malloc(longueur*sizeof(char));
            strcpy(table[0], ligne);
            tailleLogique++;

        } else {
            if(tailleLogique == taillePhysique-1) {
                table = (char**) realloc(table, taillePhysique*2);
                taillePhysique *= 2;
            }

            for(i = 0 ; i < tailleLogique ; i++) {
                if(strncmp(ligne, table[i], 5) == 0) {
                    table[i] = (char*) realloc(table[i], strlen(table[i]+longueur-4));
                    strcat(table[i], ligne+5);
                    break;
                } else {
                    table[tailleLogique] = (char*) malloc(longueur*sizeof(char));
                    strcpy(table[tailleLogique], ligne);
                    tailleLogique++;
                    break;
                }     
            } 
        }
        
    }

    for(i = 0 ; i < tailleLogique ; i++) {
        printf("%s\n", table[i]);
    }

    for(i = 0 ; i < tailleLogique ; i++) {
        free(table[i]);
    }
    free(table);
    return 0;
}