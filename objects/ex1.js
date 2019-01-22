const readlineSync = require("readline-sync");
const fs = require('fs');

/*Create a function named askTvSerie() that will ask the user for the following data 
    about its favorite TV serie:
        -Name
        -Production year
        -Names of the cast members (there can be as much as the user want)
That function must gather all the data in a single object and return it. 
The data structure must be elegant.
Create a program that use that function to generate a TV serie object 
and display it to the user in JSON format.*/
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
    let dict = {"Name" : name, "Production Year" : productionYear, "Cast":casts};

    createJson(dict);
}

function createJson(dict){
  let tvShow = JSON.stringify(dict);
  fs.writeFile('show.json', tvShow, 'utf8', (err) => {
    if (err) throw err;
    console.log('The file has been saved!');
  });
}

askTvSerie();
