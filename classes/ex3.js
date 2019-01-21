/*Create a program that will re-use the Rectangle class you created previously. 
It should generate 1000 random instances of Rectangle with random positions and sizes. 
Then it will display all colliding rectangles amongst those that were generated that way.*/

class Rectangle{
    constructor(topLeftXPos, topLeftYPos, width, length){
        this.topLeftXPos = parseInt(topLeftXPos);
        this.topLeftYPos = parseInt(topLeftYPos);
        this.width = parseInt(width);
        this.length = parseInt(length);
        this.points = {};
        this.generatePoints();
    }

    get getTopLeftXPos(){
        return this.topLeftXPos;
    }

    get getTopLeftYPos(){
        return this.topLeftYPos;
    }

    get getWidth(){
        return this.width;
    }

    get getLength(){
        return this.length;
    }

    collides(otherRectangle){
        if(this === otherRectangle)
            return true;
        if(this.points.topLeftPoint.getX > otherRectangle.points.topRightPoint.getX)
            return false;
        else if(this.points.topRightPoint.getX < otherRectangle.points.topLeftPoint.getX)
            return false;
        else if(this.points.topLeftPoint.getY < otherRectangle.points.botLeftPoint.getY)
            return false;
        else if(this.points.botLeftPoint.getY > otherRectangle.points.topLeftPoint.getY)
            return false;
        else 
            return true;
    }

    generatePoints(){
        var topLeftPoint = new Point(this.getTopLeftXPos, this.getTopLeftYPos);
        var botLeftPoint = new Point(this.getTopLeftXPos, this.getTopLeftYPos-this.getWidth);
        var topRightPoint = new Point(this.getTopLeftXPos+this.getLength, this.getTopLeftYPos);
        var botRightPoint = new Point(this.getTopLeftXPos+this.getLength, this.getTopLeftYPos-this.getWidth);
        this.points = {"topLeftPoint" : topLeftPoint, 
            "topRightPoint" : topRightPoint, 
            "botLeftPoint" : botLeftPoint, 
            "botRightPoint" : botRightPoint};
    }
}

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