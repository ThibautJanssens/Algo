const readlineSync = require("readline-sync");

//ex5 Ask two numbers with decimal part to the user. 
//For the first one only keep the integer part. 
//Then multiply them and display the result.
let number1 = readlineSync.question("Can you enter one decimal number?");
let number2 = readlineSync.question("Can you enter a second decimal number?");

number1.split('.');
let integerFirstNumber = 0;
for(let i = 0; i < number1.length; i++){
    if(number1[i] !== '.')
        integerFirstNumber += number1[i];
    else
        break;
} 

console.log("Integer part of your first number is : " + integerFirstNumber);
console.log("Multiply this with your second number, and you get = " + integerFirstNumber * number2); 