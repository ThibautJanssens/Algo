const readlineSync = require("readline-sync");

//Ex2 - Ask the user to enter three numbers: min, max and current. 
//Display if current is between min and max.
//Bonus: if min is greater than max, 
//display an error message to explain the user he's doesn't understand anything then exit the program.
// (It must not ask any other question.)
//Bonus 2: be polite in the error messages. (facultative)
let min = readlineSync.question("Can you enter a min? ");
let max = readlineSync.question("Can you enter a max? ");
let current = readlineSync.question("Can you enter a current? ");
console.log("min = " + min + " max = " + max + " current = " + current);
if(min > max)
    console.error("Min is greater than max");