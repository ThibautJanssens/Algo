const readlineSync = require("readline-sync");

//Write a program that will calculate the average value of a given array.
let numbers = new Array();

let size = readlineSync.question("How many elements in your array? ");
let i = 0;
while (i < size){
    numbers[i] = readlineSync.question("Enter a new number ");
    i++;
}

let avg = 0;
for(i = 0; i < size; i++){
    avg += parseInt(numbers[i]);
}
avg /= parseInt(size);

console.log("Average = " + avg);