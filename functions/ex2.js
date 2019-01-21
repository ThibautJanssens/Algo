//Create a function named rand10() that returns a random integer between 1 and 10. 
//Create a program that will display the result of that function each time it is run.

function rand10(){
    return Math.floor((Math.random() * 10) + 1);
}

console.log(rand10());