/*
Make an interactive program to manager your favorite pizza flavors. 
When launched it must display a menu of this style:

Hello! Welcome to the Pizza Flavors Manager.

Please choose your actions:

1 - List all the pizza flavors
2 - Add a new pizza flavor
3 - Remove a pizza flavor
4 - Exit this program

Enter your action's number:

When the user enter the number of an action he will trigger the appropriate action:

    List all the pizza flavors: Display the current list of pizza flavors. 
    (There should be none if we just launched the program.)
    Add a new pizza flavor: Ask the user for a new pizza flavor to add to the list.
    Remove a pizza flavor: Ask the user for the number of the pizza flavor in the list 
    he wants to remove.

Each time one of the action has been performed it should return to the menu. 
(Except of course if we select to exit the program.)

Bonus: Save the list of pizza flavors on the file system and reload it each time 
we launch the application.
*/
const Pizza = require("./pizza.js");
const readlineSync = require("readline-sync");
const fs = require('fs');

let pizzas = Array();

main();

//main function of the program
function main() {
    try {
        pizzas = loadFile();
        console.log("pizz" + pizzas);
    } catch {
        console.log("No file to load.\n\n");
    }

    console.log("Hello! Welcome to the Pizza Flavors Manager.");

    do {
        console.log("Please choose your actions:");
        console.log("--------------------------------------------");
        console.log("1 - List all the pizza flavors");
        console.log("2 - Add a new pizza flavor");
        console.log("3 - Remove a pizza flavor");
        console.log("4 - Exit this program");
        console.log("--------------------------------------------");

        let userChoice = parseInt(readlineSync.question("Enter your action's number: "));

        switch (userChoice) {
            case 1:
                list();
                break;
            case 2:
                let newPizza = createPizza();
                add(newPizza);
                break;
            case 3:
                remove();
                break;
            case 4:
                createFile(pizzas);
                exit();
                break;
            default:
                console.log("\nError: not a valid option, try again.\n");
                break;
        }
    } while (userChoice !== 4);
}

//show all the pizzas
function list() {
    //console.log(typeof(pizzas));
    if (pizzas.length == 0)
        console.log("There are no pizza at the moment. Please come back later.");
    else {
        for (let i = 0; i < pizzas.length; i++) {
            console.log(pizzas[i].show + '\n');
        }
    }
}

//add a pizza to the list if not already in it
function add(newPizza) {
    pizzas.push(newPizza);
}

//remove a pizza from the list, if in it
function remove(oldPizza) {
    let choice = 0;

    for (let i = 0; i < pizzas.length; i++) {
        console.log((i + 1) + ":" + pizzas[i].getName + "\n");
    }

    do {
        choice = parseInt(readlineSync.question("Which pizza do you choose to remove?\n(Give the number of the pizza)\n"));
        if (choice > pizzas.length || choice < 1)
            console.log("Error: write a number in the list.");
    } while (choice > pizzas.length || choice < 1);

    pizzas.splice(choice - 1);
}

//quit de program
function exit() {
    console.log("See you next time.");
    process.exitCode = 0;
}

//create a new pizza
function createPizza() {
    let name, toping, price = 0;
    //ask for the name, if a pizza has already this name, ask the user again
    do {
        name = readlineSync.question("What name do you want to give to your pizza? ");
        if (nameTaken(name))
            console.log("Name already in use.");
    } while (nameTaken(name));

    let topings = new Array();

    //ask the topings to the user, make a array out of it
    do {
        toping = readlineSync.question("What toping do you want on your pizza?\n('stop' to quit)\n ")
        if (toping !== "stop")
            topings.push(toping);
    } while (toping !== "stop");

    //ask the price to the user
    while (price <= 0) {
        price = parseFloat(readlineSync.question("At what price should we sell this pizza?\n(no free pizza sorry)\n"));
    }
    let newPizza = new Pizza(name, topings, price);

    return newPizza;
}

//create a JSON file with the list of all pizza;
function createFile(dict) {
    let pizzaList = JSON.stringify(dict);

    fs.writeFileSync('pizza.json', pizzaList, 'utf8', (err) => {
        if (err) throw err;
        console.log('The file has been saved!');
    });
}

//read a JSON file to get the pizzas list
function loadFile() {
    let obj, toRet = new Array();
    obj = JSON.parse(fs.readFileSync('pizza.json', 'utf8'));
    console.log("obj: " + obj);
    for (let i = 0; i < obj.length; i++) {
        toRet.push(obj[i]);
    }
    console.log(toRet);
    return toRet;
}

//compare the name of pizzas with the name given in parameter
// return true if it's the same
function nameTaken(name) {
    for (let i = 0; i < pizzas.length; i++) {
        if ((pizzas[i].getName).localeCompare(name) === 0)
            return true;
    }
    return false;
}