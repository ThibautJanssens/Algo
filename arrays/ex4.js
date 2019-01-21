const readlineSync = require("readline-sync");

//Write a program that will display the minimum and maximum elements of a given array.
let tab = new Array();
let size = readlineSync.question("How many elements in your array? ");
let i = 0;

while (i < size){
    tab[i] = readlineSync.question("Enter a new number ");
    i++;
}

let min = parseInt(tab[0]);
let max = parseInt(tab[0]);

for(i=0; i < size; i++){
    if(min > parseInt(tab[i])){
        min = tab[i];
    }
    else if(parseInt(tab[i]) > max){
        max = tab[i];
    }
}
console.log("min = " + min + " max = " + max);