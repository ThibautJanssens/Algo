const readlineSync = require("readline-sync");

//Create a function factorial(a) that returns the factorial of a number.
//That function must be recursive.
function factorial(x){
    if(x === 0 || x === 1)
        return 1;
    else
        return factorial(x-1) * x;
}

let number = readlineSync.question("Give the number to calculate his factorial. ");
console.log(factorial(number));