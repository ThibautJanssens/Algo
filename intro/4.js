const readlineSync = require("readline-sync");

//ex4 Make this same thing as Exercise 2 but this time ask the user for the name, 
//the first name and the city.
let name = readlineSync.question("What is your name?");
let firstName = readlineSync.question("What is your first name?");
let city = readlineSync.question("Where do you live?");

console.log("Your name is " + firstName + " " + name + " and you live in " + city + ".");
