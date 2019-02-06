const readlineSync = require("readline-sync");

//ex3 Ask the user to enter its first name and display a message saying "Hello first name".
let name = readlineSync.question("What is you name?");
console.log("Hello " + name);