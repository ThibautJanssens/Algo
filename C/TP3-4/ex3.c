#include <stdio.h>

#define M 10
#define N 10

int main() {
    printf("m : ");
    int m = getchar();
    printf("\nn : ");
    int n = getchar();

    int matrice[M][N];
    char lettre = 'A';

    for(int i = 0 ; i < m ; i++) {
        for(int j = 0 ; j < n ; j++) {
            matrice[i][j] =  lettre;
            if(lettre == 'Z') {
                lettre = 'A';
            } else {
                lettre++;
            }
        }
    }

    for(int i = 0 ; i < m ; i++) {
        for(int j = 0 ; j < n ; j++) {
            printf("%d", matrice[i][j]);
        }
    }
}