#include "crypt.h"
#include <stdio.h>
#include <string.h>

static char square[8][8]{
	{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'},
	{'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'},
	{'q', 'r', 's', 't', 'u', 'v', 'w', 'x'},
	{'y', 'z', '0', '1', '2', '3', '4', '5'},
	{'6', '7', '8', '9', ' ', '!', '"', '#'},
	{'$', '%', '&', '\'', '(', ')', '*', '+'},
	{',', '-', '.', '/', ':', ';', '<', '='},
	{'>', '?', '@', '[', '\\', ']', '^', '_'}
};

char* encrypt(char* target){
	int i;
	for(i = 0; i < strlen(target); i++){

	}
	return 0;
}

char* decrypt(char* target){
	return 0;
}