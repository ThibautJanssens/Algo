const readlineSync = require("readline-sync");

//Make a program that ask the user to enter a number between 1 and 7. 
//Depending on the number, display the day of the week that correspond. 
//(1 => Monday, 2 => Tuesday, etc...)
const days = ["Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"];
let number = readlineSync.question("Enter a number between 1 and 7 ");

while(number > 7 || number < 1){
    number = readlineSync.question("Enter a number between 1 and 7 ");
}

console.log("The day you choose is " + days[number-1])
