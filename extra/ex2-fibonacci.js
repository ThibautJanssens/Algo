/*
Make a program that asks for an integer n and generates the n first Fibonacci numbers.

Yes, you'll have to search what the hell are Fibonacci numbers.
*/
const readlineSync = require("readline-sync");

function fibonacci(n){
    if(n == 0)
        return 0;
    if(n == 1)
        return 1;
    return fibonacci(n-1) + n;
}


let userChoice = parseInt(readlineSync.question("Choose a number. "));
console.log(fibonacci(userChoice));