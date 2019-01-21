const readlineSync = require("readline-sync");

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
