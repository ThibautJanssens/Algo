/*
Make a program that generates an integer between 1 and 100 (don't display it to the user).

Then the program should display "Guess the number" and ask the user to guess. 
If the user enters a number which is too low it should display "Too low" and re-ask the question. 
If the user enters a number which is too high it should display "Too high" and re-ask the question. 
If the user guess correctly it should display "Well guessed!" and exit.
*/
const readlineSync = require("readline-sync");

let userChoice = readlineSync.question("Choose a number. ");
let randomNumber = rand(userChoice);

let userAnswer = readlineSync.question("Now find the correct number between 1-"+userChoice);

while(userAnswer != randomNumber){
    if(userAnswer > randomNumber){
        userAnswer = readlineSync.question("Too high, try again: ");
    }else{
        userAnswer = readlineSync.question("Too low, try again: ");
    }
}
console.log("Well guessed.");

//generate a random number between 1 and max
function rand(max){
    return Math.floor((Math.random() * parseInt(max)) + 1);
}