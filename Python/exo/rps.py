#imports
from random import *

game = input("Do you want to play some rock paper scissor? Y - N\n")

#user is not giving right answer to the question
while not(game.lower() == "y" or game.lower() == "n"):
    print("Please respond with 'Y' or 'N' only.")
    game = input("Do you want to play some rock paper scissor? Y - N\n")

#user doesn't want to play
if(game.lower() == "n"):
    print("Mayber later. Cya then.")

#user will play
else:
    signs = ["rock", "paper", "scissor"]
    userChoice = input("Choose your sign: Rock - Paper - Scissor\n")
    
    #user never played rock paper scissor obviously
    while not(userChoice.lower() == "rock" or userChoice.lower() == "paper" or userChoice.lower() == "scissor" ):
        print("Have you ever played rock-paper-scissor bro?... Choose a valid option.")
        userChoice = input("Choose your sign: Rock - Paper - Scissor\n")
    
    randomNumber = randint(0, 2)
    computerChoice = signs[randomNumber]

    #same choice with the computer
    if (computerChoice == userChoice):
        print("There is no winner. You choose: " + userChoice + " so does the computer: " + computerChoice)
    #user wins
    elif ((computerChoice == "rock" and userChoice == "paper") or (computerChoice == "scissor" and userChoice == "rock") or (computerChoice == "paper" and userChoice == "scissor")):
        print("You win ! Computer = " + computerChoice + " | you = " + userChoice)
    #user loses
    else:
        print("You lose...Computer = " + computerChoice + " | you = " + userChoice)
