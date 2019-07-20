from turtle import *
from random import randint
from threading import Thread
import time

bob = Turtle()
bob.penup()
bob.goto(90,0)
bob.pendown()
bob.color('red')
bob.shape('turtle')

bib = Turtle()
bib.penup()
bib.goto(-45,-45)
bib.pendown()
bib.color('gold')
bib.shape('turtle')

beb = Turtle()
beb.penup()
beb.goto(-90,0)
beb.pendown()
beb.color('navy')
beb.shape('turtle')

bab = Turtle()
bab.penup()
bab.goto(0,0)
bab.pendown()
bab.color('black')
bab.shape('turtle')

bub = Turtle()
bub.penup()
bub.goto(45,-45)
bub.pendown()
bub.color('green')
bub.shape('turtle')

class Olymp(Thread):

    def __init__(self, tur):
        Thread.__init__(self)
        self.tur = tur
        
    def run(self):
        for i in range(360):
            self.tur.left(1)
            self.tur.forward(1)
            wait = 0.2
            wait += randint(1,60) / 100
            time.sleep(wait)

thread1 = Olymp(bob)
thread2 = Olymp(bub)
thread3 = Olymp(bib)
thread4 = Olymp(bab)
thread5 = Olymp(beb)

thread1.start()
thread2.start()
thread3.start()
thread4.start()
thread5.start()

thread1.join()
thread2.join()
thread3.join()
thread4.join()
thread5.join()
