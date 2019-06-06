#include <stdlib.h>
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
}