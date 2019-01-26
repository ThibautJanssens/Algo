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

let pizzas = {};

main();

//main function of the program
function main() {
    try{
        pizzas = loadFie("./pizzas.json");
    }
    catch{
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

        var userChoice = parseInt(readlineSync.question("Enter your action's number: "));

        switch (userChoice) {
            case 1:
                list();
                break;
            case 2:
                var newPizza = createPizza();
                add(newPizza);
                break;
            case 3:
                var oldPizza = choosePizza();
                remove(oldPizza);
                break;
            case 4:
                exit();
                break;
            default:
                console.log("\nError: not a valid option, try again.\n");
                break;
        }
    } while(true);
}

//show all the pizzas
function list() {
    pizzas.forEach(pizza => {
        console.log(pizza.toString + "\n");
    });
}

//add a pizza to the list if not already in it
function add(newPizza) {
    //TODO
    createFile(pizzas);
}

//remove a pizza from the list, if in it
function remove(oldPizza) {
    //TODO
    createFile(pizzas);
}

//quit de program
function exit() {
    console.log("See you next time.");
    process.exit(0);
}

//create a new pizza
function createPizza() {
    let newPizza;
    //TODO
    
    return newPizza;
}

//let us get a pizza from the list
function choosePizza(){
    var pizzaToRet;
    //TODO

    return pizzaToRet;
}

//create a JSON file with the list of all pizza;
function createFile(dict){
    let pizzaList = JSON.stringify(dict);
    fs.writeFile('pizza.json', pizzaList, 'utf8', (err) => {
      if (err) throw err;
      console.log('The file has been saved!');
    });
}

//read a JSON file to get the pizzas list
function loadFie(){
    var obj;
    fs.readFile('./pizza.json', 'utf8', function (err, data) {
        if (err) throw err;
        obj = JSON.parse(data);
    });
    return obj;
}