const readlineSync = require("readline-sync");

/*ex7 Ask to the user its shoe size and its birth year. Then make the following calculation:
    Multiply the shoe size by 2
    Add 5 to the result
    Multiply that by 50
    Subtract the birth year
    Add 1766
Test with your own birth year and your shoe size.*/

let shoeSize = readlineSync.question("What is your shoe size?");
let birthYear = readlineSync.question("What is your year of birth?");
let magic = ((((2 * shoeSize) + 5) * 50) - birthYear + 1766);
console.log("Let the magic happen: " + magic);