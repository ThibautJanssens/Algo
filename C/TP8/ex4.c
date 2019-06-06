#include <stdlib.h>
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
}