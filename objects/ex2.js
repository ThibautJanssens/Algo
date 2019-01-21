const readlineSync = require("readline-sync");
const fs = require('fs');

function askTvSerie(){
    let name = readlineSync.question("What's the name of your favourite Tv show? ");
    let productionYear = readlineSync.question("What's the production year of this show? ");
    let casts = new Array();
    let i = 0;
    let answer;
    do{
        answer = readlineSync.question("Can you give an actor starring in your show? (quit to stop entering actors.)");
        if(answer !== 'quit'){
            casts[i] = answer;
        }
        i++;
    }
    while(answer !== 'quit');
    
    let dict = {"Name" : [name], "Production Year" : [productionYear], "Cast":[casts]};
    createJson(dict);
    
    return dict;
}

/*Create a function named randomizeCast(tvSerie) that will take as argument 
the data structure you defined in the previous exercise and return a list of the same cast 
but in a random order.*/

function randomizeCast(tvSerie){
    var index, index2, value;

    console.log(tvSerie.Cast);
    console.log(tvSerie.Cast.length);

    
    for (index = tvSerie.Cast.length - 1; index > 0; index--) {
        index2 = Math.floor(Math.random() * (index + 1));
        value = tvSerie.Cast[index];
        tvSerie.Cast[index] = tvSerie.Cast[index2];
        tvSerie.Cast[index2] = value;
    }

    createJson2(tvSerie);
    return tvSerie;
}

/*Create a program that will use randomizeCast(tvSerie) and askTvSerie() 
to ask the user about a TV serie then display a randomized list of the previous cast 
that will form the new cast of your next serie.*/

function createJson(dict){
    let tvShow = JSON.stringify(dict);
    fs.writeFile('show2.json', tvShow, 'utf8', (err) => {
      if (err) throw err;
      console.log('The file has been saved!');
    });
}

function createJson2(dict){
    let tvShow = JSON.stringify(dict);
    fs.writeFile('show3.json', tvShow, 'utf8', (err) => {
      if (err) throw err;
      console.log('The file has been saved!');
    });
}

let serie = askTvSerie();
let randomize = randomizeCast(serie);