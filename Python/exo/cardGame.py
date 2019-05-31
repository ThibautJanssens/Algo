from random import *

class Card:    
    #constructor
    def __init__(self, color, rank):
        self.color = color
        self.rank = rank
     
    #toString() equivalent
    def __str__(self):
        return self.rank + "" + self.color
# --------------------  ENF OF CLASS CARD -------------------- 

class Game:    
    #constructor
    def __init__(self):
        colorList = ["♠", "♥", "♦", "♣"]
        
        ranks = {
            "2":2,
            "3":3,
            "4":4,
            "5":5,
            "6":6,
            "7":7,
            "8":8,
            "9":9,
            "10":10,
            "Valet": 11,
            "Dame": 12,
            "Roi": 13,
            "As":14
        }
        
        self.deck  = [] 
        
        for color in colorList:
            for rank in ranks:
                card = Card(color, rank)
                self.deck.append(card)
        shuffle(self.deck)

    def __str__(self):
         toRet = ""
         for card in self.deck:
             toRet += str(card) + "\n"
         return toRet
    
    def drawCard():
        return self.deck.pop()
    
    def getValue(rank):
        return ranks[rank]
    
    def addCard(card):
        self.deck.append(card)
    
    def addPile(pile):
        while not (is_empty(pile)):
            self.deck.append(pile.pop())

# --------------------  ENF OF CLASS GAME --------------------

class Player(Game):
    def __init__(self, name):
        self.name = name
    
    def __str__(self):
        return ""+self.name
# --------------------  ENF OF CLASS GAME --------------------

username = input("Give the username of player 1\n")
p1 = Player(username)
username = input("Give the username of player 2\n")
p2 = Player(username)

p1Score = 0
p2Score = 0
pile = []

while (is_empty(p1.deck) or is_empty(p2.deck)):
    p1Card = p1.drawCard
    print(p1Card)
    
    p2Card = p2.drawCard
    print(p2Card)
    
    if(p1.getValue(p1Card.rank) > p1.getValue(p2Card.rank)):
        winner = p1
        p1.addCard(p1Card)
        p1.addCard(p2Card)
        p1.addPile(pile)
        p1Score += 1

    elif(p1.getValue(p1Card.rank) < p1.getValue(p2Card.rank)):
        winner = p2
        p1.addCard(p1Card)
        p1.addCard(p2Card)
        p2Score += 1
        
    else:
        pile.append(p1Card)
        pile.append(p2Card)
        pile.append(p1.drawCard)
        pile.append(p2.drawCard)    
        
if(is_empty(p1.deck)):
    print("Winner is " + p2)
else:
    print("Winner is " + p1)