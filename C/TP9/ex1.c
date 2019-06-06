#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>

#define TAILLE 256

int main(int argc, char *argv[]) {

    int tailleTab = (argc-1);
    int i, j, nbreMotsLusPasTrouves = 0;
    char** tabDyn = (char**) malloc(tailleTab*sizeof(char*));  
    bool present;

    for(i = 1 ; i < argc ; i++) {
        // Bonus 2 : Évitez qu’un même mot se retrouve deux fois dans le lexique constitué des arguments de la ligne de commande.
        present = false;
        for(j = 0 ; j < i ; j++) {
            if(tabDyn[j] == argv[i]) {
                present = true;
                tailleTab--;
                break;
            }
        }
        if(!present) {
            tabDyn[i-1] = (char*) malloc((strlen(argv[i])+1)*sizeof(char));
            strcpy(tabDyn[i-1], argv[i]);
        }  
    }
    if(tailleTab != (argc-1)) {
        tabDyn = (char**) realloc(tabDyn, tailleTab);
    }

    char mot[TAILLE];
    int n;
    while(fgets(mot, TAILLE, stdin) != NULL) {
        n = strlen(mot);
        mot[n-1] = '\0';
        printf("Le mot lu est '%s' et sa longueur est de %d\n", mot, n-1);
        present = false;
        char lettre;
        // Bonus 3 : Modifiez votre programme afin que la recherche d’un mot soit insensible à la casse.
        for(i = 0 ; i < strlen(mot) ; i++) {
            lettre = mot[i];
            mot[i] = tolower(lettre);
            // Bonus 1 : Modifiez votre programme afin que seules les lettres composant le mot entré
            // soient enregistrées et non les white spaces (i.e. espaces, passages à la ligne, etc.).
            // Possibilité de faire avec deux pointeurs (écriture et lecture) : plus propre
            if((lettre < 'a' || lettre > 'z') && (lettre < 'A' || lettre > 'Z')) {
                for(j = i ; j < strlen(mot) ; j++) {
                    mot[i] = mot[j];
                }
            }
        }
        //printf("Tolower : %s\n", mot);

        for(i = 0 ; i < tailleTab ; i++){
            if(strcmp(tabDyn[i], mot) == 0) {
                printf("Présent\n");
                present = true;
                break;
            }
        }
        if(!present) {
            printf("Absent\n");
            nbreMotsLusPasTrouves++;
        }
    }
    printf("%d mot(s) pas trouvé(s) dans la table", nbreMotsLusPasTrouves);

    for(i = 0 ; i < tailleTab ; i++) {
        free(tabDyn[i]);
    }
    free(tabDyn);

return 0;
}