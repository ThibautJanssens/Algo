/*Create a program that will re-use the Rectangle class you created previously. 
It should generate 1000 random instances of Rectangle with random positions and sizes. 
Then it will display all colliding rectangles amongst those that were generated that way.*/
const Rectangle = require("./ex2.js");

//get random number 1-max
function rand(max){
    return Math.floor((Math.random() * parseInt(max)) + 1);
}

//generate n rectangle
function generateRectangle(n){
    var i = 0;
    var rectangles = new Array();

    while(i < n){
        var width = rand(50);
        var length = rand(50);
        var posX = rand(100);
        var posY = rand(100);
        rectangles[i] = new Rectangle(posX, posY, width, length);    
        i++;
    }
    return rectangles;
}

let rectangles = generateRectangle(1000);
console.log(rectangles);

for(var i = 0; i < rectangles.length-1; i++){
    for(var k=1; k < rectangles.length; k++){
        if(rectangles[i].collides(rectangles[k])){
            console.log("Rectangle n° " + i + " collide with rectangle n° " + k);
        }
    }
}