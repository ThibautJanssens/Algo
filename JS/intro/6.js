const readlineSync = require("readline-sync");

//ex6 Like the previous exercice but this time divide them and 
//display the rest of the integer division of the two numbers.
let number1 = readlineSync.question("Can you enter one decimal number?");
let number2 = readlineSync.question("Can you enter a second decimal number?");

number1.split('.');
number1.split('.');
let integerFirstNumber = 0;
for(let i = 0; i < number1.length; i++){
    if(number1[i] !== '.')
        integerFirstNumber += number1[i];
    else
        break;
} 

console.log("Integer part of your first number is : " + integerFirstNumber);
var quotient = Math.floor(integerFirstNumber/number2);
console.log("Result of division = " + quotient);
var remainder = integerFirstNumber % number2;
console.log("remainder : " + remainder); 
