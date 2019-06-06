CFLAGS = -std=c11 -pedantic -Wvla -Wall -Werror

all : erot13 derot13 epolybe depolybe

erot13 : rot13.o encrypt.o
	cc $(CFLAGS) -o erot13 encrypt.o rot13.o

derot13 : rot13.o decrypt.o
	cc $(CFLAGS) -o derot13 decrypt.o rot13.o
	
#epolybe : polybe.o encrypt.o
#	cc $(CFLAGS) -o epolybe encrypt.o polybe.o

#depolybe : polybe.o decrypt.o
#	cc $(CFLAGS) -o depolybe decrypt.o polybe.o

encrypt.o : encrypt.c crypt.h
	cc $(CFLAGS) -c encrypt.c

decrypt.o : decrypt.c crypt.h
	cc $(CFLAGS) -c decrypt.c

rot13.o : rot13.c crypt.h
	cc $(CFLAGS) -c rot13.c

#polybe.o : polybe.c crypt.h
#	cc $(CFLAGS) -c polybe.c

clean :
	rm *.o
	rm erot13
	rm derot13
#	rm epolybe
#	rm depolybe
