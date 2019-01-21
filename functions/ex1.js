const readlineSync = require("readline-sync");

//Create a function named calcSurface that takes the length and width of a rectangle and 
//returns its surface. Then create a program that asks the length and with of a 
//rectangle to the user then displays the surface of that rectangle. 
//That program must use the function you created.

function calcSurface(length, width){
    return length * width;
}

let length = readlineSync.question("Give a length for a rectangle. ");
let width = readlineSync.question("Give a width for a rectangle. ");

console.log("Surface = " + calcSurface(length, width));