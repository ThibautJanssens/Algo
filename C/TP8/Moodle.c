// 1. Ecrivez un programme qui calcule et affiche la longueur d'une chaîne lue à l'entrée standard (sans appeler strlen).
/*#include <stdlib.h>
#include <stdio.h>

ligne, fw

int main () {
    char ligne[TAILLE];
    if (fgets(ligne, TAILLE, stdin) == NULL)
        exit(0);

    int longueurChaine = 0, i = 0;
    while(ligne[i] != '\0'){
        longueurChaine++;
        i++;
    }
    printf("%d", longueurChaine);

    exit(0);
}*/ 


// 2
/*#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define TAILLE 256

int main () {
    char ligne[TAILLE];
    while (fgets(ligne, TAILLE, stdin) != NULL) {
        int n = strlen(ligne);
        ligne[n-1] = '\0';
        printf("%s",ligne);
    }
    exit(0);
}*/

// 3
/*#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define TAILLE 256

int main () {
    char ligne[TAILLE];
    if (fgets(ligne, TAILLE, stdin) == NULL)
        exit(0);
    ligne[strlen(ligne)-1] = '\0';  // suppression du '\n'

    int length = strlen(ligne);
    char temp;
    for(int i = 0 ; i < (length/2) ; i++){
        //printf("%d : \n", i);
        temp = ligne[i];
        //printf("%c\n", temp);
        ligne[i] = ligne[length-i-1];
        //printf("%c\n", ligne[i]);
        ligne[length-i-1] = temp;
        //printf("%d\n\n", ligne[length-i-1]);
    }

    printf("%s",ligne);
    exit(0);
}*/
// 4
/*#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main () {
    const char phrase[] = "Je suis etudiant en informatique.";
    int longueur = strlen(phrase);
    char* nouvellePhrase;

    if ((nouvellePhrase = (char*)malloc(longueur*sizeof(char))) == NULL){
        perror("Malloc KO\n");
        return 1;
    }
    char c;
    for(int i = 0 ; i < longueur ; i++) {
        c = toupper((char) phrase[i]);
        strcpy(&nouvellePhrase[i], &c);
    }

    printf("%s", nouvellePhrase);

    exit(0);
}*/

// 5
#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
#include <string.h>

#define TAILLE 256

int main() {
    char s[TAILLE];
    if(fgets(s, TAILLE, stdin) == NULL)
        exit(0);
    s[strlen(s)-1] = '\0';

    int alphabet[26], i;

    for(i = 0 ; i < 26 ; i++){
        alphabet[i] = 0;
    }

    for(i = 0 ; i < strlen(s) ; i++) {
        alphabet[tolower(s[i]) - 'a']++;
    }

    for(i = 0 ; i < 26 ; i++){
        if(alphabet[i] != 0)
            printf("%d * '%c'\n", alphabet[i], i + 'a');
    }

    exit(0);

}


