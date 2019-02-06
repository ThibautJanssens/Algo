const readlineSync = require("readline-sync");

//Create a function named average(arr) that takes an array of numbers as 
//argument and returns the average.
function average(arr){
    if (arr === undefined){
        console.error("Array undefined.");
    }
    var sum = 0;
    for(let i = 0; i < arr.length; i++){
        sum += parseInt(arr[i]);
    }
    return sum /= arr.length;
}
//Create a function named min(arr) that takes an array of numbers as argument and 
//returns the minimum element.
function min(arr){
    if (arr === undefined){
        console.error("Array undefined.");
    }
    var min = arr[0];
    for(let i = 0; i < arr.length; i++){
        if(min > arr[i]){
            min = parseInt(arr[i])
        }
    }
    return min;
}
//Create a function named max(arr) that takes an array of numbers as argument and 
//returns the maximum element.
function max(arr){
    if (arr === undefined){
        console.error("Array undefined.");
    }
    var max = arr[0];
    for(let i = 0; i < arr.length; i++){
        if(max < arr[i]){
            max = parseInt(arr[i])
        }
    }
    return max;
}
//Create a program that asks a number to the user then generate that same amount of 
//random numbers but also displays their average, min and max. 
//To do so, use the three functions you just created as well as the multiRand(n) 
//function created in Exercise 3.
function generate(number){
    if (number === undefined){
        console.error("Array undefined.");
    }
    let tab = new Array();
    tab = multiRand(number);
    let minimum = min(tab);
    let maximum = max(tab);
    let avg = average(tab);   

    return [tab, avg, minimum, maximum];

}

//get random number 1-10
function rand10(){
    return Math.floor((Math.random() * 10) + 1);
}

//generate a array with n number or random.
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
var returns = new Array();
returns = generate(number);
console.log("random tab: " + returns[0]);
console.log("avg: " + returns[1]);
console.log("min: " + returns[2]);
console.log("max:" + returns[3]);
