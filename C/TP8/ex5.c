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