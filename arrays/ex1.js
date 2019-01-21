const readlineSync = require("readline-sync");

//Write a program that will add all the elements of an array.
let numbers = new Array();

let size = readlineSync.question("How many elements in your array? ");
let i = 0;
while (i < size){
    numbers[i] = readlineSync.question("Enter a new number ");
    i++;
}

let sum = 0;
for(i = 0; i < size; i++){
    sum += parseInt(numbers[i]);
}

console.log("Sum = " + sum);