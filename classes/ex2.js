/*
Create a class name Rectangle with attributes topLeftXPos, topLeftYPos, width and lenght. 
Add a method named collides(otherRectangle) that returns true only if 
the current rectangle collides with otherRectangle.

Test the collides(otherRectangle) method by using multiple test cases.
*/

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

//tests
let rect1 = new Rectangle(6,6,3,2);
