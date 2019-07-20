from turtle import *
from random import randint


#creating grid
for step in range(15):
    write(step, align = 'center')
    pendown()
    right(90)
    forward(150)
    penup()
    backward(150)
    left(90)
    forward(20)

#hiding arrow
penup()
goto(0,0)
pendown()
hideturtle()

#creation of turtles
bob = Turtle()
bob.penup()
bob.goto(-20,-10)
bob.pendown()
bob.color('red')
bob.shape('turtle')

bib = Turtle()
bib.penup()
bib.goto(-20,-30)
bib.pendown()
bib.color('gold')
bib.shape('turtle')

beb = Turtle()
beb.penup()
beb.goto(-20,-50)
beb.pendown()
beb.color('navy')
beb.shape('turtle')

bab = Turtle()
bab.penup()
bab.goto(-20,-70)
bab.pendown()
bab.color('black')
bab.shape('turtle')

bub = Turtle()
bub.penup()
bub.goto(-20,-90)
bub.pendown()
bub.color('green')
bub.shape('turtle')

#animate turtle to make 2 turn on themself
for j in range(8):
    bob.left(90)
    bib.right(90)
    beb.left(90)
    bab.right(90)
    bub.left(90)

#go for the run
for i in range(100):
    bob.forward(randint(1,5))
    bib.forward(randint(1,5))
    beb.forward(randint(1,5))
    bab.forward(randint(1,5))
    bub.forward(randint(1,5))