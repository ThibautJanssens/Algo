#include <stdlib.h>
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
}