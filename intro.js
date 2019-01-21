const readlineSync = require("readline-sync");
/*
//ex1 Define a variable and display it in the console.
let name = "bob";
console.log(name);

//ex2 Define three variables: name, firstName and city. 
//Display them like this: "Your name is Gerard Lambert and you live in Paris.".
let name = "Lambert";
let firstName = "Gerard";
let city = "Paris";

console.log("Your name is " + firstName + " " + name + " and you live in " + city + ".");


//ex3 Ask the user to enter its first name and display a message saying "Hello first name".
let name = readlineSync.question("What is you name?");
console.log("Hello " + name);

//ex4 Make this same thing as Exercise 2 but this time ask the user for the name, 
//the first name and the city.
let name = readlineSync.question("What is your name?");
let firstName = readlineSync.question("What is your first name?");
let city = readlineSync.question("Where do you live?");

console.log("Your name is " + firstName + " " + name + " and you live in " + city + ".");

//ex5 Ask two numbers with decimal part to the user. 
//For the first one only keep the integer part. 
//Then multiply them and display the result.
let number1 = readlineSync.question("Can you enter one decimal number?");
let number2 = readlineSync.question("Can you enter a second decimal number?");

number1.split('.');
let integerFirstNumber = 0;
for(let i = 0; i < number1.length; i++){
    if(number1[i] !== '.')
        integerFirstNumber += number1[i];
    else
        break;
} 

console.log("Integer part of your first number is : " + integerFirstNumber);
console.log("Multiply this with your second number, and you get = " + integerFirstNumber * number2); 

//ex6 Like the previous exercice but this time divide them and 
//display the rest of the integer division of the two numbers.
let number1 = readlineSync.question("Can you enter one decimal number?");
let number2 = readlineSync.question("Can you enter a second decimal number?");

number1.split('.');
number1.split('.');
let integerFirstNumber = 0;
for(let i = 0; i < number1.length; i++){
    if(number1[i] !== '.')
        integerFirstNumber += number1[i];
    else
        break;
} 

console.log("Integer part of your first number is : " + integerFirstNumber);
var quotient = Math.floor(integerFirstNumber/number2);
console.log("Result of division = " + quotient);
var remainder = integerFirstNumber % number2;
console.log("remainder : " + remainder); 

/*ex7 Ask to the user its shoe size and its birth year. Then make the following calculation:
    Multiply the shoe size by 2
    Add 5 to the result
    Multiply that by 50
    Subtract the birth year
    Add 1766
Test with your own birth year and your shoe size.
let shoeSize = readlineSync.question("What is your shoe size?");
let birthYear = readlineSync.question("What is your year of birth?");
let magic = ((((2 * shoeSize) + 5) * 50) - birthYear + 1766);
console.log("Let the magic happen: " + magic);

/*ex8
Create a "Story Teller".
Ask questions to the user about different things. 
Store the results he gives to you. 
Display them in a way that it creates a fun story!
Bonus: when you ask questions to the user he should be able to see 
how many questions remain to be asked.*/
let counter = 0;
let max = 5;
let answers = new Array();

answers[counter] = readlineSync.question("What the name of your pet? (" + (counter+1) + "/" + max+") ");
counter ++;
answers[counter] = readlineSync.question("What year are you in? (" + (counter+1) + "/" + max+") ");
counter ++;
answers[counter] = readlineSync.question("If you can go an adventure what would it be? (" + (counter+1) + "/" + max+") ");
counter ++;
answers[counter] = readlineSync.question("Who would be your nemesis? Every adventurer has a nemesis. (" + (counter+1) + "/" + max+") ");
counter ++;
answers[counter] = readlineSync.question("What would be his weakness? (" + (counter+1) + "/" + max+") ");
counter ++;

console.log(" ");
console.log("This is the story of " + answers[0]);
console.log("---------------------");
console.log("It all started in " + answers[1]);
console.log(" ");
console.log("The mighty "+ answers[0] + " wanted to go on an epic journey to " + answers[2] + " but as every adventurer, he had his worst enemy. The fearfull " + answers[3]);
console.log(answers[3] + " was indeed well known for his habbit to steal all the girl's panties and putting in jail every man he encountered so he could have is harem.");
console.log("Little did he know that our hero, " + answers[0] + " knew his only weakness: " + answers[4]);
console.log("What will happen during this journey ? Will our hero achieve his objectif ? Only the futur will tell us..." );
