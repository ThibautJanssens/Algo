CFLAGS = -std=c11 -pedantic -Wvla -Wall -Werror

biblio : biblio.o
	cc $(CFLAGS) -o biblio biblio.o

biblio.o : biblio.c biblio.h
	cc $(CFLAGS) -c biblio.c

clean : 
	rm *.o
	rm biblo

