#include "crypt.h"
#include <string.h>

char* encrypt(char* target){
    int i = 0;

    for(i = 0; i < strlen(target-1) ; i++){
        if(target[i] >= 'a' && target[i] <= 'm')
            target[i] += DECAL;
        else if(target[i] <= 'z' && target[i] >= 'n')
            target[i] -= DECAL;
    }
    return target;
}

char* decrypt(char* target){
   return encrypt(target);
}