const readlineSync = require("readline-sync");

class Point{
    constructor(x, y){
        this.x = parseInt(x);
        this.y = parseInt(y);
    }
    get getX(){
        return this.x;
    }

    get getY(){
        return this.y;
    }

    toString(){
        console.log("[" + this.getX + ";" + this.getY + "]");
    }
}

//Create a function named calcDistance which takes the coordinates of two different points 
//A and B in a 2D space. That function must return the distance between those two points.

//formula = sqrt[(Xb - Xa)²+(Yb-Ya)²]
function calcDistance(firstP, secondP){
    let pwer1 = Math.pow(secondP.getX - firstP.getX, 2);
    let pwer2 = Math.pow(secondP.getY - firstP.getY, 2);
    
    return Math.sqrt(pwer1 + pwer2);
}

//Create a program to use that function.
let xA = readlineSync.question("What's the x for the first point? ");
let yA = readlineSync.question("What's the y for the first point? ");
let pointA = new Point(xA,yA);

let xB = readlineSync.question("What(s the x for the second point? ");
let yB = readlineSync.question("What's the y for the second point? ");
let pointB = new Point(xB,yB);

console.log("Point A: " + pointA.toString());
console.log("Point B: " + pointB.toString());
console.log("Distance: " + calcDistance(pointA, pointB));