//1. Ecrivez un programme qui calcule et 
//affiche la longueur d'une chaîne lue à l'entrée standard 
//(sans appeler strlen).

#include <stdlib.h>
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
}