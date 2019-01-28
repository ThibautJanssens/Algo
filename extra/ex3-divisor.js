/*
Make a program that asks for a positive integer. The display all the divisors of that integer.

Examples:

    7 => nothing (it's a prime number)
    10 => 2 5
    9187 => nothing (it's a prime number too)
    134234 => 2 41 82 1637 3274 67117
*/
const readlineSync = require("readline-sync");

function divisor(n){
    let toRet = new Array();
    for(let i = 1; i < n; i++){
        if(n%i == 0)
            toRet.push(i);
    }
    return toRet;
}

let number = parseInt(readlineSync.question("Enter a number to get his divisors: "));
let divs = divisor(number);
console.log("Divisors : " + divs);

