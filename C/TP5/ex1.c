#include <stdlib.h>
#include <stdio.h>

int main() {
    int n = 0, nbreNegatifs = 0, nbrePositifs = 0, temp = 0, i = 0;
    int *tableau;

    printf("Valeur de n : ");
    scanf("%d", &n);

    if((tableau = (int*) malloc(n*sizeof(int))) == NULL) {
        perror("Error malloc");
        exit(0);
    }

    for(i = 0 ; i < n ; i++) {
        printf("Valeur %d : ", i);
        scanf("%d", &temp);
        if(temp < 0) {
            nbreNegatifs++;
        } else {
            nbrePositifs++;
        }
        *(tableau+i) = temp;
    }

    int *tableauPositifs, *tableauNegatifs;

    if((tableauPositifs = (int*) malloc(nbrePositifs*sizeof(int))) == NULL) {
        perror("Error malloc");
        exit(0);
    }

    if((tableauNegatifs = (int*) malloc(nbreNegatifs*sizeof(int))) == NULL) {
        perror("Error malloc");
        exit(0);
    }

    for(i = 0 ; i < n ; i++) {
        temp = *(tableau+i);
        if(temp < 0) {
            *tableauNegatifs = temp;
            tableauNegatifs++;
        } else {
            *tableauPositifs = temp;
            tableauPositifs++;
        }
    }

    tableauNegatifs -= nbreNegatifs;
    tableauPositifs -= nbrePositifs;

    for(i = 0 ; i < nbreNegatifs ; i++) {
        printf("%d ", *tableauNegatifs);
        tableauNegatifs++;
    }

    for(i = 0 ; i < nbrePositifs ; i++) {
        printf("%d ", *tableauPositifs);
        tableauPositifs++;
    }

    tableauNegatifs -= nbreNegatifs;
    tableauPositifs -= nbrePositifs;

    free(tableau);
    free(tableauPositifs);
    free(tableauNegatifs);

    return 0;
}