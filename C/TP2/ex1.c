#include <stdlib.h>
#include <stdio.h>
#include <limits.h>

//#define N 12

int main(){

    int N;
    while(N = getchar() != EOF){
        N -= 48;
        putchar(N);
        int facto = 1;

        for(int i = 0 ; i < N ; i++) {
            facto *= (N-i);
        }

        /*int i = 0;
        while(i < N && facto < (INT_MAX / (N-i))) {
            facto *= (N-i);
            i++;
        }

        if(i < N  && facto > (INT_MAX / (N-i))) {
            perror("Dépassement de capacité");
            exit(1);
        }*/

        printf("%d! = %d\n", N, facto);
        printf("Valeur max d'un INT : %d\n:", INT_MAX);
    }

    return 0;
}