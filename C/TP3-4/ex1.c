#include <stdio.h>
#include <stdlib.h>

#define NUMBER_STUDENTS 50


int main() {

    double notes[NUMBER_STUDENTS];
    double moyenne = 0, ecart = 0, variance = 0;
    
    double note;
    int nbNotes = 0;
    while((scanf("%lf", &note) != EOF) && (nbNotes < NUMBER_STUDENTS-1)) {
        notes[nbNotes] = note;
        moyenne += note;
        nbNotes++;
    }
    moyenne /= nbNotes;
    printf("\n");

    for(int j = 0 ; j < nbNotes ; j++) {
        ecart = notes[j] - moyenne;
        printf("Ecart : %.2lf\n", ecart);
        variance += ecart*ecart;
    }
    variance /= nbNotes;

    printf("\nMoyenne : %.2lf\n", moyenne);
    printf("Variance : %.2lf\n", variance);

    return 0;
}