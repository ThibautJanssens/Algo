const readlineSync = require("readline-sync");

//By reusing the function rand10() created in Exercise 2, 
//write a function named multiRand(n) that returns an array of n numbers between 1 and 10. 
//You should not modify anything in rand10() to achieve this.
//Use that function to create a program that will ask the number of random numbers to generate 
//then display that same number of random numbers.

function rand10(){
    return Math.floor((Math.random() * 10) + 1);
}

function multiRand(n){
    let toRet = new Array();
    let i = 0;
    while(i < n){
        toRet[i] = rand10();
        i++;
    }
    return toRet;
}

let number = readlineSync.question("How many random number do you want? ");
let tab = new Array();
tab = multiRand(number);

console.log(tab);

