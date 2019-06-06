#include "crypt.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]) {
	int i;

	char** toRet = (char**) malloc((argc-1) * sizeof(char*));
	for(i = 0; i < argc; i++){
		char* toRet[i] = (char*) malloc(strlen(toRet[i]) * sizeof(char));
	}

	for (i = 0; i < argc ; i++) {
		toRet[i] = encrypt(argv[i+1]);
	}

	printf("La phrase cryptée:\n");
	for (i = 0; i < argc ; i++) {
		printf("%s\n", toRet[i]);
	}

    return 0;
}