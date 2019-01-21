const readlineSync = require("readline-sync");

//Write a program that will create a duplicate of a given array.
//Bonus: make a first version that will only do it using push(). 
//Make a second version that uses a single method call to perform the copy. 
//(You'll have to search on the MDN or Google for this one.)
let tab = new Array();
let size = readlineSync.question("How many elements in your array? ");
let i = 0;

while (i < size){
    tab[i] = readlineSync.question("Enter a new number ");
    i++;
}

function copyTab(array){
    let newTab = new Array();
    for(i = 0; i < array.length; i++){
        newTab[i] = tab[i];
    }
    return newTab;
}

console.log(tab);
console.log(copyTab(tab));