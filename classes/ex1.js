/*
Create a class named Circle with attributes xPos, yPos and radius. 
Add a method named move(xOffset, yOffset) that will adjust the position of the circle. 
Add a getter accessor named surface that will return the surface of the circle.

Test its method and accessors by modifying the values and checking if everything is consistent.
*/

class Circle{
    constructor(xPos, yPos, radius){
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    move(xOffset, yOffset){
        this.xPos += xOffset;
        this.yPos += yOffset;
    }

    get getXPos(){
        return this.xPos;
    }

    get getYPos(){
        return this.yPos;
    }

    get getRadius(){
        return this.radius;
    }

    get surface(){
        //pi * r²
        return (Math.PI * Math.pow(this.getRadius, 2));
    }
}

/*test 
let circle = new Circle(2, 3, 5);
console.log("x position : " + circle.getXPos);
console.log("y position : " + circle.getYPos);
console.log("radius : " + circle.getRadius);
console.log("surface : " + circle.surface);
console.log("Moving the circle of 4,5");
circle.move(4,5);
console.log("new x position : " + circle.getXPos);
console.log("new y position : " + circle.getYPos);
console.log("radius : " + circle.getRadius);
console.log("surface : " + circle.surface);
*/